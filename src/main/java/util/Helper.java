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
                queueList(queues, partitions, big);
            } else {
                queueList((Queue) queue, partitions, big);
            }
            return big;
        }
        throw new BusinessException("number of partitions should be greater than zero ");
    }

    private static <T> void queueList(Queue<T> queue, int partitions, List<List<T>> big) throws BusinessException {
        if (queue.isEmpty())
            throw new BusinessException("List should not be empty");
        while (queue.size() > 0) {
            List<T> little = new LinkedList<>();
            for (int i = 0; i < partitions; i++) {
                if (queue.peek() != null) {
                    little.add(queue.poll());
                } else break;
            }
            big.add(little);
        }
    }


}
