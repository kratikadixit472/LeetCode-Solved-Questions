class LogSystem {

    ArrayList<long[]> al;
    
    public LogSystem() {
        al = new ArrayList<>();
    }
    
    public void put(int id, String timestamp) {
        int[] st = Arrays.stream(timestamp.split(":")).mapToInt(Integer::parseInt).toArray();
        al.add(new long[]{convert(st), id});
    }
    
    private long convert(int[] s){
        s[1] = s[1] - (s[1] == 0 ? 0 : 1);
        s[2] = s[2] - (s[2] == 0 ? 0 : 1);
        
        return (s[0] - 1999) * (31 * 21) * 24 * 60 * 60 + s[1] * 31 * 24 * 60 * 60 + s[2] * 24 * 60 * 60 + s[3] * 60 * 60 + s[4] * 60 + s[5];
    }
    
    public List < Integer > retrieve(String s, String e, String gra) {
        ArrayList < Integer > res = new ArrayList();
        long start = granularity(s, gra, false);
        long end = granularity(e, gra, true);
        System.out.println(start +" "+end);
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i)[0] >= start && al.get(i)[0] < end)
                res.add((int) al.get(i)[1]);
        }
        return res;
    }
    
    public long granularity(String s, String gra, boolean end) {
        HashMap < String, Integer > h = new HashMap();
        h.put("Year", 0);
        h.put("Month", 1);
        h.put("Day", 2);
        h.put("Hour", 3);
        h.put("Minute", 4);
        h.put("Second", 5);
        String[] res = new String[] {"1999", "00", "00", "00", "00", "00"};
        String[] st = s.split(":");
        System.out.println();
        
        for (int i = 0; i <= h.get(gra); i++) {
            res[i] = st[i];
            System.out.print(res[i]+" ");
        }
        int[] t = Arrays.stream(res).mapToInt(Integer::parseInt).toArray();
        if (end)
            t[h.get(gra)]++;
            System.out.print(t[h.get(gra)]+" ");
        System.out.println();
        return convert(t);
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */