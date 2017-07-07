package com.github.fkl.bean;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by kanglefan on 17-5-24.
 */
public class Test implements Serializable, Comparable<Test> {

    private String testA;

    private String testB;

    public String getTestB() {
        return testB;
    }

    public void setTestB(String testB) {
        this.testB = testB;
    }

    public String getTestA() {
        return testA;
    }

    public void setTestA(String testA) {
        this.testA = testA;
    }

    @Override
    public int compareTo(Test o) {
        return testA.compareTo(testB);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
//        return sun.misc.Hashing.stringHash32(testA);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Test)) {
            return false;
        }
        return StringUtils.equals(testA, ((Test)obj).getTestA());
    }
}
