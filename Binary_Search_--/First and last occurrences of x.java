class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        ArrayList<Long> lst=new ArrayList<>();
        lst.add((long)-1);
        lst.add((long)-1);
        int l_bnd=lower(arr,n,x);
        if(l_bnd==n || arr[l_bnd]!=x) return lst;
        lst.set(0,(long)l_bnd);
        lst.set(1,(long)upper(arr,n,x)-1);
        return lst;
    }
    
    public static int lower(long[] arr,int n,int x){
        int spt=0;
        int ept=arr.length-1;
        int ans=n;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(arr[mid]>=x){
                ans=mid;
                ept=mid-1;
            }
            else spt=mid+1;
        }
        return ans;
    }
    public static int upper(long[] arr,int n,int x){
        int spt=0;
        int ept=arr.length-1;
        int ans=n;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(arr[mid]>x){
                ans=mid;
                ept=mid-1;
            }
            else spt=mid+1;
        }
        return ans;
    }
}
