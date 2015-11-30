		 Given a pattern and a string, find if the string str follows the same pattern.

Here follow means a full match, such that there is a bijection between letter in pattern and substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
Input contains only lowercase alphabetical letters.
Each letter in pattern maps to a substring with length at least 1.
		 
		    public boolean wordPatternMatch(String pattern, String str) {
		        if(pattern==null && str==null)
		            return true;
		        if(pattern==null || str==null)
		            return false;
		        Map<Character, String> map = new HashMap<Character, String>();
		        Set<String> set = new HashSet<String>();
		        return wordPatternMatch(pattern, 0, str, 0, map, set);
		    }
		    private boolean wordPatternMatch(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set){
		        if(i==pattern.length() && j==str.length())
		            return true;
		        if(i==pattern.length() || j==str.length())
		            return false;
		        char ch = pattern.charAt(i);
		        if(map.containsKey(ch)){
		            String word = map.get(ch);
		            if(j+word.length()>str.length())
		                return false;
		            String cur = str.substring(j, j+word.length());
		            if(!word.equals(cur))
		                return false;
		            return wordPatternMatch(pattern, i+1, str, j+word.length(), map, set);
		        }else{
		            for(int k=j; k<str.length(); k++){
		                String word = str.substring(j, k+1);
		                if(set.contains(word))
		                    continue;
		                set.add(word);
		                map.put(ch, word);
		                if(wordPatternMatch(pattern, i+1, str, k+1, map, set))
		                    return true;
		                set.remove(word);
		                map.remove(ch);
		            }
		            return false;
		        }
		    }
