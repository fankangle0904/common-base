package com.github.fkl;

import com.github.fkl.bean.QuoteInfo;
import com.github.fkl.bean.Test;
import com.github.fkl.util.DateUtil;
import com.github.fkl.util.JsonUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by kanglefan on 17-4-21.
 */
public class T {

    // Class对象是用来创建对象的对象

    // 类构造器<clinit>()方法与实例构造器<init>()不同
    // <clinit>()方法不是必须的，若类中没有静态语句块，没有对类变量的赋值操作，则编译器可以不为这个类生成<clinit>()方法
    // 虚拟机可保证一个类的<clinit>()方法在多线程环境下正确的加锁和同步
    // static变量和static语句块按出现顺序执行

    // 准备阶段-为类变量分配内存并设置类变量的初始化值
    static {
        a = 1;
    }

    public static Integer a = 0;

    public static void main(String[] args) throws Exception {
//        OutputStream os = System.out;
//        ObjectOutputStream oos = new ObjectOutputStream(os);
//        Test a = new Test();
//        a.setTestA("aaa");
//        a.setTestB("bbb");
//        oos.writeObject(a);
//        oos.close();
//
//        InputStream is = System.in;
//        ObjectInputStream ois = new ObjectInputStream(is);
//        ois.readObject();
//        ois.close();
//
//        List<String> list = Lists.newArrayList();
//        Collections.shuffle(list);
//
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        arrayList.getClass().getMethod("add", Object.class).invoke(arrayList, "abc");

//        Map<Test, String> map = new HashMap<Test, String>();
//
//        Test a = new Test();
//        a.setTestA("a");
//
//        Test b = new Test();
//        b.setTestA("a");
//
//        map.put(a, "aaa");
//        map.put(b, "bbb");
//
//        a.setTestB("b");
//        System.out.println(map.size() + " " + map.get(a));

//        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(16, 0.75F, true);
//        linkedHashMap.put("1", "1");
//        linkedHashMap.put("2", "2");
//        linkedHashMap.put("3", "3");
//        linkedHashMap.put("4", "4");
//        linkedHashMap.put("5", "5");
//
//        linkedHashMap.get("1");
//        linkedHashMap.get("4");
//        linkedHashMap.get("3");
//
//        linkedHashMap.put("6", "6");
//
//        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
//        for (Map.Entry<String, String> entry : set) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

//        String json = "[{\"coverage\":10000,\"riskCode\":\"QB101\",\"riskName\":\"车上人员责任险（司机）\"},{\"coverage\":null,\"riskCode\":\"QB100\",\"riskName\":\"全车盗抢保险\"},{\"coverage\":10000,\"riskCode\":\"QB102\",\"riskName\":\"车上人员责任险（乘客）\"},{\"coverage\":300000,\"riskCode\":\"QB001\",\"riskName\":\"第三者责任保险\"},{\"coverage\":null,\"riskCode\":\"QB000\",\"riskName\":\"机动车损失保险\"},{\"coverage\":null,\"riskCode\":\"QF000\",\"riskName\":\"\"}]";
//
//        List<QuoteInfo> quoteInfoList = new ArrayList<QuoteInfo>();
//        List<QuoteInfo> aa = JsonUtil.decode(json, quoteInfoList.getClass());
//        QuoteInfo bb = aa.get(0);
//        System.out.println(bb.getRiskType());

//        Date date = calcNextBeginDate(DateTime.parse("2016-04-16 00:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate());
//        System.out.println(date);
//
//        Date a = new Date();
//        add(a, Calendar.DAY_OF_YEAR, 1);

//        Date a = DateTime.parse("2011-04-16 00:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
//        System.out.println(addYears(a, -5));
//        Date nowDate = DateTime.parse("2017-12-18 00:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
//        System.out.println(calNextBeginDate(DateTime.parse("2015-02-19 00:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate(), nowDate));

//        List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
//        list.add(new ImmutablePair<String, String>("2017-05-18 00:00:00", "2017-07-18 00:00:00"));
//        list.add(new ImmutablePair<String, String>("2016-06-18 00:00:00", "2017-05-18 00:00:00"));
//        list.add(new ImmutablePair<String, String>("2015-05-18 00:00:00", "2017-07-18 00:00:00"));
//        list.add(new ImmutablePair<String, String>("2015-12-18 00:00:00", "2017-01-18 00:00:00"));
//        list.add(new ImmutablePair<String, String>("2016-12-18 00:00:00", "2017-01-18 00:00:00"));
//        list.add(new ImmutablePair<String, String>("2016-10-18 00:00:00", "2017-03-18 00:00:00"));
//        for (Pair<String, String> pair : list) {
//            System.out.println(calNextBeginDate(parse(pair.getLeft()), parse(pair.getRight())));
//        }

        System.out.println(String.valueOf(false));
    }

