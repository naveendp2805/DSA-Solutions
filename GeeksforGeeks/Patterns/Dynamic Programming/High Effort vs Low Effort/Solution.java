class Solution {
    public int maxTask(int[] h, int[] l) {
        // code here
        int n = l.length;
        
        int[] idle = new int[n];
        int[] work = new int[n];
        
        idle[0] = 0;
        work[0] = Math.max(l[0], h[0]);
        
        for(int i=1; i<n; i++)
        {
            int low = Math.max(idle[i-1], work[i-1]) + l[i];
            int high = idle[i-1] + h[i];
            
            idle[i] = Math.max(idle[i-1], work[i-1]);
            work[i] = Math.max(low, high);
        }
        
        return Math.max(idle[n-1], work[n-1]);
    }
}