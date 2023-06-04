class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here
	    int total=0;
	    int sum=0;
	    int pos=0;
	    for(int i=0;i<petrol.length;i++){
	        sum+=petrol[i]-distance[i];
	        if(sum<0){
	            total+=sum;
	            pos=i+1;
	            sum=0;
	        }
	    }
	    total+=sum;
	    return (total>=0)? pos:-1;
    }
}
