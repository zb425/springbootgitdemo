package com.bgamq.springboot.designmode.factory;

public class BWM implements Car {
    @Override
    public void run() {
        System.out.println("开始启动");
    }
}
