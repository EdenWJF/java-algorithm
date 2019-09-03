package com.jinfour.samples;

public class Interview_02 {
    //实现单例模式
    private Interview_02() {

    }

    //内部静态类
    public static Interview_02 getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static Interview_02 instance = new Interview_02();
    }

    //双重加锁检查
    private volatile static Interview_02 instance2 = null;
    public static Interview_02 getInstance2() {
        if (instance2 == null) {
            synchronized (Interview_02.class) {
                if (instance2 == null) {
                    instance2 = new Interview_02();
                }
            }
        }
        return instance2;
    }

}
