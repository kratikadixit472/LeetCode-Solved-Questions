class Solution {
    public String reformatDate(String date) {
        String[] arr = date.split("\\ ");
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01"); map.put("Feb", "02"); map.put("Mar", "03");
        map.put("Apr", "04"); map.put("May", "05"); map.put("Jun", "06");
        map.put("Jul", "07"); map.put("Aug", "08"); map.put("Sep", "09");
        map.put("Oct", "10"); map.put("Nov", "11"); map.put("Dec", "12"); 
        StringBuilder sb = new StringBuilder();
        
        sb.append(arr[2]); sb.append("-");
        sb.append(map.get(arr[1])); sb.append("-");
        String day = "";
        for(char c : arr[0].toCharArray()){
            if(Character.isDigit(c)) day += c;
            else break;
        }
        if(day.length() == 1) day = "0"+day;
        sb.append(day);
        return sb.toString();
    }
}