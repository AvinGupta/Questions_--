class Solution{
    int longestUniqueSubsttr(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        int spt=0;
        int ept=0;
        int max=Integer.MIN_VALUE;
        while(ept<s.length()){
            char ch=s.charAt(ept);
            if(!map.containsKey(ch)) map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
            
            if(map.size()==ept-spt+1) max=Math.max(max,ept-spt+1);
            else if(map.size()<ept-spt+1){
                while(map.size()<ept-spt+1){
                    char ch1=s.charAt(spt);
                    map.put(ch1,map.get(ch1)-1);
                    if(map.get(ch1)==0) map.remove(ch1);
                    spt++;
                }
            }
            ept++;
        }
        return max;
    }
}
