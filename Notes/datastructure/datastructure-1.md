Understanding data structures is fundamental to developing efficient algorithms and writing performant code. Java provides a rich set of data structures through its Collections Framework, which includes interfaces and classes for handling groups of objects.

### 1. **Array**

#### Description
- A contiguous block of memory with fixed size where each element can be accessed by an index.
- Arrays are zero-indexed, meaning the first element is at index 0.

#### Internal Working
- Arrays are stored in a continuous block of memory.
- Accessing an element by index is O(1) because it's a direct memory access.
- Insertion and deletion can be O(n) in the worst case because elements need to be shifted.

```java
int[] numbers = new int[10]; // Declaring an array of size 10
numbers[0] = 1; // Accessing first element
```

### 2. **ArrayList**

#### Description
- A resizable array implementation of the `List` interface.
- Elements can be added and removed dynamically.

#### Internal Working
- Uses an array internally to store elements.
- When the array is full, a new array is created with a larger size, and elements are copied over.
- Access by index is O(1), but adding elements can be O(n) if resizing is needed.

```java
ArrayList<Integer> arrayList = new ArrayList<>();
arrayList.add(1);
arrayList.add(2);
int element = arrayList.get(0); // Accessing first element
```

### 3. **LinkedList**

#### Description
- A doubly linked list implementation of the `List` and `Deque` interfaces.
- Elements are stored in nodes, where each node contains a reference to the next and previous nodes.

#### Internal Working
- Each element is stored in a node which contains references to the previous and next node.
- Accessing an element is O(n) because you may need to traverse the list.
- Adding or removing elements is O(1) if you have a reference to the node.

```java
LinkedList<Integer> linkedList = new LinkedList<>();
linkedList.add(1);
linkedList.add(2);
int element = linkedList.get(0); // Accessing first element (O(n))
```

### 4. **HashMap**

#### Description
- A hash table implementation of the `Map` interface.
- Stores key-value pairs and allows null values and one null key.

#### Internal Working
- Uses an array of linked lists or balanced trees (from Java 8) to store entries.
- Hash function determines the index for a given key.
- Collision resolution by chaining (linked list) or by using a balanced tree.
- Average time complexity for get and put operations is O(1).

```java
HashMap<String, Integer> hashMap = new HashMap<>();
hashMap.put("one", 1);
hashMap.put("two", 2);
int value = hashMap.get("one"); // Accessing value for key "one"
```

### 5. **TreeMap**

#### Description
- A Red-Black tree based implementation of the `NavigableMap` interface.
- Maintains sorted order of keys.

#### Internal Working
- Uses a Red-Black tree, a type of self-balancing binary search tree.
- Guarantees O(log n) time complexity for get, put, and remove operations.

```java
TreeMap<String, Integer> treeMap = new TreeMap<>();
treeMap.put("one", 1);
treeMap.put("two", 2);
int value = treeMap.get("one"); // Accessing value for key "one"
```

### 6. **HashSet**

#### Description
- A hash table based implementation of the `Set` interface.
- Does not allow duplicate elements.

#### Internal Working
- Internally uses a `HashMap` to store elements as keys with a constant dummy value.
- Average time complexity for add, remove, and contains operations is O(1).

```java
HashSet<Integer> hashSet = new HashSet<>();
hashSet.add(1);
hashSet.add(2);
boolean contains = hashSet.contains(1); // Checking if element 1 is in the set
```

### 7. **TreeSet**

#### Description
- A NavigableSet implementation based on a TreeMap.
- Elements are stored in a sorted order.

#### Internal Working
- Uses a `TreeMap` to store elements.
- Guarantees O(log n) time complexity for add, remove, and contains operations.

```java
TreeSet<Integer> treeSet = new TreeSet<>();
treeSet.add(1);
treeSet.add(2);
boolean contains = treeSet.contains(1); // Checking if element 1 is in the set
```

### 8. **PriorityQueue**

#### Description
- A priority queue implementation based on a binary heap.
- Elements are ordered according to their natural ordering or by a comparator.

#### Internal Working
- Uses a binary heap to maintain the elements.
- Guarantees O(log n) time complexity for insertion and removal of elements.

```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
priorityQueue.add(5);
priorityQueue.add(1);
priorityQueue.add(3);
int smallest = priorityQueue.poll(); // Retrieves and removes the head of the queue
```

### 9. **Stack**

#### Description
- A legacy class that represents a last-in, first-out (LIFO) stack of objects.
- Extends `Vector` with five operations that allow a vector to be treated as a stack.

#### Internal Working
- Uses an array to store elements.
- All operations are thread-safe because it extends `Vector`.

```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
int top = stack.pop(); // Retrieves and removes the top of the stack
```

### 10. **Deque (ArrayDeque)**

#### Description
- A resizable array implementation of the `Deque` interface.
- Allows elements to be added or removed from both ends.

#### Internal Working
- Uses a resizable array to store elements.
- Provides an efficient way to perform both stack and queue operations.

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1);
deque.addLast(2);
int first = deque.removeFirst(); // Retrieves and removes the first element
```

### Summary

- **Array**: Fixed size, direct memory access.
- **ArrayList**: Resizable array, dynamic resizing.
- **LinkedList**: Doubly linked list, efficient insertions/deletions.
- **HashMap**: Hash table, average O(1) for get/put.
- **TreeMap**: Red-Black tree, sorted keys, O(log n) operations.
- **HashSet**: Hash table, unique elements, average O(1) operations.
- **TreeSet**: Red-Black tree, sorted elements, O(log n) operations.
- **PriorityQueue**: Binary heap, priority-based retrieval.
- **Stack**: LIFO stack, extends Vector.
- **Deque (ArrayDeque)**: Double-ended queue, resizable array.

Understanding these data structures and their internal workings helps you choose the right one for your needs and write efficient code.



Collection Notes:


Advantage of Collection:

Performance: Optimized data structures for improved speed and accuracy.
Maintainability: Consistent APIs and utility methods simplify maintenance.
Extensibility: Ability to create custom collections that meet specific needs.
Reusability: Classes can be easily reused, promoting cleaner and more efficient code.




