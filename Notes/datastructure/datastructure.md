The Main Data structure sin java are Array, ArrayList, LinkedList, HaspMap, Stack, Queue

Array
	Advantages:

   Data Organization: Arrays provide a structured way to store and organize elements, improving data management.
   Random Access: Elements can be accessed directly using their index, allowing for efficient retrieval and modification.
   Fixed Size: Arrays have a predetermined size, enabling efficient memory allocation.
   Homogeneous Elements: Arrays store elements of the same type, ensuring data consistency and simplifying operations.
   Iteration: Arrays support easy iteration through elements, facilitating traversal and processing.
   Sorting and Searching: Arrays work well with sorting and searching algorithms, offering efficient operations.
   Memory Efficiency: Arrays optimize memory usage by storing elements in contiguous regions.
   Compatibility: Arrays are widely supported in Java, making them compatible with various frameworks and tools.
Disadvantages:

   Fixed Size: Arrays cannot be dynamically resized, requiring recreation for size changes.
   Memory Wastage: Unused elements in larger arrays can lead to memory wastage.
   Insertion and Deletion Overhead: Inserting or deleting elements in the middle of an array requires shifting subsequent elements, resulting in inefficiency.
   Lack of Flexibility: Arrays have rigid data types and cannot accommodate different data kinds without additional arrays or data structures.
	
ArrayList
	Size will grow
	DEfault size is 10 and if it occumpy it grow by 10 +.5 %
	- generics supports	
	Advantage
		-Random Access (O(1))
		-Easy Manipulation
		-Insertion & Deletion is Fast
		-Integration with collection FrameWork
		-Under the hood one Array is there it will take care on the memory
	Disadvantages
		- Memeory issue because of the internal structure
		- insertion and deletion in bettween is taking more complexit(O(n)
		- Searching will take time
		No support for primitive.
		
Linked List
	Size will grow
	memory non-contigues
	node is there for support in the inner 
	- generics supports	
	-
	Advantage:
	Easy for insertion and deletion in between nodes will point to the next refference
	-Easy modification
	Disadvantage
	-In-effiecient search
	- slower randomness
	increased memory over head
	
HashMap
	- store value in key value pair.
	- generics supports					
	Default size is 16 and if .75 percent filled	. then 75 % of the 16.
	Efficient reterival 	
	Disadvantage:
		High Memory over head.
		
	