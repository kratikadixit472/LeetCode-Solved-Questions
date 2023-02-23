class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int[][] projects = new int[profits.length][2];
        for(int i = 0; i < profits.length; i++)
        {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(projects, (a, b) -> a[1] - b[1]);
        for(int i = 0; i < profits.length; i++)
        {
            if(projects[i][1] <= w)
            {
                pq.add(projects[i][0]);
            }
            else
            {
                while(projects[i][1] > w)
                {
                    if(pq.size() == 0 || k <= 0)
                    {
                        return w;
                    }
                    k--;
                    w += pq.poll();
                }
                pq.add(projects[i][0]);
            }
        }
        while(k > 0 && pq.size() != 0)
        {
            k--;
            w += pq.poll();
        }
        return w;
    }
}