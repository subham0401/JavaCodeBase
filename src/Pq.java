import javax.print.DocFlavor;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class FindMediun{
    PriorityQueue<Integer> maxPQ;
    PriorityQueue<Integer> minPQ;

    public FindMediun() {
        maxPQ = new PriorityQueue<>((a,b)->b-a);
        minPQ = new PriorityQueue<>();
    }

    public void addNumber(int num){
        // alway add into maxPQ
        maxPQ.add(num);
        // if lasrgest of max> smallest of min then move min->max
        if((!minPQ.isEmpty()) && (maxPQ.peek()>minPQ.peek())){
            minPQ.add(maxPQ.poll());
        }
        // make size balance
        if(maxPQ.size()>minPQ.size()+1){
            minPQ.add(maxPQ.poll());
        } else if (minPQ.size()>maxPQ.size()) {
            maxPQ.add(minPQ.poll());
        }

    }

    public double findMediunOfCurrectData(){
        if(maxPQ.size()== minPQ.size()){
            return (maxPQ.peek()+minPQ.peek())/2.0;
        }
        else{
            return maxPQ.peek();
        }

    }



    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fmap = new HashMap<>();
        for(int n : nums){
            fmap.put(n , fmap.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> minPQ = new PriorityQueue<>
                ((a,b)->fmap.get(a)-fmap.get(b));

        for(int key : fmap.keySet()){
            minPQ.add(key);
            if(minPQ.size()>k){
                minPQ.poll();
            }
        }

        int[] res = new int[minPQ.size()];
        int j =0;
        while (!minPQ.isEmpty()){
            res[j++]= minPQ.poll();
        }
        return res;
    }
}


public class Pq {
    public static void main(String[] args) {

        FindMediun obj = new FindMediun();

        obj.addNumber(15);
        obj.addNumber(20);
        obj.addNumber(2);
        obj.addNumber(44);

        System.out.println("mediaun = "+ obj.findMediunOfCurrectData());


        int[] arr  = new int[]{1,1,1,2,2,3};
        int k =2;

        int[] res = obj.topKFrequent(arr,2);
        for(int n : res){
            System.out.println("top k freq "+ n);
        }
    }
}
