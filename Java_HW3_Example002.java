package Homework.JAVA_HW3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/*
 * Задача 2 Ермилов Артём, группа 6|3044.
 * 	Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
 */

public class Java_HW3_Example002 {
    private static void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Очистка консоли

    }

    private static ArrayList writeListNumbers(ArrayList<Integer> numberList, int maxlengthList, int maxNumber) {
        Random random = new Random();

        for (int i = 0; i < maxlengthList; i++) // Заполнение списка случайными числами
        {

            numberList.add(random.nextInt(maxNumber));

        }
        return numberList;
    }

    private static ArrayList removeEvenNumbers(ArrayList<Integer> numberList) {
        for (int i = 0; i < numberList.size(); i++) // Удаление из списка чётных чисел.
        {
            if (numberList.get(i) % 2 == 0) {
                numberList.remove(i);
                i--;
            }

        }
        return numberList;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        clearConsole();

        ArrayList<Integer> numberList = new ArrayList<>(30);

        numberList = writeListNumbers(numberList, 30, 100);

        System.out.println(numberList.toString());

        numberList = removeEvenNumbers(numberList);
        System.out.println(numberList.toString());

    }

}
