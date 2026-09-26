class Solution {
    public static boolean isAnagram(String s, String t) {

        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (char x : S) {
            mapS.put(x, mapS.getOrDefault(x, 0) + 1);
        }
        for (char x : T) {
            mapT.put(x, mapT.getOrDefault(x, 0) + 1);
        }

        for (char i : mapS.keySet() ) {
            if(!mapT.containsKey(i)){
                return false;
            }
            if(!mapS.get(i).equals(mapT.get(i))){
                return false;
            }

        }
        return true;
    }
}
