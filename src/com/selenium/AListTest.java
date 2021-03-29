package com.selenium;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class AListTest {
    int [] array = new int[]{1, 2, 3, 4};
    AList aList = new AList(array);

    @Test
    public void test_clear(){
        aList.clear();
        int[] expected = {0, 0, 0, 0};
        int[] actual = aList.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_size(){
        int expected = 4;
        int actual = aList.size();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_get(){
        int expected = 3;
        int actual = aList.get(2);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_add_int(){
        aList.clear();
        aList.add(3);
        aList.add(4);
        int [] expected = {3, 4, 0, 0};
        int [] actual = aList.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_addByIndex(){
        aList.clear();
        aList.add(0, 3);
        aList.add(2, 4);
        int [] expected = {3, 0, 4, 0};
        int [] actual = aList.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_remove(){
        aList.remove(3);
        int [] expected = {1, 2, 4, 0};
        int [] actual = aList.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_removeByIndex(){
        aList.removeByIndex(3);
        int [] expected = {1, 2, 3, 0};
        int [] actual = aList.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_containsTrue(){
        boolean actual = aList.contains(2);
        Assertions.assertTrue(actual);
    }

    @Test
    public void test_containsFalse(){
        boolean actual = aList.contains(8);
        Assertions.assertFalse(actual);
    }

    @Test
    public void test_set(){
        aList.set(2, 8);
        int [] expected = {1, 2, 8, 4};
        int [] actual = aList.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_print() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        aList.print();
        Assertions.assertEquals("[1, 2, 3, 4]", output.toString().trim());
        System.setOut(null);
    }

    @Test
    public void test_toArray(){
        int [] expected = {1, 2, 3, 4};
        int [] actual = aList.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_removeAll(){
        int [] arr = new int []{1, 3};
        aList.removeAll(arr);
        int [] expected = {0, 2, 0, 4};
        int [] actual = aList.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }
}