class Solution {
    public int findSubString(String s) {
        // Your code goes here
        HashMap<Character,Integer> map=new HashMap<>();
        int spt=0;
        int ept=0;
        int len=Integer.MAX_VALUE;
        String ans="";
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)) map.put(ch,1);
        }
        int cnt=map.size();
        while(ept<s.length()){
            char ch=s.charAt(ept);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) cnt--;
            }
            if(cnt==0){
                if(len>ept-spt+1){
                    ans=s.substring(spt,ept+1);
                    len=ept-spt+1;
                }
                while(cnt==0){
                    char chr=s.charAt(spt);
                    if(map.containsKey(chr)){
                        map.put(chr,map.get(chr)+1);
                        if(map.get(chr)>0) cnt++;
                    }
                    spt++;
                    if(cnt==0){
                        if(len>ept-spt+1){
                            ans=s.substring(spt,ept+1);
                            len=ept-spt+1;
                        }  
                    }
                }
            }
            ept++;
        }
        return len;
    }
}
