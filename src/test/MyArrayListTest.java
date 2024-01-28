package test;

import main.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MyArrayListTest {

    int[] verificationArray;
    MyArrayList<Integer> testArray;
    Random random = new Random();

    @Test
    public void createObjectWithWrongCapacity()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> testArray = new MyArrayList<>(-1));
    }

    @Test
    public void addWithoutIndex() {
        verificationArray = new int[100];
        for(int i = 0; i < 100; i++)
            verificationArray[i]=random.nextInt(1000);
        testArray = new MyArrayList<>();

        for(Integer element: verificationArray)
            testArray.add(element);

        Assert.assertEquals(Arrays.toString(verificationArray), testArray.toString());
    }

    @Test
    public void addWithIndex()
    {
        testArray = new MyArrayList<>(6);
        verificationArray = new int[]{10, 0, 12 ,1, 11 ,2};

        for (int i = 0; i < 3; i++)
            testArray.add(i);

        //Insert into start point
        testArray.add(0, 10);

        //Insert into end point
        testArray.add(3, 11);

        //Insert into middle of array
        testArray.add(2, 12);


        Assert.assertEquals(Arrays.toString(verificationArray), testArray.toString());
    }

    @Test
    public void addWithWrongIndex()
    {
        testArray = new MyArrayList<>(6);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testArray.add(-1, 1));
    }

    @Test
    public void getObject()
    {
        Integer verificationValue = 9;
        testArray = new MyArrayList<>(1);
        for(int i = 0; i < 10; i++)
            testArray.add(i);
        Assert.assertEquals(verificationValue, testArray.get(9));
    }

    @Test
    public void getSize()
    {
        testArray = new MyArrayList<>(1);
        for(int i = 0; i < 10; i++)
            testArray.add(i);
        Assert.assertEquals(10, testArray.size());
    }

    @Test
    public void getIndex()
    {
        testArray = new MyArrayList<>(0);
        testArray.add(0);
        testArray.add(1);
        testArray.add(1);
        testArray.add(1);
        testArray.add(2);
        testArray.add(3);
        Assert.assertEquals(1, testArray.indexOf(1));
    }

    @Test
    public void setObject()
    {
        verificationArray = new int[]{10, 1, 2, 3, 12, 5, 6, 7, 8, 11};
        testArray = new MyArrayList<>(0);
        for (int i = 0; i < 10; i++)
            testArray.add(i);
        testArray.set(0, 10);
        testArray.set(9, 11);
        testArray.set(4, 12);
        Assert.assertEquals(Arrays.toString(verificationArray), testArray.toString());
    }


    @Test
    public void removeObjectByIndex()
    {
        verificationArray = new int[]{1, 2, 3, 4, 6, 7, 8};
        testArray = new MyArrayList<>();
        for (int i = 0; i < 10; i++)
            testArray.add(i);

        testArray.remove(0);
        testArray.remove(8);
        testArray.remove(4);
        Assert.assertEquals(Arrays.toString(verificationArray), testArray.toString());
    }

    @Test
    public void removeObject()
    {
        verificationArray = new int[]{1, 2, 3, 4, 6, 7, 8};
        testArray = new MyArrayList<>();
        for (int i = 0; i < 10; i++)
            testArray.add(i);

        testArray.remove((Integer) 0);
        testArray.remove((Integer) 9);
        testArray.remove((Integer) 5);
        Assert.assertEquals(Arrays.toString(verificationArray), testArray.toString());
    }

    @Test
    public void clearArrayAndInsertNewObjects()
    {
        verificationArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        testArray = new MyArrayList<>();
        for (int i = 0; i < 10; i++)
            testArray.add(i);
        testArray.clear();
        for (int i = 9; i > -1; i--)
            testArray.add(i);
        Assert.assertEquals(Arrays.toString(verificationArray), testArray.toString());
    }

}