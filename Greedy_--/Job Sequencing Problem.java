class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(a,b)->{
            return b.profit-a.profit;
        });
        int maxDeadline=-1;
        for(Job x:arr){
            maxDeadline=Math.max(maxDeadline,x.deadline);
        }
        int[] hash=new int[maxDeadline+1];
        Arrays.fill(hash,-1);
        int cntJobs=0;
        int maxProfit=0;
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(hash[j]==-1){
                    cntJobs+=1;
                    hash[j]=arr[i].id;
                    maxProfit+=arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{cntJobs,maxProfit};
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
