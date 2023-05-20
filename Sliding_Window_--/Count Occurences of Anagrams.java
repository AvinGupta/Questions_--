class Solution {

    int search(String p, String s) {
        int k=p.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<p.length();i++){
            if(!map.containsKey(p.charAt(i))) map.put(p.charAt(i),1);
            else map.put(p.charAt(i),map.get(p.charAt(i))+1);
        }
        int ans=0;
        int s_pt=0;
        int e_pt=0;
        int cnt=map.size();
        while(e_pt<s.length()){
            if(map.containsKey(s.charAt(e_pt))){
                map.put(s.charAt(e_pt),map.get(s.charAt(e_pt))-1);
                if(map.get(s.charAt(e_pt))==0) cnt--;
            }
            if(e_pt-s_pt+1<k) e_pt++;
            else if(e_pt-s_pt+1==k){
                if(cnt==0) ans++;
                if(map.containsKey(s.charAt(s_pt))){
                    map.put(s.charAt(s_pt),map.get(s.charAt(s_pt))+1);
                    if(map.get(s.charAt(s_pt))==1){
                        cnt++;
                    }
                }
                e_pt++;
                s_pt++;
            }
        }
        return ans;
    }
}
