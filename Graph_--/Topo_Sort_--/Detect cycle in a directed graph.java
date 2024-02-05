class Solution {
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        //calculate the indegree of each node.
        int[] inDegree=new int[V];
        for(int i=0;i<V;i++){
            for(int x:adj.get(i)){
                inDegree[x]++;
            }
        }
        //put all the node with indegree equals to zero into the queue.
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[V];
        int i=0;
        int count=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            count++;
            ans[i++]=node;
            
            for(int x:adj.get(node)){
                inDegree[x]--;
                if(inDegree[x]==0){
                    q.add(x);
                }
            }
        }
        if(count==V) return false;
        return true;
    }
}
