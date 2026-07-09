class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        HashMap <Character, Integer> map= new HashMap<>();
        HashMap<Character, Integer> window= new HashMap<>();
        //This is the first string's frequency//
        for (char s : s1.toCharArray()){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        //Window size
        int len= s1.length();
        for (int i=0; i<len;i++){
            char x = s2.charAt(i);
            window.put(x, window.getOrDefault(x, 0)+1);
        }
        if (map.equals(window)){
            return true;
        }
        for(int j= len; j<s2.length();j++){
            char add= s2.charAt(j);
            window.put(add, window.getOrDefault(add, 0)+1);
            
            char remove = s2.charAt(j-len);
            window.put(remove, window.get(remove)-1);
            if (window.get(remove) == 0) {
                window.remove(remove);
            }
            if(map.equals(window)){
                return true;
            }
        }
        return false;
    }
}