package Homework.JAVA_HW3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Задача 4 Ермилов Артём, группа 6|3044.
 * 
 * Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
Разность:
A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
B - A = все числа из второй коллекции, которые не содержатся в первой
Симметрическая разность:
A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой

 * 
 */

public class Java_HW3_Example004 {
    private static void clearConsole () throws IOException, InterruptedException
    { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Очистка консоли

    }

    private static ArrayList differenceMultiplicity( ArrayList<Integer> listA,ArrayList<Integer> listB) //Разность
    {
        ArrayList<Integer> differenceList = new ArrayList<Integer>();
        ArrayList<Integer> newListB = new ArrayList<Integer>();
        for (int index = 0; index < listB.size(); index++) {
            newListB.add(listB.get(index));
            
        }
        
        
        for (int i = 0; i < listA.size(); i++) {
            boolean temp = false;
            for (int j = 0; j < newListB.size(); j++) {

                if (listA.get(i).equals(newListB.get(j))&& temp == false)
                {
                    temp = true;
                    newListB.remove(j);
                    j--;
                                
                }
            }
           if (temp==false) differenceList.add(listA.get(i));
        }

        return differenceList;
    }

    private static ArrayList differenceSymmetricMultiplicity( ArrayList<Integer> listA,ArrayList<Integer> listB)// Симметрическая разность
    {
        
        ArrayList<Integer> differenceAB = new ArrayList<>();
        ArrayList<Integer> differenceBA = new ArrayList<>();

        differenceAB= differenceMultiplicity(listA,listB);
        differenceBA= differenceMultiplicity(listB,listA);

        differenceBA.addAll(differenceAB);

        return differenceBA;

    }

    private static ArrayList writeListNumbers( int maxlengthList, int maxNumber) {
        Random random = new Random();
        ArrayList<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < maxlengthList; i++) // Заполнение списка случайными числами
        {

            numberList.add(random.nextInt(maxNumber));

        }
        return numberList;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        clearConsole ();

        ArrayList listA = new ArrayList<>();
        ArrayList listB = new ArrayList<>();
        ArrayList differenceListAB = new ArrayList<>();
        ArrayList differenceListBA = new ArrayList<>();

        listA = writeListNumbers(10,5);
        listB = writeListNumbers(10,5);

        System.out.println("Коллекция A: "+listA);
        System.out.println("Коллекция B: "+listB);

        differenceListAB=differenceMultiplicity (listA,listB);
         

        System.out.println("Разность A-B: "+differenceListAB);
        

        differenceListBA=differenceMultiplicity (listB,listA);

        System.out.println("Разность B-A: "+differenceListBA);

        System.out.println("Симметричная разность: "+differenceSymmetricMultiplicity(listB,listA));

        
    }
}
