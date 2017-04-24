package com.github.fkl.component;

/**
 * 参考：Twitter-Snowflake算法
 * Href:http://www.cnblogs.com/relucent/p/4955340.html
 * <p/>
 * Created by kanglefan on 17-4-24.
 */
public class UniqueIdGenerator {

    private final long initTimestamp = 1483200000000L;

    private final long datacenterIdBits = 5L;

    private final long workerIdBits = 5L;

    private final long maxDatacenterId = ~(-1L << datacenterIdBits);

    private final long maxWorkerId = ~(-1L << workerIdBits);

    private final long sequenceBits = 12L;

    private final long workerIdShift = sequenceBits;

    private final long datacenterIdShift = sequenceBits + workerIdBits;

    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    private final long sequenceMask = ~(-1L << sequenceBits);

    private long workerId;

    private long datacenterId;

    private long sequence = 0L;

    private long lastTimestamp = -1L;

    public UniqueIdGenerator(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("workerId can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenterId can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;

        System.out.println(Long.toBinaryString((timestamp - initTimestamp) << timestampLeftShift));
        System.out.println(Long.toBinaryString(datacenterId << datacenterIdShift));
        System.out.println(Long.toBinaryString(workerId << workerIdShift));
        System.out.println(Long.toBinaryString(sequence));

        return ((timestamp - initTimestamp) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        UniqueIdGenerator idGenerator = new UniqueIdGenerator(0, 0);
        for (int i = 0; i < 10; i++) {
            long id = idGenerator.nextId();
            System.out.println(String.format("%d, %s", id, Long.toBinaryString(id)));
        }
    }
}