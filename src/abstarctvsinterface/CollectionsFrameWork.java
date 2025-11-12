package abstarctvsinterface;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class Node{
    int val;
    Node node ;
    Node(int val){
        this.val= val;
        node = null;
    }
}



public class CollectionsFrameWork {
    public static void main(String[] args) {
        // you will not get CME
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        // you will get CME
        List<Integer> list1 = new ArrayList<>();

        for(int i = 0 ;i<10;i++){
                list1.add(i);
        }
        list1.add(0);
        list1.add(1);

      HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : list1){
            if(map.get(n) == null){
                map.put(n,map.getOrDefault(n,0)+1);
            }
        }


        for(int n : map.keySet()){
            System.out.println("key = "+ n +"   value = "+map.get(n));
        }



        Set<Integer> set = new HashSet<>();
        set.add(null);


    }
}
