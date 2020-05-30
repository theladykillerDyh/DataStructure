package com.example.demo.dyh.main.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dyh
 * @createTime 2020/5/31 5:29
 * @describe 八皇后问题解答
 */
public class EightQueen {
    private static final int QUEEN_NUM = 8;
    private static int[] queenArr = new int[QUEEN_NUM];
    private static final Logger logger= LoggerFactory.getLogger(EightQueen.class);
    public static void main(String[] args) {
        check(0);
    }

    private static void check(int n){
        if (n==8){
            //已经放置了8个皇后
            logger.info("放置皇后数组：｛｝",queenArr);
            return;
        }
        for (int i=0;i<QUEEN_NUM;i++){
            //将第n个皇后放入第n列
            queenArr[n]=i;
            if (judge(n)){
                check(n+1);
            }
            //如果第i列放置失败，直接放入i+i列
        }
    }

    //检测第n个皇后和前面的皇后是否冲突
    private static boolean judge(int n) {
        for (int i = 0; i < queenArr.length; i++) {
            //QUEEN_ARR[i]==QUEEN_ARR[n]表示在同一行
            //Math.abs(i-n)==Math.abs(QUEEN_ARR[i]-QUEEN_ARR[n]) 行的差值等于列的差值，表示在同一斜线(直角等腰三角形的夹角为45度)
            if (queenArr[i] == queenArr[n] || Math.abs(i - n) == Math.abs(queenArr[i] - queenArr[n])) {
                return false;
            }
        }
        return true;
    }
}
