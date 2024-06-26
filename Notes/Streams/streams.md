

The key difference between intermediate operations and terminal operations in the Java Stream API lies in their purpose and their effects on streams:

Intermediate Operations
Purpose:
	     Intermediate operations transform, filter, or manipulate the elements of a stream.
		 They return another stream as a result, allowing you to chain multiple intermediate operations together to form a pipeline.
		 
Characteristics:
	     They are lazy, meaning they do not perform any processing until a terminal operation is invoked.
         Intermediate operations do not produce a final result by themselves; they merely prepare the stream for further processing.
         
Examples:
              map(): Maps each element of the stream to another value.
              
        final List<String> fruitList = Arrays.asList("ORange", "Mango", "Apple", "jackfruit", "Guva");
		final Stream<String> map = fruitList.stream().map(String::toUpperCase);
		map.forEach(System.out::println);

filter(): Filters the elements of the stream based on a condition.
			
			// filter
		final Stream<String> filter = fruitList.stream().filter(s -> s.startsWith("A"));
		filter.forEach(System.out::println);

sorted(): Sorts the elements of the stream.
distinct(): Removes duplicate elements from the stream.

flatMap(): Flattens a stream of streams into a single stream.

		// flatMap

		final List<List<String>> fruitListOfList = Arrays.asList(
				Arrays.asList("Orange", "Mango", "Apple", "Jackfruit", "Guva"),
				Arrays.asList("Grape", "Apricot", "Pineapple", "Watermelon", "Strawbery"),
				Arrays.asList("Chery", "Kivi", "Sugercane", "Tomato", "Musmabi"));

		final Stream<String> sortedFruitList = fruitListOfList.stream().flatMap(s -> s.stream().sorted());
		sortedFruitList.forEach(System.out::println);
		

	
Terminal Operations
Purpose:

Terminal operations consume the elements of a stream and produce a final result.
They trigger the processing of the stream and cause intermediate operations to execute.
Characteristics:

They are eager, meaning they initiate the processing of the stream and produce a result.
After a terminal operation is invoked, the stream is consumed, and it cannot be reused.
Examples:

collect(): Collects the elements of the stream into a collection or other data structure.

		// collect()

		final List<List<String>> fruitListOfListM = Arrays.asList(
				Arrays.asList("Orange", "Mango", "Apple", "Jackfruit", "Guva"),
				Arrays.asList("Grape", "Apricot", "Pineapple", "Watermelon", "Strawbery"),
				Arrays.asList("Chery", "Kivi", "Sugercane", "Tomato", "Musmabi"));

		final List<String> sortedFruitListM = fruitListOfList.stream().flatMap(List::stream)
				.collect(Collectors.toList());

		final var count = IntStream.range(0, sortedFruitListM.size()).boxed()
				.collect(Collectors.toMap(i -> i + 1, i -> sortedFruitListM.get(i)));

		System.out.println(count);
		
forEach(): Performs an action for each element of the stream.
reduce(): Performs a reduction on the elements of the stream to produce a single value.

		// reduce

		final List<String> fruitListR = Arrays.asList("ORange", "Mango", "Apple", "jackfruit", "Guva");

		final String all = fruitListR.stream().reduce(String::concat).orElse(null);
		System.out.println(all);
		
count(): Counts the number of elements in the stream.

anyMatch(), allMatch(), noneMatch(): Checks if any, all, or none of the elements match a given predicate.

Summary

Intermediate operations: Transform and prepare the stream for further processing. They are lazy and return another stream.

Terminal operations: Consume the stream and produce a final result. They are eager and cannot be followed by other operations.

Understanding this distinction is crucial for designing efficient stream pipelines and avoiding unexpected behavior, such as intermediate operations not being executed if a terminal operation is not present.