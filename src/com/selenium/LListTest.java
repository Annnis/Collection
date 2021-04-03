package com.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LListTest {

    LList llist = new LList();

    @BeforeEach
    public void setUp(){
        llist.add(1);
        llist.add(2);
        llist.add(3);
        llist.add(4);
        llist.add(5);
        llist.add(6);
        llist.add(7);
        llist.add(8);
        llist.add(9);
        llist.add(10);
    }

    @Test
    public void test_clear() {
        llist.clear();
            int[] expected = {};
            int[] actual = llist.toArray();
            Assertions.assertArrayEquals(actual, expected);
        }

    @Test
    public void test_size() {
        llist.size();
        int expected = 10;
        int actual = llist.size();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_get() {
        int expected = 2;
        int actual = llist.get(2);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_add() {
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual = llist.toArray();
        Assertions.assertArrayEquals(actual, expected);
        }

    @Test
    public void test_addByIndex(){
        llist.add(3, 98);
        int[] expected = {1, 2, 3, 98, 4, 5, 6, 7, 8,9, 10};
         int[] actual = llist.toArray();
        Assertions.assertArrayEquals(actual, expected);
}

    @Test
    public void test_remove(){
        llist.remove(9);
        int[] expected = {1, 2, 3,4, 5,6,7,8,10};
        int[] actual = llist.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_removeByIndex(){
        llist.removeByIndex(2);
        int[] expected = {1, 2, 4, 5,6,7,8,9,10};
        int[] actual = llist.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_containsPositive(){
        boolean actual = llist.contains(3);
        Assertions.assertTrue(actual);
    }

    @Test
    public void test_containsNegative(){
        boolean actual = llist.contains(113131);
        Assertions.assertFalse(actual);
    }

    @Test
    public void test_set(){
        llist.set(2, 100);
        int[] expected = {1, 100, 3, 4, 5,6,7,8,9,10};
        int[] actual = llist.toArray();
        Assertions.assertArrayEquals(actual, expected);
    }







    @Test
    public void test_toArray () {
        int[] expected = {1,2,3,4,5,6,7,8,9,10};
        int[] actual = llist.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void test_print () {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        llist.print();
        Assertions.assertEquals("1 2 3 4 5 6 7 8 9 10", output.toString().trim());
        System.setOut(null);
    }

    @Test
    public void test_removeAll(){



    }

}




