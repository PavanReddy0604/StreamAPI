import java.util.*;
import java.util.stream.Collectors;

public class Basics {

    public static void main(String[] args) {
        List<Integer> numbers= List.of(12,1,15,16,768,343,1,43,4);
        System.out.println(numbers.toString());

        //Filter only even numbers
        List<Integer> evenList=numbers.stream().filter(n->n%2==0).toList();
        System.out.println("Even Numbers "+evenList.toString());

        //Square each number
        List<Integer> squares=numbers.stream().map(n-> n*n).toList();
        System.out.println("Squares "+squares.toString());

        //Sum of odd numbers
        int sumOfOddNums=numbers.stream().filter(n->n%2!=0).mapToInt(n->n).sum();
        System.out.println("sum of odd Numbers "+sumOfOddNums);

        //Sum of Odd nums using reduce()
        int sumOfEvenNumsUsingReduce=numbers.stream().filter(n->n%2==0).reduce((n1,n2)-> n1+n2).orElseThrow();
        System.out.println("sum of even numbers using reduce() "+sumOfEvenNumsUsingReduce);

        // max number
        int maxNumber= numbers.stream().mapToInt(n->n).max().getAsInt();
        System.out.println("Max number is "+maxNumber);

        // max number using compareTo()
       int maxNumberUsingCompareTo= numbers.stream().max(Integer::compareTo).orElseThrow();
        System.out.println("Max number using compareTo "+maxNumberUsingCompareTo);

        //avg of all numbers
        double averageNumber= numbers.stream().mapToInt(n->n).average().orElseThrow();
        System.out.println("averageNumber "+averageNumber);

        // sort all numbers
        List<Integer> sortedListOfNums=numbers.stream().sorted().toList();
        System.out.println("sorted list of nums "+ sortedListOfNums);

        //sort in reverse order
        List<Integer> reverseOrder = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("reverseOrder "+reverseOrder);


        /*
        String Based problems
         */

        List<String> words = Arrays.asList("Java", "streams", "are", "powerful", "and", "cool","java","powerful");

        //Filter words length > 4
        List<String> lengthyWords= words.stream().filter(word -> word.length()>4).toList();
        System.out.println("Words with size more than 4 are "+lengthyWords.toString());

        //Convert all to uppercase

       List<String> upperCaseList= words.stream().map(word -> word.toUpperCase()).toList();
        System.out.println("upper case list "+upperCaseList.toString());

        //sort alphabetically with case sensitive
        List<String> sortedList= words.stream().sorted().toList();
        System.out.println("Sorted list "+sortedList.toString());

        //sort alphabetically without case sensitive
        List<String> sortedListWithoutCaseSensitive= words.stream().map(word->word.toLowerCase()).sorted().toList();
        System.out.println("Sorted list alphabetically without case sensitive "+sortedListWithoutCaseSensitive.toString());


        //sort alphabetically without case sensitive
        List<String> sortedListWithoutCaseSensitivePreserveInput= words.stream().sorted(
                (s1,s2)-> s1.compareTo(s2))
                .toList();
        System.out.println("Sorted list alphabetically without case sensitive preserving input case sensitivity "+ sortedListWithoutCaseSensitivePreserveInput);

        // sort the words by their size
        List<String> sortedBasedOnLength = words.stream().sorted(Comparator.comparingInt(s->s.length())).toList();
        System.out.println("Sorted based on length "+sortedBasedOnLength);

        //Count words of length >3
        long countOfWordsSizeGreaterThan3=words.stream().filter(s->s.length()>3).count();
        System.out.println("countOfWordsSizeGreaterThan3 -> "+countOfWordsSizeGreaterThan3);

        // Longest word in the list
        String longestWord=words.stream().max(Comparator.comparingInt(s->s.length())).toString();
        System.out.println("Longest word in the list is "+longestWord);


        //group by words
        Map<Object, List<String>> groupBywords= words.stream().collect(Collectors.groupingBy(word->word));
        System.out.println("Grouping by words "+groupBywords);


        //Word frequency
        Map<Object, Long> frequencyOfWords= words.stream().collect(Collectors.groupingBy(word->word, Collectors.counting()));
        System.out.println("Frequency of words "+frequencyOfWords);

        //distinct
        List<String> distinctWOrds= words.stream().distinct().toList();
        System.out.println("distinct words are "+distinctWOrds);







    }
}
