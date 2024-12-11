/*
 * @Description: 九九乘法表/Java基础考试题
 * @Author: FallCicada
 * @Date: 2024-12-06 14:39:23
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-12-06 14:39:23
 * @Slogan: 無限進步
 */
public class multiplication_table {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
                if (j == i) {
                    System.out.println();
                }
            }
        }
    }
}