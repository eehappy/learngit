package com.beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Administrator on 2017/3/8.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if("car".equals(s)){
            Car car = (Car)o;
            if(((Car) o).getColor()==null){
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization...color设置为默认黑色");
                car.setColor("black");
            }
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if("car".equals(s)){
            Car car = (Car)o;
            if(((Car) o).getMaxSpeed()>=200){
                System.out.println("调用BeanPostProcessor.postProcessAfterInitialization...maxSpeed调整为200");
                car.setMaxSpeed(200);
            }
        }
        return o;
    }
}
