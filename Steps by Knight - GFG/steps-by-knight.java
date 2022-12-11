//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        // Code here
        int[][] dir = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {1, 2}, {2, 1}};
        
        LinkedList<int[]> q = new LinkedList<>();
        
        boolean[][] vis = new boolean[n+1][n+1];
        q.add(new int[]{KnightPos[0], KnightPos[1]});
        vis[KnightPos[0]][KnightPos[1]] = true;
        
        int steps = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                int[] curr = q.poll();
                int i = curr[0], j = curr[1];
                
                if(i == TargetPos[0] && j == TargetPos[1]) return steps;
                
                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    
                    if(r >= 0 && c >= 0 && r <= n && c <= n && !vis[r][c]) {
                        q.add(new int[]{r, c});
                        vis[r][c] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}