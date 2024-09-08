class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        Node spt=head;
        Node ept=head;
        while(ept.next!=null) ept=ept.next;
        ArrayList<ArrayList<Integer>> lst=new ArrayList<>();
        while(spt!=null && ept!=null && spt.data<ept.data){
            int sum=spt.data+ept.data;
            if(sum==target){
                ArrayList<Integer> ans=new ArrayList<>();
                ans.add(spt.data);
                ans.add(ept.data);
                lst.add(ans);
                spt=spt.next;
                ept=ept.prev;
            }
            else if(sum<target) spt=spt.next;
            else ept=ept.prev;
        }
        return lst;
    }
}
