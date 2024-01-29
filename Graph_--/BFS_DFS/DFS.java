
class Solution {
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> lst,boolean[] isVisited){
        isVisited[node]=true;
        lst.add(node);
        
        for(Integer x:adj.get(node)){
            if(!isVisited[x]){
                dfs(x,adj,lst,isVisited);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> lst=new ArrayList<>();
        boolean[] isVisited=new boolean[V];
        // isVisited[0]=true; not required
        
        //for connected graph
        // dfs(0,adj,lst,isVisited);
        
        // for not connected graph.
        for(int i=0;i<isVisited.length;i++){
            if(!isVisited[i]){
                dfs(i,adj,lst,isVisited);
            }
        }
        return lst;
    }
}
