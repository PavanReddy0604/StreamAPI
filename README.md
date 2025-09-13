# Java Streams

## What is a Stream?

A **Stream** in Java is a sequence of data (like a pipeline) that you can process using operations such as `filter`, `map`, `reduce`, etc.

- Unlike collections, streams **don’t store data**, they process data from a source (like a collection, array, or I/O channel).
- Streams **don’t modify the original data**.
- Operations can be:
    - **Intermediate** → return another stream
    - **Terminal** → produce a result
- Streams are processed **lazily** → operations are not executed until a terminal operation is invoked.

## How to Create Streams

### From Collection
List<String> names = Arrays.asList("Pavan", "Reddy", "Java");
Stream<String> stream = names.stream();

### From Arrays
int[] arr = {1, 2, 3};
IntStream intStream = Arrays.stream(arr);

### Using Stream.of
Stream<String> stream = Stream.of("a", "b", "c");

## Stream Operations

### Types of Operations
- **Intermediate operations** → return a new stream (lazy)  
  Examples: filter(), map(), distinct(), sorted(), limit(), skip(), flatMap()

- **Terminal operations** → produce a result (triggers execution)  
  Examples: collect(), forEach(), reduce(), count(), min(), max()

### Example
List<String> names = Arrays.asList("Pavan", "Reddy", "Pavan", "Java");

List<String> result = names.stream()
.filter(n -> n.length() > 4)   // intermediate
.distinct()                    // intermediate
.sorted()                      // intermediate
.toList();                     // terminal

## Most Important Operations

- filter(Predicate)
- map(Function)
- flatMap(Function)
- distinct()
- sorted()
- limit(n), skip(n)
- peek(Consumer) (for debugging)
- reduce(identity, accumulator)
- collect(Collectors.toList(), toSet(), groupingBy(), partitioningBy())
- forEach(Consumer)
- count(), min(), max(), findFirst(), findAny()

## Difference Between `Collectors.toList()` and `Stream.toList()`

| Feature | `Collectors.toList()` | `Stream.toList()` |
|---------|----------------------|------------------|
| **Introduced in** | Java 8 | Java 16 |
| **Type returned** | `List<T>` (actually returns an `ArrayList`) | `List<T>` (implementation may vary, often immutable) |
| **Mutability** | Always **modifiable** | Often **unmodifiable / immutable** |
| **Usage** | Used with `collect()` method: <br>`stream.collect(Collectors.toList())` | Called directly on a stream: <br>`stream.toList()` |
| **When to use** | When targeting **Java 8–15** or need a **modifiable list** | When using **Java 16+** and **immutable list** is okay or preferred |
| **Example** | ```java<br>List<String> list = stream.collect(Collectors.toList());<br>``` | ```java<br>List<String> list = stream.toList();<br>``` |

### Key Points

- `Collectors.toList()` is **older, Java 8 compatible**, and produces a **modifiable list**.
- `Stream.toList()` is **newer, Java 16+**, and produces a **list that should be treated as unmodifiable**.

> ⚠️ Modifying a list returned by `Stream.toList()` may throw `UnsupportedOperationException`.

# Java Stream Collectors: groupingBy, partitioningBy, joining

## groupingBy

`groupingBy` is used to **group elements of a stream based on a classifier function**.  
It returns a `Map` where the key is the result of the classifier function and the value is a list of elements matching that key.

### Example
```java 
List<String> names = Arrays.asList("Pavan", "Reddy", "Pavan", "Java");
Map<String, Long> freq = names.stream()
.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
// Output: {Pavan=2, Reddy=1, Java=1}
```
- The **classifier function** determines how to group elements.
- The **downstream collector** (like `counting()`, `toList()`) determines what to do with the grouped elements.
- If no downstream is provided, it collects as `List` by default.

---

## partitioningBy

`partitioningBy` **divides elements into two groups** based on a predicate.  
It always returns a `Map<Boolean, List<T>>`.

### Example
```java 
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
Map<Boolean, List<Integer>> partitioned = numbers.stream()
.collect(Collectors.partitioningBy(n -> n % 2 == 0));
// Output: {false=[1, 3, 5], true=[2, 4, 6]}
```
- `true` key contains elements matching the predicate.
- `false` key contains elements not matching the predicate.
- You can also provide a downstream collector like `counting()`.

---

## joining

`joining` is used to **concatenate elements of a stream into a single string**.

### Example
```java
List<String> words = Arrays.asList("Java", "Stream", "API");
String result = words.stream()
.collect(Collectors.joining(", "));
// Output: "Java, Stream, API"
```
- You can specify a **delimiter** (like `", "`).
- You can also specify **prefix and suffix**:  
  String result = words.stream()
  .collect(Collectors.joining(", ", "[", "]"));
  // Output: "[Java, Stream, API]"
 
