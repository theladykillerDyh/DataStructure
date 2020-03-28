package com.example.demo.dyh.main.list;

public class SparseArray {

	public static void main(String[] args) {
		// 初始化二维数组
		int arrayNormal[][] = new int[11][11];
		arrayNormal[1][2] = 11;
		arrayNormal[2][3] = 9;
		arrayNormal[6][9] = 32;
		System.out.println("初始化数组！！！");
		printArray(arrayNormal);
		System.out.println("生成稀疏数组！！！");
		int sparseArray[][] = getSparseArray(arrayNormal);
		printArray(sparseArray);
		System.out.println("还原数组！！！");
		int arrayNormal1[][] = recoverArray(sparseArray);
		printArray(arrayNormal1);
	}

	private static void printArray(int[][] array2) {
		for (int[] array1 : array2) {
			for (int value : array1) {
				System.out.printf("%4d", value);
			}
			System.out.println();
		}
	}

	private static int[][] recoverArray(int[][] sparseArray) {
		int[][] arrayNormal = new int[sparseArray[0][0]][sparseArray[0][1]];
		for (int i = 1; i < sparseArray.length; i++) {
			int a=sparseArray[i][0];
			int b=sparseArray[i][1];
			int c=sparseArray[i][2];
			arrayNormal[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		return arrayNormal;
	}

	private static int[][] getSparseArray(int[][] arrayNormal) {
		int row = arrayNormal.length;
		int cel = arrayNormal[0].length;
		int count = 0;
		// 计算稀疏数组行数
		for (int[] is : arrayNormal) {
			for (int value : is) {
				if (value != 0) {
					count++;
				}
			}
		}
		// 初始化稀疏数组
		int[][] sparseArray = new int[count + 1][3];
		sparseArray[0][0] = row;
		sparseArray[0][1] = cel;
		sparseArray[0][2] = count;
		// 稀疏数组赋值
		int k = 1;
		for (int i = 0; i < arrayNormal.length; i++) {
			for (int j = 0; j < arrayNormal[i].length; j++) {
				if (arrayNormal[i][j] != 0) {
					sparseArray[k][0] = i;
					sparseArray[k][1] = j;
					sparseArray[k][2] = arrayNormal[i][j];
					k++;
				}
			}

		}

		return sparseArray;
	}

}
