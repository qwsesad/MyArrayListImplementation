package main;

import java.util.List;


/**
 * <p>This class is an implementation of the <a href=https://en.wikipedia.org/wiki/Quicksort#Hoare_partition_scheme>Hoare scheme quick sort algorithm</a>.</p>
 * <p>This class supports any <b>modifiable</b> implementation of the {@link List} interface with elements which implement {@link Comparable} interface.</p>
 * @author Jokita Moonsun
 */
public class MyQuickSort{

    /**
     * This method sorts the input List.
     * @param o List with element of type T
     * @param <T> type of elements
     */
    public static <T extends Comparable<? super T>> void sort(List<T> o)
    {
        quicksort(o, 0, o.size() - 1);
    }

    private static <T extends Comparable<? super T>> void quicksort(List<T> o, int start, int end)
    {
        if (start < end)
        {
            int pivot = partition(o, start, end);
            quicksort(o, start, pivot);
            quicksort(o, pivot + 1, end);
        }
    }

    private static <T extends Comparable<? super T>> int partition(List<T> o, int start, int end)
    {
        T pivot = o.get((end + start) / 2);
        int i = start;
        int j = end;
        while (true)
        {
            while (o.get(i).compareTo(pivot) < 0)
                i++;
            while (o.get(j).compareTo(pivot) > 0)
                j--;
            if (i >= j)
                return j;
            T buffer = o.get(i);
            o.set(i, o.get(j));
            o.set(j, buffer);
            i++;
            j--;
        }
    }

}
