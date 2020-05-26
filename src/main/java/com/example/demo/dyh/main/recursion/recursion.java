package com.example.demo.dyh.main.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//递归
public class recursion {
    private static final Logger logger = LoggerFactory.getLogger(recursion.class);

    public static void main(String[] args) {
        test(5);
    }

    private static void test(int n) {
        if (n > 1) {
            test(n - 1);
        }
        logger.error("n={}",n);
    }
}
