package com.beanTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by Administrator on 2017/3/8.
 */
public class MyInstatonAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    /**
     * 接口方法，在实例化bean之前调用
     */
    public Object postProcessBeforeInstantiation(Object bean, String beanName) throws BeansException {
        //仅对容器中的car Bean进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationgAware BeanProcessor.postProcessBeforeInstantiation..");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        //仅对容器中的car Bean进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationgAware BeanProcessor.postProcess AfterInstantiation..");
        }
        return true;
    }
    //在设置某个属性时调用
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
       //仅对容器中的car bean进行处理，还可以通过pdst入参进行过滤)
        if("car".equals(beanName)){
            System.out.println("Instanitation AwareBeanPostProcessor.postProcessPropertyValues..");
        }
        return pvs;
    }
}
