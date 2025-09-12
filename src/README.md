What is a Stream?

A Stream in Java is a sequence of data (like a pipeline) that you can process using operations (filter, map, reduce, etc.).

Unlike collections, streams don’t store data, they process data from a source (like a collection, array, or I/O channel).

Key points:

Streams don’t modify the original data.

Operations can be intermediate (return another stream) or terminal (produce a result).

Streams are processed lazily → operations are not executed until a terminal operation is invoked.

How to Create Streams

Ways to create streams:

From Collection

List<String> names = Arrays.asList("Pavan", "Reddy", "Java");
Stream<String> stream = names.stream();

From Arrays

int[] arr = {1, 2, 3};
IntStream intStream = Arrays.stream(arr);


Using Stream.of

Stream<String> stream = Stream.of("a", "b", "c");

Level 3: Stream Operations

There are two types:

Intermediate operations → return a new stream (lazy).
Examples: filter(), map(), distinct(), sorted(), limit(), skip(), flatMap().

Terminal operations → produce result (triggers execution).
Examples: collect(), forEach(), reduce(), count(), min(), max().


List<String> names = Arrays.asList("Pavan", "Reddy", "Pavan", "Java");

List<String> result = names.stream()
.filter(n -> n.length() > 4)   // intermediate
.distinct()                   // intermediate
.sorted()                     // intermediate
.toList();                    // terminal



Most Important Operations

filter(Predicate)

map(Function)

flatMap(Function)

distinct()

sorted()

limit(n), skip(n)

peek(Consumer) (for debugging)

reduce(identity, accumulator)

collect(Collectors.toList(), toSet(), groupingBy(), partitioningBy())

forEach(Consumer)

count(), min(), max(), findFirst(), findAny()


Collectors.toList() vs .toList()

