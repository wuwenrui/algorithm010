/**
 * 是否是有效的字母异位
 *
 * 字母异位词分组
 */

public class IsAnagram{


    /**
     * 是否是一个有效的字母异位词
     */
    private boolean isAnagram(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        Arrays.sort(aChar);
        Arrays.sort(bChar);
        return Arrays.equals(aChar, bChar);
    }


    /**
     * 字母异位词分组
     */
    private List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    /**
     * 字母异位词分组
     */
    private List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


































}