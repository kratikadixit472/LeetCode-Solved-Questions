public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0, n = s.length();
        List<String> ans = new ArrayList<>();
        
        while(i < n){
            int idx = s.indexOf('/', i);
            int len = Integer.valueOf(s.substring(i, idx));
            i = idx + 1 + len;
            ans.add(s.substring(idx + 1, i));
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));