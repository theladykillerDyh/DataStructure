package com.example.demo.dyh.main;
//时间复杂度
public class TimeComplexity {
    public static void main(String[] args) {

    }

    //常数阶O(1)
    private static void O1() {
        int i = 0;
        i++;
        i--;
        int j = 0;
        j++;
        System.out.println("这是一个常数阶");
    }

    //对数阶 log2n，X=logaN,那么x是以a为低，N的对数。N是真数，a是底数
    private static void log2n() {
        int i = 1;
        while (i < 100) {
            i = i * 2;
        }
        System.out.println("这是一个对数阶，2的m次方等于n，n就是while条件的限值");
    }
    //线性阶O(n)，for循环
    //线性对数阶，n*log2n 对数阶循环n次
    private static void nlog2n() {
        int n=100;
        for (int m=1;m<n;m++){
            int i = 1;
            while (i < n) {
                i = i * 2;
            }
        }

        System.out.println("这是一个对数阶，2的m次方等于n，n就是while条件的限值");
    }
    //平方阶 O(n2)  for for循环（两次for循环）
    //立方阶 O(n3)  for for for循环（三次for循环）
    //立方阶 O(nk)  k次for循环
    //指数阶2n ,2的n次方

    //一般讨论的时间复杂度是讨论的最坏时间复杂度
}
