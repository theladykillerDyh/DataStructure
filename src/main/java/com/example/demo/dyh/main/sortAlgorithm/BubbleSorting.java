package com.example.demo.dyh.main.sortAlgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

//冒泡排序
public class BubbleSorting {
    private static final Logger logger = LoggerFactory.getLogger(BubbleSorting.class);

    public static void main(String[] args) {

        List<Integer> bubbleList = new ArrayList<>();
        bubbleList.add(2);
        bubbleList.add(3);
        bubbleList.add(-1);
        bubbleList.add(99);
        bubbleList.add(3);
        bubbleList.add(343);
        bubbleList.add(1);
        logger.error("bubbleList:{}", bubbleList);
        for (int i=0;i<bubbleList.size();i++){
            for (int j=i+1;j<bubbleList.size();j++){
                if (bubbleList.get(j)<bubbleList.get(i)){
                    Integer temp=bubbleList.get(i);
                    bubbleList.set(i,bubbleList.get(j));
                    bubbleList.set(j,temp);
                }
            }
        }
        logger.error("bubbleList:{}", bubbleList);

    }
}
