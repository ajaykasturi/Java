
package app;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

class MyCmp implements Comparator<Map.Entry<Integer,Integer>>{
    
    @Override
    public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
        if(m1.getValue().equals(m2.getValue()))
            return m1.getKey()-m2.getKey();
        else
            return m2.getKey()-m1.getKey();
    }
   
}
public class KMostFrequentItemsMethod2 {
    public static void Kmost(int arr[],int k)
    {
        Map<Integer,Integer> m=new HashMap<>();
        
        //inserting items into map with frequencies
        for(int i=0;i<arr.length;i++){
            m.put(arr[i], m.getOrDefault(arr[i], 0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(new MyCmp());
        for(Map.Entry<Integer,Integer> e: m.entrySet())
        {
            pq.add(e);
        }
        
        //System.out.println(pq.size());
        //printing all items
        for(int i=0;i<m.size();i++)
        {
            //Map.Entry<Integer,Integer> e=pq.poll();
            //System.out.println(e.getKey()+":"+e.getValue());
            System.out.println(pq.poll());
        }
        //k most printing
        for(int i=0;i<k;i++)
        {
            //Map.Entry<Integer,Integer> e=pq.poll();
            //System.out.println(e.getKey()+":"+e.getValue());
            System.out.println(pq.poll());
        }
    }
    public static void main(String[] args)
    {
        int[] arr={10, 20, 10, 30, 10, 20, 30};
        int k=2;
        Kmost(arr,k);
    }
}
