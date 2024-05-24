class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> lst=new ArrayList<>();
        lst.add(-1);
        int spt=0;
        int ept=0;
        int sum=0;
        while(ept<arr.length){
            sum+=arr[ept];
            if(sum==s){
                int var=lst.get(0);
                if(var==-1){
                    lst.set(0,spt+1);
                    lst.add(ept+1);
                }
                else{
                    if(var>spt){
                        lst.set(0,spt+1);
                        lst.set(1,ept+1);
                    }
                }
            }
            else if(sum>s){
                while(sum>s && spt<ept){
                    sum-=arr[spt];
                    spt++;
                }
                if(sum==s){
                    int var=lst.get(0);
                    if(var==-1){
                    lst.set(0,spt+1);
                    lst.add(ept+1);
                    }
                    else{
                        if(var>spt){
                            lst.set(0,spt+1);
                            lst.set(1,ept+1);
                        }
                    }
                }
            }
            ept++;
        }
        return lst;
    }
}
