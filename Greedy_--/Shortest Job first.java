class Solution {
    static int solve(int bt[] ) {
    // code here
    Arrays.sort(bt);
    int time=0;
    int wtTime=0;
    for(int i=0;i<bt.length;i++){
        wtTime+=time;
        time+=bt[i];
    }
    return wtTime/bt.length;
  }
}
     
