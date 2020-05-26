package com.example.demo.dyh.main.recursion;

import java.util.Map;

public class Maze {
    public static void main(String[] args) {
        int[][] map=new int[10][10];
        showMap(map,10,10);
        initMap(map,10,10);
        showMap(map,10,10);
        findWay(map,1,1);
    }
    private static void initMap(int[][] map,int mapi,int mapj){
        for (int i=0;i<mapi;i++){
            map[i][0]=1;
            map[i][9]=1;
        }

        for (int j=0;j<mapj;j++){
            map[0][j]=1;
            map[9][j]=1;
            map[5][j]=1;
        }
        map[5][8]=0;
        map[1][6]=1;
        map[2][6]=1;
        map[3][6]=1;
        map[8][7]=1;


    }

    private static void showMap(int[][] map,int mapi,int mapj){
        System.out.println("map如下所示");
        for (int i=0;i<mapi;i++){
            for (int j=0;j<mapj;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //1代表墙，2代表通路，3代表走过不通
    private static boolean findWay(int[][] map,int i,int j){
        showMap(map,10,10);
        if (map[8][8]==2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (findWay(map,i,j+1)){
                    return true;
                }else if (findWay(map,i+1,j)){
                    return true;
                }else if (findWay(map,i,j-1)){
                    return true;
                }else if (findWay(map,i-1,j)){
                    return true;
                }
                map[i][j]=3;
                return false;
            }else {
                return false;
            }
        }


    }
}
