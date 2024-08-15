import java.util.*;
class Main{
    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='+' || ch=='-') return 1;
        return -1;
    }
    public static String avn(String str){
        String rev="";
        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            if(ch==')'){
                rev+='(';
            }
            else if(ch=='('){
                rev+=')';
            }
            else{
                rev+=ch;
            }
        }
        
        int i=0;
        Stack<Character> st=new Stack<>();
        String ans="";
        while(i<rev.length()){
            char ch=rev.charAt(i);
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                ans+=ch;
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans+=st.pop();
                }
                st.pop();
            }
            else{
                if(ch=='^'){
                    while(!st.isEmpty() && priority(st.peek())>=priority(ch)){
                        ans+=st.pop();
                    }
                }
                else{
                    while(!st.isEmpty() && priority(st.peek())>priority(ch)){
                        ans+=st.pop();
                    }
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        StringBuilder sb=new StringBuilder(ans);
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String infix="F+D-C*(B+A)";
        System.out.println(avn(infix));
        sc.close();
    }
}
