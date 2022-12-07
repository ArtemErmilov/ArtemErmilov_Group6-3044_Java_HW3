package Homework.JAVA_HW3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
* Задача 3. Ермилов Артём группа 6|3044.
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее 
 * арифметическое этого списка.
 */

public class Java_HW3_Example003 {

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

    

    public static void main(String[] args) throws IOException, InterruptedException {
        clearConsole();

        ArrayList<Integer> numberList = new ArrayList<>(30);

        numberList = writeListNumbers(numberList,30,100);
        System.out.println(numberList.toString());

        int min = numberList.get(0);
        int max = numberList.get(0);
        int average = numberList.get(0);

        for (int index = 1; index < numberList.size(); index++) {
            if (min>numberList.get(index)) min=numberList.get(index);
            if (max<numberList.get(index)) max=numberList.get(index);
            average += numberList.get(index);  
        }
        double averageDouble =  ((double)average)/((double)numberList.size());

        System.out.printf("Минимальное значение из списка %d\n",min);
        System.out.printf("Максимальное значение из списка %d\n",max);
        System.out.printf("Среднеарифметическое значение списка %f\n",averageDouble);

        
    }
}
