class Solution {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String>result = new ArrayList<>();
        int i = 0;
        int n = str.length();
        while(i<n){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            int start = j+1;
            int end = start + len;
            result.add(str.substring(start,end));
            i = end;
        }
        return result;
    }
}
