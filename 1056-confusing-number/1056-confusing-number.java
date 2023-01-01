class Solution {
    public boolean confusingNumber(int N) {
        if(N == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 9); map.put(9, 6); map.put(0, 0); map.put(8, 8); map.put(1, 1);
        int rev = 0, n = N;
        while(n > 0){
            if(n % 10 == 2 || n % 10 == 3 || n % 10 == 4 || n % 10 == 5 || n % 10 == 7) return false;
            int last = n % 10;
            rev = rev * 10 + map.get(last);
            n /= 10;
        }
        return (rev != N);
    }
}