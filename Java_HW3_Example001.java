package Homework.JAVA_HW3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * Задача 1 Ермилов Артём, группа 6|3044.
 * Реализовать алгоритм сортировки слиянием.
 */

public class Java_HW3_Example001 {
    private static void clearConsole () throws IOException, InterruptedException
    { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Очистка консоли

    }

    private static void SortUnsorted(int[] a, int lo, int hi)// Сортировка слиянием
     {

        if (hi <= lo)
        return;
    int mid = lo + (hi - lo) / 2;
    SortUnsorted(a, lo, mid);
    SortUnsorted(a, mid + 1, hi);

    int[] buf = Arrays.copyOf(a, a.length);

    for (int k = lo; k <= hi; k++)
        buf[k] = a[k];

    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {

        if (i > mid) {
            a[k] = buf[j];
            j++;
        } else if (j > hi) {
            a[k] = buf[i];
            i++;
        } else if (buf[j] < buf[i]) {
            a[k] = buf[j];
            j++;
        } else {
            a[k] = buf[i];
            i++;
        }
    }

    }
    private static int[] writeArrayNumbers( int maxlengthArray, int maxNumber) {
        Random random = new Random();
        int [] numberArray = new int[maxlengthArray];

        for (int i = 0; i < numberArray.length; i++) // Заполнение списка случайными числами
        {

            numberArray[i]=random.nextInt(maxNumber);

        }
        return  numberArray;
    }

    private static void printArray(int[] numberArray) {
        
        System.out.print("[ ");
        for (int i = 0; i < numberArray.length-1; i++) {
            System.out.print(numberArray[i]+", ");
        }
        System.out.println(numberArray[numberArray.length-1]+" ]");
        
        
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        clearConsole ();
        int [] numberArray = new int[30];

        numberArray = writeArrayNumbers( 30, 100);
        
        printArray(numberArray);
        SortUnsorted(numberArray, 0, numberArray.length-1);
        printArray(numberArray);
    }
    
}
