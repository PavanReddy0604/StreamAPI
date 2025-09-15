import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Hard {

    public static void main(String[] args) {
        List<String> words=List.of("Java", "streams", "are","ard", "powerful", "and", "cool","java","powerful","intelliJ");
        List<Integer> numbers= List.of(12,1,15,16,768,343,1,43,4);
        String name="kavan";

        Map<Character,String> largestWordWithFirstChar=words.stream().collect(Collectors.groupingBy(word->word.charAt(0),
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(word->word.length())), Optional :: get)));
        System.out.println("Largest word with first character "+largestWordWithFirstChar);
    }
}
