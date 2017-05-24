package com.github.fkl.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by kanglefan on 17-4-24.
 */
public class DateUtil {

    public static int convertWeekDayToBits(String weekDay) {
        int num = 0;
        if (!StringUtils.isEmpty(weekDay)) {
            for (char c : weekDay.toCharArray()) {
                if (c < '1' || c > '7')
                    continue;
                int i = c - '1';
                num |= 1 << i;
            }
        }
        return num;
    }
}