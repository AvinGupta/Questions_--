
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] isVisited=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> lst=new ArrayList<>();
        isVisited[0]=true;
        q.add(0);
        while(!q.isEmpty()){
            Integer node=q.poll();
            lst.add(node);

            for(Integer x:adj.get(node)){
                if(!isVisited[x]){
                    isVisited[x]=true;
                    q.add(x);
                }
            }
        }
        return lst;
    }
}
