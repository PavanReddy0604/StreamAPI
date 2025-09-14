import java.util.*;
import java.util.stream.Collectors;

public class Medium {

    public static void main(String[] args) {

        List<String> words=List.of("Java", "streams", "are", "powerful", "and", "cool","java","powerful","intelliJ");
        List<Integer> numbers= List.of(12,1,15,16,768,343,1,43,4);
        String name="kavan";


        //Sort a list of strings in reverse order
        List<String> reverseOrderWords=words.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("sorted in reverse order "+reverseOrderWords);

        // sorting reverse using lambda comparator
        List<String> reversedUsingLambdaOperator=words.stream().sorted((s1,s2)-> s2.compareTo(s1)).toList();
        System.out.println("reversed using lambda operator "+reversedUsingLambdaOperator);

        //sort words without case sensitive preserving the original list
        List<String> sortedListWithoutCaseSensitivePreservingOriginal=words.stream().sorted((s1,s2) -> s1.compareToIgnoreCase(s2)).toList();
        System.out.println("sort words without case sensitive preserving the original list "+sortedListWithoutCaseSensitivePreservingOriginal);

      //Count number of words starting with a vowel
        long wordsStartWithVowel= words.stream().filter(word-> word.matches("^[aeiouAEIOU].*")).count();
        /*
        Explanation of the regex ==>   ^[aeiouAEIOU].*
         1. ^
            Means start of the string.
            Whatever follows must appear at the very beginning.

        2. [aeiouAEIOU]
               A character class.
               Matches exactly one character from the set inside the brackets.

        Here: any vowel, lowercase (a e i o u) or uppercase (A E I O U).

        3. .*
                . → matches any character (except newline, unless you enable DOTALL).

                * → means "zero or more" occurrences of the preceding element.

<>              </>ogether, .* means any sequence of characters (possibly empty).
         */
        System.out.println("NumberOfWordsStartsWithVowel ->  "+ wordsStartWithVowel);

        //second largest number
        int secondLargestNumber=numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow();
        System.out.println("second largest number -> "+secondLargestNumber);

        //remove duplicates and sort
        List<Integer> distinctSortedList=numbers.stream().distinct().sorted().toList();
        System.out.println("Distinct sorted list "+distinctSortedList);

        //Group words by their length
        Map<Integer,List<String>> wordsGroupedByLengthOfWords= words.stream().collect(Collectors.groupingBy(s->s.length(),Collectors.toList()));
        System.out.println("wordsGroupedByLengthOfWordsWithDuplicates "+wordsGroupedByLengthOfWords);

        Map<Integer, Set<String>> wordsGroupedByLengthOfWordsWithoutDuplicates= words.stream().collect(Collectors.groupingBy(s->s.length(),Collectors.toSet()));
        System.out.println("wordsGroupedByLengthOfWordsWithOutDuplicates "+wordsGroupedByLengthOfWordsWithoutDuplicates);

        //Get top 3 highest numbers
        List<Integer> top3Numbers=numbers.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println("top 3 numbers -> "+ top3Numbers);

        //Join all words into a sentence

        String singleWordJoined=words.stream().collect(Collectors.joining(" "));
        System.out.println("all words in the after joining with white space -> "+singleWordJoined);

        String singleWordJoinedAfterSorting=words.stream().sorted().collect(Collectors.joining(" "));
        System.out.println("all words in the after joining with white space after sorting -> "+singleWordJoinedAfterSorting);

        //Partition numbers into even and odd

        Map<Boolean, List<Integer>> partitionedByEvenAndOdd=numbers.stream().collect(Collectors.partitioningBy(n-> n%2==0));
        System.out.println("partitioned by even and odd -> "+partitionedByEvenAndOdd);

        Map<Boolean, List<Integer>> partitionedByEvenAndOddCollectingIntoList=numbers.stream().collect(Collectors.partitioningBy(n-> n%2==0, Collectors.toList()));
        System.out.println("partitioned by even and odd -> "+partitionedByEvenAndOddCollectingIntoList);

        //Partition numbers into even and odd using grouping by
        Map<Boolean,List<Integer>> partitionedUsingGroupingBy=numbers.stream().collect(Collectors.groupingBy(n->n%2==0,Collectors.toList()));
        System.out.println("partioned using Grouping by -> "+ partitionedUsingGroupingBy);

        //Find all words with length > 3 and sort them
        List<String> sortedTheBiggerWords= words.stream().filter(s->s.length()>3).sorted().toList();
        System.out.println("sorted the bigger words "+sortedTheBiggerWords);

        //Find the average length of words
        Double averageLengthOfWords= words.stream().mapToInt(s->s.length()).average().getAsDouble();
        System.out.println("average Length of words "+ averageLengthOfWords);

        //Find all duplicate elements
        List<String> duplicateWords=words.stream().filter(n-> Collections.frequency(words, n)>1).toList();
        System.out.println("duplicate words "+duplicateWords);

        // Find all unique elements
        List<String> uniqueWords=words.stream().map(word->word.toLowerCase()).filter(word-> Collections.frequency(words, word)==1).toList();
        System.out.println("Unique words "+uniqueWords);


        //Find first non-repetitive element in list
        String firstNonRepetitiveWord=words.stream().filter(n-> Collections.frequency(words, n)==1).findFirst().orElseThrow();
        System.out.println("First non-repetitive word in the list "+firstNonRepetitiveWord);

        // Find the duplicate or unique without case sensitivity
        List<String> uniqueWithOutCaseSensitivity=words.stream().filter(word-> Collections.frequency(words.stream().map(w->w.toLowerCase()).toList(),word)==1).toList();
        System.out.println("uniqueWithOutCaseSensitivity "+uniqueWithOutCaseSensitivity);

        //Find the first non-repeated character in a string
//        Arrays.stream(name.toCharArray()).
        char firstNonRepetitiveChar=name.chars().mapToObj(c-> (char)c).filter(c-> name.indexOf(c)==name.lastIndexOf(c)).findFirst().orElseThrow();
        System.out.println("First non repetitive char in "+ name +" is --> "+firstNonRepetitiveChar);

        //first repetitive character
        char firstRepetitiveChar= name.chars().mapToObj(c-> (char) c).filter(c-> name.indexOf(c)!=name.lastIndexOf(c)).findFirst().orElseThrow();
        System.out.println("First repetitive char in "+ name +" is --> "+firstRepetitiveChar);

        //Sum integers by odd/even
        Map<String,Integer> sumOfEvenAndOddNums= numbers.stream().collect(Collectors.groupingBy(n->n%2==0? "sumOfEven" : "sumOfOdd", Collectors.summingInt(
                n->n
        )));
        System.out.println("sumOfEvenAndOddNums  "+sumOfEvenAndOddNums  );

        //Average word length per first character
        Map<Character, Double> avgWordPerLengthBasedOnFirstCharOfTheWord=words.stream().collect(Collectors.groupingBy(word->word.charAt(0), Collectors.averagingInt(word->word.length())));
        System.out.println("avgWordPerLengthBasedOnFirstCharOfTheWord  "+avgWordPerLengthBasedOnFirstCharOfTheWord);

        //Group words by length and store uppercase versions
        Map<Integer,List<String>> groupedWordsByLengthWithUpperCaseValues= words.stream().collect(Collectors.groupingBy(word-> word.length(), Collectors.mapping(word->word.toUpperCase(), Collectors.toList())));
        System.out.println("groupedWordsByLengthWithUpperCaseValues  "+groupedWordsByLengthWithUpperCaseValues);

    }
}
