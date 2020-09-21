package com.bgamq.springboot.designmode.factory;

public class BWMFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new BWM();
    }
}
