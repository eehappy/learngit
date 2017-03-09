package com.beanTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * Created by Administrator on 2017/3/9.
 */
public class BeanLifeStyle {
    public static void lifeCycleInBeanFactory(){
        Resource res = new FileSystemResource("web/WEB-INF/applicationContext-conf.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstatonAwareBeanPostProcessor());
        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        Car car2 = (Car)bf.getBean("car");

        System.out.println("car1==car2:"+(car1==car2));
        ((XmlBeanFactory)bf).destroySingletons();
    }
    public static void main(String args[]){
        lifeCycleInBeanFactory();
    }
}
