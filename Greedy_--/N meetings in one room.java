class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        pair[] arr=new pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new pair(start[i],end[i]);
        }
        Arrays.sort(arr,(a,b)->a.end-b.end);
        int meeting=1;
        int freetime=arr[0].end;
        for(int i=1;i<arr.length;i++){
            if(arr[i].start>freetime){
                meeting+=1;
                freetime=arr[i].end;
            }
        }
        return meeting;
    }
}
class pair{
    int start;
    int end;
    pair(int start,int end){
        this.start=start;
        this.end=end;
    }
}
