package com.zys.divinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author: zys
 * @date: 2019/6/10 22:25
 */
@Service
@Profile("Java7")
public class Java7CalculateServiceImpl implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        Integer sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        System.out.println("Java7 sum ....");
        return sum;
    }

    public static void main(String[] args) {
        CalculateService java7CalculateService = new Java7CalculateServiceImpl();
        System.out.println(java7CalculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
