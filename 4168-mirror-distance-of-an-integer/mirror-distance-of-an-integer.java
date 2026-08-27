class Solution {
    public int mirrorDistance(int n) {
        int rev=0;
        int x=n;
        while(x>0){
            int r=x%10;
            rev=rev*10+r;
            x=x/10;
        }
        return Math.abs(n-rev);
    }
}