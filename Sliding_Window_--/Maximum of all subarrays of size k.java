class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int nums[], int n, int k){
        if(k>nums.length){
            int max=nums[0];
             for(int i=1;i<nums.length;i++){
                if(nums[i]>max) max=nums[i];
            }
            return new ArrayList<>(max);
        }
        else{
            ArrayList<Integer> lst=new ArrayList<>();
            Deque<Integer> dq=new LinkedList<>();
            int s_pt=0;
            int e_pt=0;
            while(e_pt<nums.length){
                if(dq.size()==0) dq.add(nums[e_pt]);
                else{
                    while(dq.size()>0 && dq.peekLast()<nums[e_pt]) dq.removeLast();
                    dq.add(nums[e_pt]);
                }
                if((e_pt-s_pt+1)<k) e_pt++;
                else if((e_pt-s_pt+1)==k){
                    lst.add(dq.peek());
                    if(nums[s_pt]==dq.peek()) dq.removeFirst();
                    e_pt++;
                    s_pt++;
                }
            }
            return lst;
        }
    }
}
