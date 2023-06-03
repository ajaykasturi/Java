
package app;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
//linear time solution
public class KMostFrequentItemsMethod1 {
    public static void Kmost(int arr[],int k)
    {
        int n=arr.length;
        
        Map<Integer,Integer> m=new LinkedHashMap<>();
        
        //inserting items into map with frequencies
        for(int i=0;i<arr.length;i++){
            m.put(arr[i], m.getOrDefault(arr[i], 0)+1);
        }
        
        List<List<Integer>> freq = new ArrayList<>();
        
        for(int i=0;i<=n;i++)
        {
            freq.add(new ArrayList<Integer>());
        }
        
        for(Map.Entry<Integer,Integer> x: m.entrySet())
        {
            freq.get(x.getValue()).add(x.getKey());
        }
        
        int count=0;

       for(int i=n; i>=0; i--)
       {
            for(int x: freq.get(i))
            {
                System.out.println(x);

                count++;

                if(count==k)
                    return;
            }
       }
        
    }
    public static void main(String[] args)
    {
        int[] arr={10, 20, 10, 30, 10, 20, 30};
        int k=2;
        Kmost(arr,k);
    }
}
