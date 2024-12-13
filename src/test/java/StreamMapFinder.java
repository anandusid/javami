import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMapFinder {

    public static void main(String[] args) {
    	
    	List<String> fruitList = Arrays.asList("aaa", "bbb", "ccc", "aa", "bb", "cc", "a", "b", "c");
    	
    	int length = fruitList.stream().mapToInt(String::length).max().orElse(0);
       
    }
}
