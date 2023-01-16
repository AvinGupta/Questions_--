class Solution
{
   public int josephus(int n, int k)
    {
        return Josephus_prob(n,k)+1;
    }
    static int Josephus_prob(int n,int k){
        if(n==1) return 0;
        return (Josephus_prob(n-1,k)+k)%n;
    }
}
//general idea is mentioned in leetcode repo;
