//find k most frequent items in the array method-1
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
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
public class KMostFrequentItemsMethod1 {
    public static void Kmost(int arr[],int k)
    {
        Map<Integer,Integer> m=new HashMap<>();
        
        //inserting items into map with frequencies
        for(int i=0;i<arr.length;i++){
            m.put(arr[i], m.getOrDefault(arr[i], 0)+1);
        }
        
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(m.entrySet());
        Collections.sort(list,new MyCmp());
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i).getKey()+":"+list.get(i).getValue());
    }
    public static void main(String[] args)
    {
        int[] arr={10, 20, 10, 30, 10, 20, 30};
        int k=2;
        Kmost(arr,k);
    }
}
