class pair{
    int first;
    int second;
    public pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // using bfs
    public static boolean detectCycle(int src,ArrayList<ArrayList<Integer>> adj,boolean[] isVisited){
        isVisited[src]=true;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(src,-1));
        while(!q.isEmpty()){
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            
            for(Integer x:adj.get(node)){
                if(!isVisited[x]){
                    isVisited[x]=true;
                    q.add(new pair(x,node));
                }
                else if(parent!=x){
                    return true;
                }
            }
        }
        return false;
    }
    
    //using dfs 
    public static boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] isVisited){
        isVisited[node]=true;
        
        for(Integer x:adj.get(node)){
            if(!isVisited[x]){
                if(dfs(x,node,adj,isVisited)) return true;
            }
            else if(x!=parent) return true;
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] isVisited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!isVisited[i]){
                // if(detectCycle(i,adj,isVisited)) return true;
                if(dfs(i,-1,adj,isVisited)) return true;
            }
        }
        return false;
    }
}
