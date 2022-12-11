//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[N][N];
        for(int[]d : dp) Arrays.fill(d, -1);
        
        for(int i = 0; i < N; i++){
            max = Math.max(max, getMaxPath(0, i, N, Matrix, dp));
        }
        return max;
    }
    private static int getMaxPath(int r, int c, int n, int[][] matrix, int[][] dp) {
        
        if(r < 0 || r == n || c == n || c < 0) return 0;
        
        if(dp[r][c] != -1) return dp[r][c];
        
        int down = matrix[r][c] + getMaxPath(r+1, c, n, matrix, dp);
        int diag = matrix[r][c] + getMaxPath(r+1, c+1, n, matrix, dp);
        int antidiag = matrix[r][c] + getMaxPath(r+1, c-1, n, matrix, dp);
        
        return dp[r][c] = Math.max(down, Math.max(diag, antidiag));
    }
}