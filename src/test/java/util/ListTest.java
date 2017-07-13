package util;

import exceptions.BusinessException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class ListTest {

    // List
    List<String> arrayListQueue;
    List<String> linkedListQueue;
    List<String> vectorQueue;
    List<String> stackQueue;

    List<List<String>> expectedList;
    int partitions;
    int partitions_exception;

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
        partitions_exception = -1;

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


    @Test(expected = BusinessException.class)
    public void arrayListTestFail() throws BusinessException {
        List<List<String>> actual = Helper.partitions(arrayListQueue, partitions_exception);
    }

    @Test
    public void linkdedListTestFail() {
        try {
            Helper.partitions(linkedListQueue, partitions_exception);
            fail("Expected exception");
        } catch (BusinessException be) {
           assertThat(be.getMessage(), is("number of partitions should be greater than zero "));
        }
    }

    @Test(expected = BusinessException.class)
    public void vectorTestFail() throws BusinessException {
        Helper.partitions(vectorQueue, partitions_exception);
    }

    @Test(expected = BusinessException.class)
    public void stackTestFail() throws BusinessException {
        Helper.partitions(stackQueue, partitions_exception);
    }

}