    private static Date parse(String date) {
        return DateTime.parse(date, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
    }

    private static Date calcNextBeginDate(Date currentBeginDate) {
        Date current = new Date();
        current.setHours(0);
        current.setMinutes(0);
        current.setSeconds(0);
        Date beginDate = new Date(currentBeginDate.getTime());
        beginDate.setYear(current.getYear());
        // 比较月日, 在当前月日之前(包括等于)加一年加一天, 否则加一天
        if (!beginDate.after(current)) {
            // if (!DateUtil.isAfter(beginDate, current)) {
            if (current.getTime() - beginDate.getTime() < 7776000000L) {
                return add(current, Calendar.DAY_OF_YEAR, 1);
            } else {
                return addYears(beginDate, 1);
            }
        }
        return beginDate;
    }

    public static Date addYears(Date date, int years) {
        return add(date, Calendar.YEAR, years);
    }

    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static Date addDates(Date date, int days){
        return add(date, Calendar.DAY_OF_YEAR, days);
    }

    private static Date deduceBeginDate(Date registerDate, Date current) {
        if (registerDate == null) {
            return null;
        }

        Date regDate = new Date(registerDate.getTime());
        regDate.setYear(current.getYear());

        // 注册日期+90天>当前日期>=注册日期，使用当前日期+1作为起保日期的默认，年份取2016（当年）
        if (!current.before(regDate)) {
            if (current.before(addDates(regDate, 90))) {
                return addDates(current, 1);
            } else {
                return addYears(regDate, 1);
            }
        }

        // 当前日期+60天>注册日期>当前日期，使用注册日期+1作为起保日期的默认，年份取2016（当年）
        if (regDate.after(current) && regDate.before(addDates(current, 60))) {
            return addDates(regDate, 1);
        }

        // 注册日期>=当前日期+60天，使用当前日期+1作为起保日期的默认，年份取2016（当年）
        if (!regDate.before(addDates(current, 60))) {
            return addDates(current, 1);
        }

        return null;
    }

    private static Date calNextBeginDate(Date insStartDate, Date nowDate) {
        Date xStartDate = new Date(insStartDate.getTime());
        if (xStartDate.after(addYears(nowDate, -1))) {
            return addYears(xStartDate, 1);
        }
        Date yStartDate = addYears(xStartDate, 1);
        while (!yStartDate.after(addYears(nowDate, -1))) {
            yStartDate = addYears(yStartDate, 1);
        }
        if (!nowDate.after(addDates(yStartDate, 90))) {
            return addDates(nowDate, 1);
        }
        return addYears(yStartDate, 1);

//        if (nowDate.before(yStartDate)) {
//            if (nowDate.before(addDates(yStartDate, -90))) {
//                System.out.println("未到可续保期");
//                return yStartDate;
//            } else {
//                System.out.println("当前保单未到期，但在可续保期内");
//                return yStartDate;
//            }
//        } else {
//            if (!nowDate.after(addDates(yStartDate, 90))) {
//                System.out.println("脱保期不超过90天，可能已脱保");
//                return addDates(nowDate, 1);
//            } else {
//                System.out.println("脱保期超出90天，认为已续保");
//                return addYears(yStartDate, 1);
//            }
//        }

//        Date xStartDate = new Date(insStartDate.getTime());
//        int i = 0;
//        while (true) {
//            if ((xStartDate = addYears(xStartDate, i++)).getYear() >= nowDate.getYear() - 1) {
//                break;
//            }
//        }
//        System.out.println(xStartDate);
//        // 保期正常结束时间
//        Date xStartDateNextYear = addYears(xStartDate, 1);
//        if (nowDate.before(xStartDateNextYear)) {
//            if (nowDate.before(addDates(xStartDateNextYear, -90))) {
//                // 未到可续保期
//                System.out.println("未到可续保期");
//                return xStartDateNextYear;
//            } else {
//                System.out.println("当前保单未到期，但在可续保期内");
//                // 当前保单未到期，但在可续保期内
//                return xStartDateNextYear;
//            }
//        } else {
//            if (!nowDate.after(addDates(xStartDateNextYear, 90))) {
//                System.out.println("脱保期不超过90天，可能已脱保");
//                // 脱保期不超过90天，可能已脱保
//                return addDates(nowDate, 1);
//            } else {
//                // 脱保期超出90天，认为已续保
//                System.out.println("脱保期超出90天，认为已续保");
//                return xStartDateNextYear.getMonth() < nowDate.getMonth() ? addYears(xStartDateNextYear, 1) : xStartDateNextYear;
//            }
//        }
    }
}
