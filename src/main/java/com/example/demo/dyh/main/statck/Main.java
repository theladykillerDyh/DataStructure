package com.example.demo.dyh.main.statck;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanon( 3, 'a', 'b', 'c');
	}
    /** 
     * 递归方法hanon，求汉诺塔算法 
     *  
     * @param num 
     */  
    public static void hanon(int n, char a, char b, char c) {  
        if (n == 1) {  
            move(1, a, c);// 最后一种情况是，把A柱子上盘子移到C柱子上。  
            return;  
        }  
        hanon(n - 1, a, c, b); // 递归，把n-1个盘子从A 盘上借助C盘移到B盘上  
        move(n, a, c);// 调用move()方法  
        hanon(n - 1, b, a, c);// 递归，把把n-1个盘子从B盘上借助A盘移到C盘上  
    }  
  
    public static void move(int n, char a, char c) {  
        System.out.println(n + ":" + a + "-->" + c);// 打印移动盘子情况  
    }  
  
  

}
