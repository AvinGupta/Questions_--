class Solution
{
    ArrayList<Integer> countDistinct(int[] arr, int n, int k)
    {
        ArrayList<Integer> lst=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int s_pt=0;
        int e_pt=0;
        while(e_pt<arr.length){
            if(!map.containsKey(arr[e_pt])) map.put(arr[e_pt],1);
            else map.put(arr[e_pt],map.get(arr[e_pt])+1);
            
            if(e_pt-s_pt+1<k) e_pt++;
            else if(e_pt-s_pt+1==k){
                lst.add(map.size());
                if(map.containsKey(arr[s_pt])){
                    map.put(arr[s_pt],map.get(arr[s_pt])-1);
                    if(map.get(arr[s_pt])==0) map.remove(arr[s_pt]);
                }
                e_pt++;
                s_pt++;
            }
        }
        return lst;
    }
}

