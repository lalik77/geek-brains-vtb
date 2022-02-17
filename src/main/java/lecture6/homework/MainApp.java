package lecture6.homework;

import lecture6.homework.task1.ArrayCalculation;
import lecture6.homework.task1.ArrayCalculationConcurrency;

public class MainApp {

  public static void main(String[] args) {

    // ** Запуск первого метода который записывает в один массив **
    // Расчет произыодится в одном потоке
    ArrayCalculation.calculateInSingleThreadUsingOneCycle();


    // ** Запуск второго метода который копирует данные с массива в два
    //    массива и по отделности записывает в них и обратно собирает данные в массив **

    ArrayCalculation.calculateInSingleThreadByFokAndJoin();


    // * Запуск первого метода в двух потоках
    try {
      ArrayCalculationConcurrency.calculate();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // * Запуск второго метода в двух потоках

    try {
      ArrayCalculationConcurrency.calculateForkAndJoin();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }




/*
      // Пример разделеления массива на два и склеивания
      // Важно учесть, что массива делится пополам без остатка
    int sourceArr[] = { 0, 1, 2, 3, 4, 5,6,7,8,9 };
    int len = sourceArr.length/2;
    int a1[] = new int[sourceArr.length/2];
    int a2[] = new int[sourceArr.length/2];

     // Копировать по половинке в каждый массив
    System.arraycopy(sourceArr,0,a1,0,len);
    System.arraycopy(sourceArr,len,a2,0,len);

    for (int i =0 ; i<a1.length ; i++) {
      System.out.print(a1[i]+ " ");
    }
    System.out.println("\n-------");
    for (int i =0 ; i<a2.length ; i++) {
      System.out.print(a2[i] + " ");
    }

    System.out.println("\n\n\nОбратно Склейка");

    System.arraycopy(a1,0,sourceArr,0,len);
    System.arraycopy(a2,0,sourceArr,len,len);

    for (int i =0 ; i<sourceArr.length ; i++) {
      System.out.print(sourceArr[i]+ " ");
    }*/



  }

}