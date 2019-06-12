package com.zys.divinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author: zys
 * @date: 2019/6/10 22:25
 */
@Service
@Profile("Java8")
public class Java8CalculateServiceImpl implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java8 sum ....");
        return Stream.of(values).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java8CalculateServiceImpl();
        System.out.println(calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
