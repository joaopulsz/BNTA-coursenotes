# Data Structures

## What is a Data Structure?
A **data structure** is a particular way of organizing data in a computer so that it can be used effectively. They are often abbreviated to DS. You've already worked with some basic data structures, such as **arrays** and **Strings**. 

Basically, any *type* that organises **a collection of data, or of objects** according to a predefined **pattern** is a DS. These storage and organisation patterns are designed to optimise memory usage, and the time it takes to read/write/modify/delete elements from the collection. The concept of data structures is language independent. Each language (Java, C, Python etc) has it's own implementations of these basic DS types. You can also write your own implementations. Read more about the [basics of DS here](https://towardsdatascience.com/8-common-data-structures-every-programmer-must-know-171acf6a1a42#:~:text=Data%20Structures%20are%20a%20specialized,Computer%20Science%20and%20Software%20Engineering).

## What is an Algorithm?
An algorithm is a set of rules and steps that allows a computer to solve a particular problem. Algorithms are closely related to the topic of data structures - which is why **data structures and algorithms** are often refered to together as **DSA**. We'll take a deep dive into the key concepts and terminology of DSA in the following chapter.

## Java Collections
As we mentioned in our definition of DS above, a DS is essentially a **collection of things** in memory, organised in a certain way. Java collections are built-n DS solutions for all your data manipulation jobs such as storing, searching, sorting, insertion, deletion, and updating of data. In Java, collections exist within something called the **collections framework**.

## The Collections *Framework*
The Java platform includes a collections framework. A collection is a **container-like object** that represents a group of objects of the *same type*. The collections framework provides a **unified architecture** for accessing, storing and manipulating data.

The **primary advantages** of the collections framework are that it:

- Reduces programming **effort** by providing data structures and algorithms so you don't have to write them yourself, from scratch.
- Increases **performance** by providing high-performance implementations of data structures and algorithms. Because the various implementations of each interface are interchangeable, program performance can be *tuned* by **switching** implementations easily.
- Provides interoperability between unrelated APIs by establishing a common language to pass collections back and forth.
- Reduces the effort required to learn APIs, since they can all utilize the same collection API, instead of ad-hoc ones.
- Reduces the effort required to design and implement APIs by not requiring you to produce collection APIs.
- It's in harmony with the **DRY** principle (don't repeat yourself).

## Methods Common to *All* Collections

One of the really great things about the collections framework is that, because they all inherit the Collection interface, you know that implementations of the following methods will be available on **every** collection type you work with in the framework!
```java
interface Collection { // includes all methods listed below...}
```

- size
- isEmpty
- contains
- iterator
- toArray
- add
- remove
- containsAll
- addAll
- removeAll
- removeIf
- retainAll
- clear
- equals
- hashCode
- spliterator
- stream
- parallelStream

## Sub Interfaces

In turn, the following interfaces **extend** Collection - they inherit all of the above methods, and add some specific to their data type:

- java.util.**Set**
- java.util.**SortedSet**
- java.util.**NavigableSet**
- java.util.**List**
- java.util.**Queue**
- java.util.concurrent.**BlockingQueue**
- java.util.concurrent.**TransferQueue**
- java.util.**Deque**
- java.util.concurrent.**BlockingDeque**

## Interfaces Diagram

Check out the following diagram, which portrays the inheritance chain that exists between the collection frameworks interfaces:

![](../../../assets/java/data_structures/main.png)

Note that the Collection interface inherits from iterable - this means that, among other things, every collection has a `forEach` method we can use perform an action on each element it contains! As you can probably tell, one of the great advantages of the collections framework in Java is the common interfaces, which, to a large extent, standardizes the way we interact with them.

# Arrays

We mentioned before, that an array is simple and common data structure. It can  be thought of as a container object that holds a fixed number of *values*, or *objects*, of a *single type*. As we discussed in a previous chapter, the length of an array is established when the array is created. After creation, its length is fixed. 

Another important trait of an array is that it is store sequentially in memory - each element is stored, one after the other. This makes **retrieving** elements very **fast** and efficient:

![](../../../assets/java/data_structures/arrays.png)

- Fixed in size
- Fast for data **retrievals**
- Compact memory usage if size is known
- **Deletion** is **slow**, unless the element is at the very end of the array
- You can have *arrays of arrays*, i.e 2D Arrays.

## 2D Arrays
A 2D array is simply an array **of** arrays. 2D arrays can be used to implement a type of DS called a matrix, which can represent 2D information, for example, the pixels of an image. 

Checkout the following diagram:

![](../../../assets/java/data_structures/2d-arrays.png)

# Lists

Lists are similar to arrays in the sense that they function as a collection of objects. However, the key difference is that they can grow in size: 

- An ordered collection aka sequence.
- Allow duplicates
- Not Fixed in size like arrays
- Fast for data retrivals
- Various implementations
  - ArrayList
  - Stack
  - Vector
  - Others

A popular implementation of the List interface is the ArrayList:

![](../../../assets/java/data_structures/arraylists.png)

