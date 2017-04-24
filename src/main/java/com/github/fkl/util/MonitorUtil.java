package com.github.fkl.util;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 监控工具类
 * <p/>
 * Created by kanglefan on 17-4-24.
 */
public class MonitorUtil {

    private static final Logger LOG = LoggerFactory.getLogger(MonitorUtil.class);

    public static void monitorTime(String name, Stopwatch stopwatch) {
        long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        String nameFormatted = makeName(name);
        LOG.info("{}:{}", nameFormatted, elapsed);
        //TODO 监控调用
        stopwatch.reset().start();
    }

    private static String makeName(String name) {
        return name.replaceAll(" ", "_");
    }
}
