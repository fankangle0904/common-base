package com.github.fkl.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kanglefan on 17-4-26.
 */
public class AutoIncrementIdGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(AutoIncrementIdGenerator.class);
    private static final String AUTO_INCREASE_ID_KEY = "auto_increase_id_key";
    private volatile AtomicLong currentId;
    private volatile AtomicInteger availableAmount;
    // 单次拉取数量
    private int onceFetchAmount = 1000;

    public AutoIncrementIdGenerator() {
        this.currentId = new AtomicLong();
        this.availableAmount = new AtomicInteger();
    }

    public long getNewId() {
        int available = availableAmount.get();
        if (available <= 0) {
            LOG.debug("availableAmount less than zero. fetch new ids.");
            available = fetchNewIds();
        }
        if (available > 0) {
            availableAmount.decrementAndGet();
            return currentId.incrementAndGet();
        }
        throw new RuntimeException("getNewId exception");
    }

    protected synchronized int fetchNewIds() {
        if (availableAmount.get() > 0) {
            LOG.debug("The ids fetch operation shall be terminated.");
            return availableAmount.get();
        }
        int retry = 0;
        while (retry++ < 3) {
            try {
                long maxIdAfterFetch = incrBy(AUTO_INCREASE_ID_KEY, onceFetchAmount);
                currentId = new AtomicLong(maxIdAfterFetch - onceFetchAmount);
                availableAmount = new AtomicInteger(onceFetchAmount);
                return availableAmount.get();
            } catch (Exception e) {
                LOG.error("new ids fetch error, retry:{}", retry, e);
            }
        }
        throw new RuntimeException("fetchNewIds exception");
    }

    protected long incrBy(String autoIncreaseIdKey, int onceFetchAmount) {
        return currentId.get() + onceFetchAmount;
    }

    public static void main(String[] args) {
        final AutoIncrementIdGenerator generator = new AutoIncrementIdGenerator();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + generator.getNewId());
                }
            }
        }, "thread-1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + generator.getNewId());
                }
            }
        }, "thread-2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + generator.getNewId());
                }
            }
        }, "thread-3").start();
    }
}
