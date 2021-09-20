package com.chong.algorithm;

public class SparseArray {
    public static void main(String[] args) {
        // 11*11 二维数组
        int[][] arr = new int[11][11];
        arr[2][1] = 1;
        arr[3][2] = 2;
        arr[4][5] = 2;
        //
        for (int[] data : arr) {
            for (int item : data) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        // 遍历得到有效数据总数
        int effectElement = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    effectElement++;
                }
            }
        }
        System.out.println("有效元素总数为：" +effectElement);
        // 转换为稀疏数组
        // 1.原数组有11行11列，2个有效数据
        // 11 11 2
        // 2  1  1
        // 3  2  2
        // 创建稀疏数组
        int[][] spareArray = new int[effectElement+1][3];
        spareArray[0][0] = arr[0].length;
        spareArray[0][1] = arr.length;
        spareArray[0][2] = effectElement;

        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                if(arr[i][i1]!=0){
                    spareArray[index][0]= i;
                    spareArray[index][1]= i1;
                    spareArray[index][2]= arr[i][i1];
                    index++;
                }
                System.out.println();
            }

        }
        // 转换后的稀疏数组为
        for (int[] ints : spareArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        for (int[] ints : spareArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        // 稀疏数组还原数组
        int[][] backArray = new int[spareArray[0][0]][spareArray[0][1]];
        for (int i = 1; i < spareArray.length; i++) {
            backArray[spareArray[i][0]][spareArray[i][1]] = spareArray[i][2];
        }
        // 还原后数组为
        for (int[] ints : backArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        System.out.println(spareArray.length);
        System.out.println(spareArray[0].length);

    }
}
