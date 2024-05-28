/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
          Arrays.sort(arr,(a,b)->{
            return Double.compare((double)b.value/(double)b.weight,(double)a.value/(double)a.weight);
        });
        double ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].weight<=w){
                ans+=arr[i].value;
                w-=arr[i].weight;
            }
            else{
                ans+=((double)arr[i].value/(double)arr[i].weight)*(double)w;
                break;
            }
        }
        return ans;
    }
}
