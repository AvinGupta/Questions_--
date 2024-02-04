class Solution
{   
    public static boolean bfs(int node,ArrayList<ArrayList<Integer>> adj,int[] color){
        
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=0;
        while(!q.isEmpty()){
            node=q.peek();
            q.remove();
            
            for(Integer x:adj.get(node)){
                if(color[x]==-1){
                    q.add(x);
                    color[x]=1-color[node];
                }
                else if(color[node]==color[x]) return false;
            }
        }
        return true;
    }
    public static boolean dfs(int node,int col,ArrayList<ArrayList<Integer>> adj,int[] color){
        color[node]=col;
        
        for(Integer x:adj.get(node)){
            if(color[x]==-1){
                if(dfs(x,1-col,adj,color)==false) return false;
            }
            else if(col==color[x]) return false;
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                // if(dfs(i,0,adj,color)==false) return false;
                if(bfs(i,adj,color)==false) return false;
            }
        }
        return true;
    }
}
