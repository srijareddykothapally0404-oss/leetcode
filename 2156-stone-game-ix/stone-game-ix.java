class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] ct=new int[3];
        for(int x:stones){
            ct[x%3]++;

        }
        int a=ct[0];
        int b=ct[1];
        int c=ct[2];
        if(ct[0]%2==0)
          return ct[1]>0&&ct[2]>0;

          return Math.abs(ct[1]-ct[2])>2;
    }
}