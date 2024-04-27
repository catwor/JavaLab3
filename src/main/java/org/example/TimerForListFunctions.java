package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TimerForListFunctions {

  public static double[] timeAdd(){
    List<Integer> array = new ArrayList<>();
    List<Integer> linked = new LinkedList<>();

    double resultArrayList = timer((list)->{
      fillList(list,5000);
    }, array);

    double resultLinkedList = timer((list)->{
      fillList(list,5000);
    }, linked);

    return new double[] {resultArrayList, resultLinkedList};
  }

  public static double[] timeGet(){
    List<Integer> array = new ArrayList<>();
    List<Integer> linked = new LinkedList<>();

    fillList(array,5000);
    fillList(linked,5000);

    double resultArrayList = timer((list)->{
      for(int i=0;i<list.size();++i)
        list.get(i);
    }, array);

    double resultLinkedList = timer((list)->{
      for(int i=0;i<list.size();++i)
        list.get(i);
    }, linked);

    return new double[] {resultArrayList, resultLinkedList};
  }

  public static double[] timeRemove(){
    List<Integer> array = new ArrayList<>();
    List<Integer> linked = new LinkedList<>();

    fillList(array,5000);
    fillList(linked,5000);

    double resultArrayList = timer((list)->{
      for(int i=0;i<list.size();++i)
        list.remove(i);
    }, array);

    double resultLinkedList = timer((list)->{
      for(int i=0;i<list.size();++i)
        list.remove(i);
    }, linked);

    return new double[] {resultArrayList, resultLinkedList};
  }

  private static void fillList(List<Integer> list, int count) {
    for (int i = 0; i < count; ++i)
      list.add(i);
  }

  private static double timer(Consumer<List> fun, List list){
    long start = System.nanoTime();

    fun.accept(list);

    long end = System.nanoTime();
    return (double) ((end - start)/1_000_000.0);
  }
}
