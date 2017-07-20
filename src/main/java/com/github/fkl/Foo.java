package com.github.fkl;

/**
 * Created by kanglefan on 17-7-13.
 */
public class Foo {

    private Foo() {

    }

    static {
        // 主类的静态块，在该类加载时运行
        System.out.println("外部类被加载");
    }
    public int a;
    public static int b = 22;

    // 私有静态内部类, 只有当有引用时, 该类才会被装载
    private static class LazyFoo {
        static {
            // 内部类的静态块，在该类加载时运行
            System.out.println("内部类被加载Foo.b = " + Foo.b);
        }
        public static Foo foo = new Foo();

    }

    public static Foo getInstance() {
        return LazyFoo.foo;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return this.a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Foo.b); // 运行这句，可以看到外部类已加载，但内部类为加载。
        Foo a = Foo.getInstance(); //注销上面那句，运行这句，可以发现Foo类和其内部类都被加载。原因就如楼上所说，所有类都是被引用才加载。

    }
}