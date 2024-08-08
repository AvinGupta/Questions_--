class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        Stack<Integer> st=new Stack<>();
        List<Integer> lst=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            while(!st.isEmpty() && st.peek()>=a[i]){
                st.pop();
            }
            if(st.isEmpty()) lst.add(-1);
            else lst.add(st.peek());
            st.add(a[i]);
        }
        return lst;
    }
}
