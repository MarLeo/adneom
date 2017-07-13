package util;

import exceptions.BusinessException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HelperTest {


    // List
    List<String> arrayListQueue;
    List<String> linkedListQueue;
    List<String> vectorQueue;
    List<String> stackQueue;

    List<List<String>> expectedList;
    int partitions;

    String[] values = null;

    @Before
    public void setUp() {
        arrayListQueue = new ArrayList<>();
        linkedListQueue = new LinkedList<>();
        vectorQueue = new Vector<>();
        stackQueue = new Stack<>();
        expectedList = new LinkedList<>();
        values = new String[]{"Java", ".Net", "Javascript", "HTML5", "Hadoop", "Spark", "Flink"};
        partitions = 2;

        for(String value: values) {
            arrayListQueue.add(value);
            linkedListQueue.add(value);
            vectorQueue.add(value);
            stackQueue.add(value);
        }

        expectedList.add(new LinkedList<>(Arrays.asList("Java", ".Net")));
        expectedList.add(new LinkedList<>(Arrays.asList("Javascript", "HTML5")));
        expectedList.add(new LinkedList<>(Arrays.asList("Hadoop", "Spark")));
        expectedList.add(new LinkedList<>(Arrays.asList("Flink")));
    }

    @Test
    public void arrayListTest() throws BusinessException {
        List<List<String>> actual = Helper.partitions(arrayListQueue, partitions);
        assertThat(actual, is(expectedList));
    }

    @Test
    public void linkedListTest() throws BusinessException {
        List<List<String>> actual = Helper.partitions(linkedListQueue, partitions);
        assertThat(actual, is(expectedList));
    }

    @Test
    public void vectorTest() throws BusinessException {
        List<List<String>> actual = Helper.partitions(vectorQueue, partitions);
        assertThat(actual, is(expectedList));
    }

    @Test
    public void stackTest() throws BusinessException {
        List<List<String>> actual = Helper.partitions(stackQueue, partitions);
        assertThat(actual, is(expectedList));
    }


    // setup

    // test

}
