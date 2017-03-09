package com.beanTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by Administrator on 2017/3/8.
 */
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
    private String brand;
    private String color;
    private int maxSpeed;
    private BeanFactory beanFactory;
    private String beanName;
    public Car() {
        System.out.println("调用car的构造函数");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand（）设置属性");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void introduce(){
        System.out.println("brand:"+brand+"color:"+color+"maxSpeed:"+maxSpeed);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()...");
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName()...");
        this.beanName = beanName;
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy()...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("调用Initializing.afterPropertiesSet()...");
    }

    public void myInit(){
        System.out.println("调用init-method所指定的myInit(),奖maxSpeed设置为4000");
    }
    public void myDestroy(){
        System.out.println("调用destroy-method所指定的myDestroy（）。。");
    }
}
