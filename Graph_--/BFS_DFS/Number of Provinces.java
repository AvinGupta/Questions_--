//time complexity-->O(n)+O(V+2e)
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
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        
        //converting adj matrix/list containg self loop to adj list without self loop.
        ArrayList<ArrayList<Integer>> adjLst=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adjLst.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    adjLst.get(i).add(j);
                    adjLst.get(j).add(i);
                }
            }
        }
        ArrayList<Integer> lst=new ArrayList<>();
        boolean[] isVisited=new boolean[V];
    
        int count=0;
        for(int i=0;i<isVisited.length;i++){
            if(!isVisited[i]){
                count++;
                dfs(i,adjLst,lst,isVisited);
            }      
        }
        return count;
    }
}
