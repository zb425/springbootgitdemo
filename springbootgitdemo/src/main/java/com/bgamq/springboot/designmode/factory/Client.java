package com.bgamq.springboot.designmode.factory;

public class Client {
    public static void main(String[] args) {

        CarFactory factory = new BWMFactory();
        Car car = factory.getCar();
        car.run();

    }
}
