package com.github.fkl;

import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kanglefan on 17-6-7.
 */
public class SubT extends T {

//    @Override
//    public void run() {
//        System.out.println("hello");
//    }
//
//    public static void main(String[] args) {
//        SubT subT = new SubT();
//        subT.start();
//    }

    public static Integer b = a;

    public static void main(String[] args) throws Exception {
        System.out.println(b);

        String path = SubT.class.getName().replace('.', '/') + ".class";
        Enumeration<URL> urls = T.class.getClassLoader().getResources(path);
        Set<String> files = new HashSet<String>();
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            if (url != null) {
                String file = url.getFile();
                System.out.println(file);
                if (file != null && file.length() > 0) {
                    files.add(file);
                }
            }
        }
        if (files.size() > 1) {
            System.out.println("Duplicate class " + path + " in " + files.size() + " jar " + files);
        }
    }
}
