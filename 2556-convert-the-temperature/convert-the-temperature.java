class Solution {
    public double[] convertTemperature(double celsius) {
        double x=celsius+273.15;
        double y=celsius*1.80+32.00;
        double[] ans=new double[2];
        ans[0]=x;
        ans[1]=y;
        return ans;
    }
}