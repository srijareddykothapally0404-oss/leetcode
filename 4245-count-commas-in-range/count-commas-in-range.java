class Solution {
    public int countCommas(int n) {
        long x=(long)n;
        long ans=0;
        if(x>=1000)
             ans+=x-999;
        if(x>=1000000)
            ans+=x-99999;
       
        return (int)ans;
    }
}