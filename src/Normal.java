import java.util.*;

public class Normal {
    public static void main(String[] args) {

        Map<Integer,Integer> map = new TreeMap<>();

        map.put(null,100);
        map.put(null ,200);
        map.put(null,300);

        System.out.printf("result = "+ map.get(null));


    }
}
