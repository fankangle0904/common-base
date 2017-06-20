package com.github.fkl;

import com.github.fkl.bean.Test;
import com.google.common.collect.Lists;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by kanglefan on 17-4-21.
 */
public class T {
    public static void main(String[] args) throws Exception {
        OutputStream os = System.out;
        ObjectOutputStream oos = new ObjectOutputStream(os);
        Test a = new Test();
        a.setTestA("aaa");
        a.setTestB("bbb");
        oos.writeObject(a);
        oos.close();

        InputStream is = System.in;
        ObjectInputStream ois = new ObjectInputStream(is);
        ois.readObject();
        ois.close();

        List<String> list = Lists.newArrayList();
        Collections.shuffle(list);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.getClass().getMethod("add", Object.class).invoke(arrayList, "abc");
    }
}
