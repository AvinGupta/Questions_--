import java.util.*;
public class Solution {
    public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){
        // Write your code here.
        List<List<Integer>> lst=new ArrayList<>();
        if(arr.length==0 || arr==null){
            lst.add(new ArrayList<>());
            return lst; 
        } 
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int start=arr[0][0];
        int end=arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=end){
                end=Math.max(end,arr[i][1]);
            }
            else{
                lst.add(Arrays.asList(start,end));
                start=arr[i][0];
                end=arr[i][1];
            }
        }
        lst.add(Arrays.asList(start,end));
        return lst;
    }
}
