# MyArrayListImplementation
A project for the Aston Java intensive. It is a variant of the implementation of ArrayList and quick sorting according to the Hoare scheme.

## MyArrayList

This class provides modifiable implementation of some methods of the 
[AbstractList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/AbstractList.html) and preserves the contracts of these methods. 
So you can use documentation of the [AbstractList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/AbstractList.html).

The following methods are implemented:
* get(int)
* size()
* add(Object)
* add(int, Object)
* indexOf(Object)
* remove(int)
* remove(Object)
* clear()
* toString()

This class isn't a member of the [Java Collections Framework](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html). 
If you want to use modifiable implementation of the [AbstractList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/AbstractList.html) interface, 
use [ArrayList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html) instead.

## MyQuickSort

This class is an implementation of the [Hoare scheme quick sort algorithm](https://en.wikipedia.org/wiki/Quicksort#Hoare_partition_scheme).
This class supports any modifiable implementation of the [List](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html#indexOf(java.lang.Object)) interface 
with elements which implement [Comparable](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Comparable.html) interface.

## Tests

This projects has tests for all public methods of MyArrayList class and for four scenario of MyQuicSort class:
* Sort random ArrayList\<Integer\>
* Sort increasing ArrayList\<Integer\>
* Sort decreasing ArrayList\<Integer\>
* Sort raandom MyArrayList\<Integer\>
