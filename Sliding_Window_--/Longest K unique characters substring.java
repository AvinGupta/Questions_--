class Solution {
    public int longestkSubstr(String s, int k) {
        int max=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        int s_pt=0;
        int e_pt=0;
        while(e_pt<s.length()){
            char ch=s.charAt(e_pt);
            if(!map.containsKey(ch)) map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
            
            if(map.size()==k){
                max=Math.max(max,e_pt-s_pt+1);
            }
            else if(map.size()>k){
                while(map.size()>k){
                    char ch1=s.charAt(s_pt);
                    map.put(ch1,map.get(ch1)-1);
                    if(map.get(ch1)==0) map.remove(ch1);
                    s_pt++;
                }
            }
            e_pt++;
        }
        return max;
    }
}
