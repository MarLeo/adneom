package util;


import exceptions.BusinessException;

import java.util.*;

public class Demo {

    public static void main(String[] args) throws BusinessException {

        NavigableSet<String> queue = new TreeSet<>();

        queue.add("Java");
        queue.add(".NET");
        queue.add("Javascript");
        queue.add("HTML5");
        queue.add("Hadoop");
        queue.add("Spark");
        queue.add("Flink");



        System.out.println("Items in the queue..." + queue + " with size: " + queue.size());


        int partitions = 2;
        List<List<String>> big = Helper.partitions(queue, partitions);
        System.out.println("partitions in " + big);

    }

}


