package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка");
        int lenth = scanner.nextInt();//пользователь в адеквате
        System.out.println("Введите максимальное значение в списке");
        int max = scanner.nextInt();
        logger.log("Создаём и наполняем список");
        List<Integer> result = doList(lenth, max);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра от 0 до " + max);
        int f = scanner.nextInt();
        Filter filter = new Filter(f);
        List <Integer> resFiltr = filter.filterOut(result);
        System.out.println("Отфильтрованный список: " + printList(resFiltr) );
        logger.log("Программа завершена");
    }

   public static List<Integer> doList (int lenth, int max) {
        List<Integer> res = new ArrayList<>(lenth);
        Random random = new Random();
        for (int i = 0; i<lenth; i++) {
            res.add(random.nextInt(max));
        }
       System.out.println("Вот случайный список: " + printList(res));
        return  res;
    }

    public static String printList (List<Integer> list){
        String s ="";
        for (int i : list) {
            s = s + i + " ";
        }
      return  s;
    }
}
