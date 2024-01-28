package main;

import java.util.*;


/**
 * <p>This class provides modifiable implementation of some methods of the {@link AbstractList} and preserves the contracts of these methods. So you can use documentation of the {@link AbstractList}.</p>
 * <p>The following methods are implemented: <ul>
 *     <li>{@link #get(int)}</li>
 *     <li>{@link #size()}</li>
 *     <li>{@link #add(Object)}</li>
 *     <li>{@link #add(int, Object)}</li>
 *     <li>{@link #indexOf(Object)}</li>
 *     <li>{@link #remove(int)}</li>
 *     <li>{@link #remove(Object)}</li>
 *     <li>{@link #clear()}</li>
 *     <li>{@link #toString()}</li>
 * </ul></p>
 * <p>This class isn't a member of the <a href=https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html>Java Collections Framework</a>. If you want to use modifiable implementation of the {@link AbstractList} interface, use {@link ArrayList} instead.</p>
 * @param <E>
 * @author Jokita Moonsun
 */

public class MyArrayList<E> extends AbstractList<E>
{
    private int size = 0;
    private static final Object[] EMPTY = new Object[0];
    private Object[] array;

    /**
     * Default constructor. Creates empty array.
     */
    public MyArrayList()
    {
        array = EMPTY;
    }

    /**
     * Constructor with a specified size of array.
     * @param capacity initial size of array
     */
    public MyArrayList(int capacity)
    {
        if (capacity > 0)
            array = new Object[capacity];
        else if (capacity == 0)
            array = EMPTY;
        else
            throw new IllegalArgumentException("Wrong array capacity");
    }


    @Override
    @SuppressWarnings("unchecked")
    public E get(int index)
    {
        Objects.checkIndex(index, size);
        return (E) array[index];
    }


    @Override
    public int size()
    {
        return size;
    }


    private void expand()
    {
        int DEFAULT_SIZE = 10;
        if (array == EMPTY)
            array = new Object[DEFAULT_SIZE];
        else
        {
            int newCapacity = Math.max(size + 1, size >> 1);
            if (newCapacity > size)
                array = Arrays.copyOf(array, newCapacity);
        }
    }


    @Override
    public boolean add(Object o)
    {
        if (array.length==size)
            expand();
        if (array.length > size)
        {
            array[size] = o;
            size++;
        }
        else
            throw new StackOverflowError();
        return true;
    }


    @Override
    public void add(int index, Object o)
    {
        Objects.checkIndex(index, size);
        if (array.length==size)
            expand();
        if (array.length > size) {
            Object[] buffer = new Object[array.length];
            System.arraycopy(array, 0, buffer, 0, index);
            buffer[index] = o;
            System.arraycopy(array, index, buffer, index + 1, size - index);
            array = buffer;
            size++;
        }
    }


    @Override
    public int indexOf(Object o) {
        if (o == null)
        {
            for (int i = 0; i < size; i++)
            {
                if (array[i] == null)
                    return i;
            }
        }
        else
        {
            for (int i = 0; i < size; i++)
            {
                if(o.equals(array[i]))
                    return i;
            }
        }
        return -1;
    }


    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        Objects.checkIndex(index, size);
        Object[] buffer = new Object[array.length - 1];
        Object oldValue = array[index];
        System.arraycopy(array, 0, buffer, 0, index);
        System.arraycopy(array, index + 1, buffer, index, size - index -  1);
        array = buffer;
        size--;
        return (E) oldValue;
    }


    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1)
            return false;
        else
        {
            remove(index);
            return true;
        }
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
        {
            array[i] = null;
        }
        size = 0;
    }


    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        Object oldElement = array[index];
        array[index] = element;
        return (E) oldElement;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

}
