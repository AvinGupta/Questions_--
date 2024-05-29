class Solution{
    static List<Integer> minPartition(int n)
    {
        // code here
        ArrayList<Integer> lst=new ArrayList<>();
        while(n>0){
            if(n>=2000){
                n-=2000;
                lst.add(2000);
            }
            else if(n>=500){
                n-=500;
                lst.add(500);
            }
            else if(n>=200){
                n-=200;
                lst.add(200);
            }
            else if(n>=100){
                n-=100;
                lst.add(100);
            }
            else if(n>=50){
                n-=50;
                lst.add(50);
            }
            else if(n>=20){
                n-=20;
                lst.add(20);
            }
            else if(n>=10){
                n-=10;
                lst.add(10);
            }
            else if(n>=5){
                n-=5;
                lst.add(5);
            }
            else if(n>=2){
                n-=2;
                lst.add(2);
            }
            else{
                n-=1;
                lst.add(1);
            }
        }
        return lst;
    }
}
