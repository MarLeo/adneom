package src;


import java.util.*;

public class Demo {

    public static void main(String[] args) {

        NavigableSet<String> queue = new TreeSet<>();

        queue.add("Java");
        queue.add(".NET");
        queue.add("Javascript");
        queue.add("HTML5");
        queue.add("Hadoop");
        queue.add("Spark");
        queue.add("Flink");


        System.out.println("Items in the queue..." + queue + " with size: " + queue.size());

        /*while (queue.size() > 0){
            System.out.println("remove object " + queue.poll() + " remaining size: " + queue.size());

        }*/

        int partitions = 2;
        List<List<String>> big = partitions(queue, partitions);
        System.out.println("partitions in " + big);

    }


    private static<T> List<List<T>> partitions(Object queue, int partitions) {
        List<List<T>> big = new LinkedList<>();

            if (!(queue instanceof Queue)) {
                    Queue<T> queues = new LinkedList<T>();
                    queues.addAll((Collection<? extends T>) queue);
                while ( queues.size() > 0) {
                    List<T> little = new LinkedList<>();
                    for (int i = 0; i < partitions; i++) {
                        if ( queues.peek() != null) {
                            little.add(queues.poll());
                        } else break;
                    }
                    big.add(little);
                }
            }
            else {
                while (((Queue) queue).size() > 0) {
                    List<T> little = new LinkedList<>();
                    for (int i = 0; i < partitions; i++) {
                        if (((Queue) queue).peek() != null) {
                            little.add((T) ((Queue) queue).poll());
                        } else break;
                    }
                    big.add(little);
                }
            }
        return big;
    }
}


