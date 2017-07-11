package util;

import exceptions.BusinessException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public  class Helper {


    public static<T> List<List<T>> partitions(Object queue, int partitions) throws BusinessException{
        List<List<T>> big = new LinkedList<>();
        if(partitions > 0) {
            if (!(queue instanceof Queue)) {
                Queue<T> queues = new LinkedList<>();
                queues.addAll((Collection<? extends T>) queue);
                while (queues.size() > 0) {
                    List<T> little = new LinkedList<>();
                    for (int i = 0; i < partitions; i++) {
                        if (queues.peek() != null) {
                            little.add(queues.poll());
                        } else break;
                    }
                    big.add(little);
                }
            } else {
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
        throw new BusinessException("partitions should be greater than zero ");
    }


}
