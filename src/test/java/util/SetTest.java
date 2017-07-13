package util;

import exceptions.BusinessException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.*;

public class SetTest {

    // Set
    Set<Integer> hashSetQueue;
    Set<Integer> linkedHashSetQueue;
    Set<Integer> treeSetQueue;


    List<List<Integer>> expectedList;
    int partitions;
    int partitions_exception;

    Integer[] values = null;

    @Before
    public void setUp() {
        hashSetQueue = new HashSet <>();
        linkedHashSetQueue = new LinkedHashSet <>();
        treeSetQueue = new TreeSet <>();
        expectedList = new LinkedList<>();

        values = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        partitions = 2;
        partitions_exception = -1;

        for(Integer value: values) {
            hashSetQueue.add(value);
            linkedHashSetQueue.add(value);
            treeSetQueue.add(value);
        }
        expectedList.add(new LinkedList<>(Arrays.asList(1, 2)));
        expectedList.add(new LinkedList<>(Arrays.asList(3, 4)));
        expectedList.add(new LinkedList<>(Arrays.asList(5, 6)));
        expectedList.add(new LinkedList<>(Arrays.asList(7)));

    }

    @Test
    public void hashSetTest() throws BusinessException {
        List<List<String>> actual = Helper.partitions(hashSetQueue, partitions);
        assertThat(actual, is(expectedList));
    }

    @Test
    public void linkedHashSetTest() throws BusinessException {
        List<List<String>> actual = Helper.partitions(linkedHashSetQueue, partitions);
        assertThat(actual, is(expectedList));
    }

    @Test
    public void treeSetTest() throws BusinessException {
        List<List<String>> actual = Helper.partitions(treeSetQueue, partitions);
        assertThat(actual, is(expectedList));
    }

    @Test(expected = BusinessException.class)
    public void hashSetTestFail() throws BusinessException {
        Helper.partitions(hashSetQueue, partitions_exception);
    }

    @Test(expected = BusinessException.class)
    public void linkedHashSetTestFail() throws BusinessException {
        Helper.partitions(linkedHashSetQueue, partitions_exception);
    }

    @Test(expected = BusinessException.class)
    public void treeSetTestFail() throws BusinessException {
        Helper.partitions(treeSetQueue, partitions_exception);
    }

}
