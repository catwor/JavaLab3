package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс TimerForListFunctions предоставляет методы для измерения времени выполнения операций над списками.
 */
public class TimerForListFunctions {

  /**
   * Метод для измерения времени выполнения операции добавления элементов в список.
   * @return массив, содержащий время выполнения операции добавления для ArrayList и LinkedList в миллисекундах.
   */
  public static double[] timeAdd() {
    List<Integer> array = new ArrayList<>();
    List<Integer> linked = new LinkedList<>();

    double resultArrayList = timer((list) -> {
      fillList(list, 5000);
    }, array);

    double resultLinkedList = timer((list) -> {
      fillList(list, 5000);
    }, linked);

    return new double[]{resultArrayList, resultLinkedList};
  }

  /**
   * Метод для измерения времени выполнения операции получения элементов из списка.
   * @return массив, содержащий время выполнения операции получения для ArrayList и LinkedList в миллисекундах.
   */
  public static double[] timeGet() {
    List<Integer> array = new ArrayList<>();
    List<Integer> linked = new LinkedList<>();

    fillList(array, 5000);
    fillList(linked, 5000);

    double resultArrayList = timer((list) -> {
      for (int i = 0; i < list.size(); ++i)
        list.get(i);
    }, array);

    double resultLinkedList = timer((list) -> {
      for (int i = 0; i < list.size(); ++i)
        list.get(i);
    }, linked);

    return new double[]{resultArrayList, resultLinkedList};
  }

  /**
   * Метод для измерения времени выполнения операции удаления элементов из списка.
   * @return массив, содержащий время выполнения операции удаления для ArrayList и LinkedList в миллисекундах.
   */
  public static double[] timeRemove() {
    List<Integer> array = new ArrayList<>();
    List<Integer> linked = new LinkedList<>();

    fillList(array, 5000);
    fillList(linked, 5000);

    double resultArrayList = timer((list) -> {
      for (int i = 0; i < list.size(); ++i)
        list.remove(i);
    }, array);

    double resultLinkedList = timer((list) -> {
      for (int i = 0; i < list.size(); ++i)
        list.remove(i);
    }, linked);

    return new double[]{resultArrayList, resultLinkedList};
  }

  /**
   * Заполняет список указанным количеством элементов.
   * @param list  список, который нужно заполнить
   * @param count количество элементов, которыми нужно заполнить список
   */
  private static void fillList(List<Integer> list, int count) {
    for (int i = 0; i < count; ++i)
      list.add(i);
  }

  /**
   * Измеряет время выполнения операции над списком.
   * @param fun  операция, которую нужно измерить
   * @param list список, над которым выполняется операция
   * @return время выполнения операции в миллисекундах
   */
  private static double timer(Consumer<List> fun, List list) {
    long start = System.nanoTime();

    fun.accept(list);

    long end = System.nanoTime();
    return (double) ((end - start) / 1_000_000.0);
  }
}
