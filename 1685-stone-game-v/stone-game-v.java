class Solution {
    int[][] dp;
        int[] p;
        
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new int[n][n];
        p=new int[n+1];
        for(int i=0;i<n;i++){
            p[i+1]=p[i]+stoneValue[i];
            Arrays.fill(dp[i],-1);
        }
        return solve(stoneValue,0,n-1);
    }
    public int solve(int[] a,int i,int j){
        if(i>=j)
        return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int ans=0;

        for(int k=i;k<j;k++){
            int left=p[k+1]-p[i];
            int right=p[j+1]-p[k+1];

            if(left<right)
                ans=Math.max(ans,left+solve(a,i,k));
            else if(left>right)
                ans=Math.max(ans,right+solve(a,k+1,j));
            else
                ans=Math.max(ans,left+Math.max(solve(a,i,k),solve(a,k+1,j)));
        }

        return dp[i][j]=ans;
    }
}