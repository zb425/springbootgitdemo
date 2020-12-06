package com.bgamq.springboot.spring;

import com.bgamq.springboot.entity.User;
import com.bgamq.springboot.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);

        String[] names = context.getBeanDefinitionNames();

        //UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        for (String name : names) {

            System.out.println(name);
        }

       // System.out.println(userService.toString());


    }
}
