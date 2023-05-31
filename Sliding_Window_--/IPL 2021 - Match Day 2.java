class Solution {
    static ArrayList<Integer> max_of_subarrays(int nums[], int n, int k) {
        // Your code here
        Deque<Integer> dq=new LinkedList<>();
        ArrayList<Integer> lst=new ArrayList<>();
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
