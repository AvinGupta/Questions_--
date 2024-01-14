import java.util.*;
public class Main
{
    public static void countSort(int[] arr){
        if(arr.length<=1) return;
        
        // finding largest element in the arr
        int max=arr[0];
        for(int x:arr){
            if(x>max){
                max=x;
            }
        }
        
        //create freq arr of size max+1;
        //and calculate the freq of every element in the arr.
        int[] freq=new int[max+1];
        for(int x:arr){
            freq[x]++;
        }
        
        int index=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                while(freq[i]>0){
                    arr[index]=i;
                    index++;
                    freq[i]--;
                }
            }
        }
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<arr.length;i++) arr[i]=sc.nextInt();
		countSort(arr);
		System.out.println(Arrays.toString(arr));
		sc.close();
	}
}
