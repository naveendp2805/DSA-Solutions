class Solution {
    public int zigzagSequence(int[][] mat) {
        // code here
        int n = mat.length;
        
        int[] dp = new int[n];
        for(int j=0; j<n; j++)
            dp[j] = mat[0][j];
            
        for(int i=1; i<n; i++)
        {
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
            int maxColumn = -1;
            
            for(int j=0; j<n; j++)
            {
                if(dp[j] > max1)
                {
                    max2 = max1;
                    max1 = dp[j];
                    maxColumn = j;
                }
                else if(dp[j] > max2)
                {
                    max2 = dp[j];
                }
            }
            
            int[] newDp = new int[n];
            
            for(int j=0; j<n; j++)
            {
                if(j != maxColumn)
                {
                    newDp[j] = mat[i][j] + max1;
                } else {
                    newDp[j] = mat[i][j] + max2;
                }
            }
            
            dp = newDp;
        }
        
        int res = 0;
        for(int ele : dp)
            res = Math.max(res, ele);
            
        return res;
    }
}