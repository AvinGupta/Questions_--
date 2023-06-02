class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string t.
    public static String smallestWindow(String s, String t)
    {
        // Your code here
        HashMap<Character,Integer> map=new HashMap<>();
        int spt=0;
        int ept=0;
        int len=Integer.MAX_VALUE;
        String ans="";
        
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!map.containsKey(ch)) map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
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
        if(ans.length()==0) return "-1";
        return ans;
    }
}
