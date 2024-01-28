package test;

import main.MyArrayList;
import main.MyQuickSort;
import org.junit.Assert;
import org.junit.Test;

import java.security.PublicKey;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class MyQuickSortTest {

    ArrayList<Integer> verificationArray;
    AbstractList<Integer> testArray;
    Random random = new Random();

    @Test
    public void sortRandomArray()
    {
        verificationArray = new ArrayList<>();
        testArray = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            int value = random.nextInt(1000);
            verificationArray.add(value);
            testArray.add(value);
        }
        MyQuickSort.sort(testArray);
        verificationArray.sort(null);
        Assert.assertEquals(verificationArray, testArray);
    }

    @Test
    public void sortIncreasingArray()
    {
        verificationArray = new ArrayList<>();
        testArray = new ArrayList<>();
        int value = random.nextInt(1000);
        for (int i = 0; i < 10; i++)
        {;
            verificationArray.add(value + i);
            testArray.add(value + i);
        }
        MyQuickSort.sort(testArray);
        verificationArray.sort(null);
        Assert.assertEquals(verificationArray, testArray);
    }


    @Test
    public void sortDecreasingArray()
    {
        verificationArray = new ArrayList<>();
        testArray = new ArrayList<>();
        int value = random.nextInt(1000);
        for (int i = 0; i < 10; i++)
        {;
            verificationArray.add(value - i);
            testArray.add(value - i);
        }
        MyQuickSort.sort(testArray);
        verificationArray.sort(null);
        Assert.assertEquals(verificationArray, testArray);
    }

    @Test
    public void sortRandomMyArrayList()
    {
        verificationArray = new ArrayList<>();
        testArray = new MyArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            int value = random.nextInt(1000);
            verificationArray.add(value);
            testArray.add(value);
        }
        MyQuickSort.sort(testArray);
        verificationArray.sort(null);
        Assert.assertEquals(verificationArray, testArray);
    }



}
