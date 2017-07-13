package driver;


import exceptions.BusinessException;
import util.Helper;

import java.util.*;

public class Driver {

    public static void main(String[] args) throws BusinessException {

        Queue<String> queue = new LinkedList<>();

        queue.add("Java");
        queue.add(".NET");
        queue.add("Javascript");
        queue.add("HTML5");
        queue.add("Hadoop");
        queue.add("Spark");
        queue.add("Flink");




        System.out.println("Items in the queue..." + queue + " with size: " + queue.size());


        int partitions = 1;
        List<List<String>> big = Helper.partitions(queue, partitions);
        System.out.println("partitions in " + big);

    }

}


