package top.pancras.剑指offer;

/**
 * Created by pancras on 2018/4/27 0027.
 */
//题目：设计一个类，我们只能生成该类的一个实例
//分析：考察单例模式的写法
public class Test02 {
    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton6.instance == Singleton6.instance);
    }
}

//饿汉式， 线程安全。有点实现简单，缺点会提前初始化对象，总体来说推荐
class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return instance;
    }
}

//懒汉式，线程不安全，不推荐
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if(instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

//懒汉式，线程安全，效率低，不推荐
class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {
        if(instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

//懒汉式，线程安全，效率比Singleton2高，推荐
class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {}

    public static Singleton4 getInstance() {
        if(instance == null) {
            synchronized (Singleton4.class) {
                if(instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

//登记式静态内部类，线程安全，推荐
class Singleton5 {
    //内部类只是在编写阶段有嵌套关系，对于JVM来说它们都是独立的类，只有在被调用时才会初始化
    private static class SingletonHelper{
        public static final Singleton5 instance = new Singleton5();
    }

    private Singleton5() {

    }

    public static final Singleton5 getInstance() {
      return SingletonHelper.instance;
    }
}

//枚举方式,线程安全，绝对防止多次实例化。
enum Singleton6 {
    instance;

    private Singleton6() {}
}
