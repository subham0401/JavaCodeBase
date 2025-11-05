package thread;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class For {
    public static void main(String[] args) {



        Integer[] arr = {1,2,3,4,5,6,7,8};
        ArrayList<Integer> res = new ArrayList<>();
        Collections.addAll(res, arr);


        Consumer consumer = ( o)-> System.out.println(o);

        res.forEach(consumer);

        res.forEach(o-> System.out.println(o));


        Hashtable<Integer , Integer> hashtable = new Hashtable<>();
        hashtable.put(10,10);

        ConcurrentHashMap<Integer, Integer> con = new ConcurrentHashMap<>();
        con.put(10,10);



    }
}
