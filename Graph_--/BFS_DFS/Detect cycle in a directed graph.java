class Solution {
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] isVisited,int[] pathVisited){
        isVisited[node]=1;
        pathVisited[node]=1;
        
        for(Integer x:adj.get(node)){
            if(isVisited[x]==0){
                if(dfs(x,adj,isVisited,pathVisited)==true) return true;
            }
            else if(pathVisited[x]==1) return true;
        }
        pathVisited[node]=0;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] isVisited=new int[V];
        int[] pathVisited=new int[V];
        for(int i=0;i<V;i++){
            if(isVisited[i]==0){
                if(dfs(i,adj,isVisited,pathVisited)==true) return true;
            }
        }
        return false;
    }
}