## ArrayList Methods
```
.size
.isEmpty
.contains
.iterator
.toArray
.add
.remove
.containsAll
.addAll
.removeAll
.retainAll
.replaceAll
.sort
.clear
.equals
.hashCode
.get
.set
.add
.remove
.indexOf
.lastIndexOf
.listIterator
.listIterator
.subList
.spliterator
.of
.copyOf
```
### ArrayList example
```java
package com.bnta.examples.ds;

import java.util.ArrayList;

public class WorkingWithArrayLists {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.indexOf(1));
        System.out.println(list.size());
        list.remove(0);
        System.out.println(list.size());
        System.out.println(list.contains(1));
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list.size());

        // add back again

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // iteration method 1: foreEach
        list.forEach(e -> {
            System.out.println("e = " + e);
        });

        // iteration method 2: enhanced for loop
        for (Object e : list) {
            System.out.println("e = " + e);
        }

        // iteration method 3: for loop using list.size()
        for (int i = 0; i < list.size(); i++) {
            // System.out.println(list[i]);
            System.out.println(list.get(i));
        }
    }
}

```
As you can see above, there are numerous ways that we can iterate through the elements of an ArrayList - actually, we can do it in the same way for all collections, because they all inherit the `Collection` and `Iterable` interfaces!

# Stacks

The Stack class represents a last-in-first-out (LIFO) stack of objects. It extends class Vector with five operations that allow a vector to be treated as a stack.

The usual push and pop operations are provided, as well as a method to peek at the top item on the stack, a method to test for whether the stack is empty, and a method to search the stack for an item and discover how far it is from the top.

![](../../../assets/java/data_structures/stack.png)

## Methods
```
.push
.pop
.peek
.empty
.search
```

## Queues
- FIFO (First In First Out)
- A collection designed for holding elements prior to processing, in the order in which they are added.

![](../../../assets/java/data_structures/queues.png)

### Queue Methods
```
.add
.offer
.remove
.poll
.element
.peek
```

## Sets
A collection that contains no duplicate elements.

More formally, sets contain no pair of elements e1 
and e2 such that e1.equals(e2), 
and at most one null element. 

As implied by its name, this interface models 
the mathematical set abstraction.

![](../../../assets/java/data_structures/sets.png)

### Set Methods
```
.size
.isEmpty
.contains
.iterator
.toArray
.toArray
.add
.remove
.containsAll
.addAll
.retainAll
.removeAll
.clear
.equals
.hashCode
.spliterator
.of
.copyOf
```

## Maps

### Map Interface

The `Map` interface is **is not part of the collections framework** proper, since it stores data in **key -> value pairs**, like a dictionary, as opposed to *sequentially*, as is the case with all collections. Hence, it *cannot* implement iterable meaningfully, since that would only make sense for an ordered, sequential DS.

However, the Map interface **provides three collection views**, which allow a map's **contents** to be viewed as a set of keys, collection of values, or set of key-value mappings. These views do implement collection and iterable, so we can use the usual iteration techniques on them etc...

The order of a map is defined as the order in which the iterators on the map's collection views return their elements.

![](../../../assets/java/data_structures/map-main.png)

As we alluded to, a map is a DS that maps maps keys to values: 
- A map cannot contain duplicate keys.
- Each key can map to at most one value.

![](../../../assets/java/data_structures/map.png)

## Methods
```
.size
.isEmpty
.containsKey
.containsValue
.get
.put
.remove
.putAll
.clear
.keySet
.values
.entrySet
.equals
.hashCode
.getOrDefault
.forEach
.replaceAll
.putIfAbsent
.remove
.replace
.replace
.computeIfAbsent
.computeIfPresent
.compute
.merge
.of
.ofEntries
.entry
.copyOf
```

## Maps and HashCode
Hashing is a technique or process of mapping keys, values into the hash table by using a hash function. It is done for faster access to elements. 


![](../../../assets/java/data_structures/hashcode.png)

### HashMap Example
HashMap is a popular implementation of the Map interface, which alows us to easily store key->value pairs. Note in the example below that we **must** specify the **type** of the *keys*, and the *values*, between `<>` when declaring the HashMap:
``` java
HashMap<String, Integer> ages = new HashMap<>();
```
This type of parameter is called a **Generic**. We'll discuss generics in detail soon in a separate chapter.
``` java
public static void main(String[] args) {
  // HashMap takes 2 generics, which means we must specify the type
  // of the keys and the values. Here, the key is String and the value is Integer
  // more on generics in the generics chapter...
  HashMap<String, Integer> ages = new HashMap<>();
  
  ages.put("Jim", 25);
  ages.put("Pete", 32);
  ages.put("Alice", 91);

  // enhanced for loop: this will print all the keys
  for (String key : ages.keySet()) {
      System.out.print(key);
  }

  // forEach with this will print all the values, using a lambda function
  ages.values().forEach(e -> {
      System.out.println(e);
  });

  // here, we use the keys to get the values, and print it all
  for (String key : ages.keySet()) {
      System.out.print(key + " is " + ages.get(key)
      + "years old.");
  }
}
```

## Video Recap
![type:video](../../../assets/java/data_structures/11-ds.mp4)
