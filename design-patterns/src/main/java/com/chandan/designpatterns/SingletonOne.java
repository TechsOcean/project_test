package com.chandan.designpatterns;

public class SingletonOne {

    public static SingletonOne singletonOne = new SingletonOne();

    private SingletonOne() {

    }

    public SingletonOne getSingletonOne() {
        return singletonOne;
    }

    public SingletonOne methodOne() {
        System.out.println(" SingletonOne class -- "+singletonOne.hashCode());
        return singletonOne;
    }
}
