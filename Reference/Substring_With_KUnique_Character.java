	Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", 
	the longest substring that contains 2 unique character is "bcbbbbcccb".
	
	public static String maxSubString2UniqueChars(String s) {
		int maxLen = 0;
		String maxSubstring = null;
		int start = 0;
		// declare a map to track the right most position of the two characters
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// if map contains 2 characters, process
			if (map.size() == 2 && !map.containsKey(c)) {
				if (i - start > maxLen) {
					maxLen = i - start;
					maxSubstring = s.substring(start, i);
				}
				// get the left most index for
				int leftMost = s.length();
				for (Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() < leftMost) {
						leftMost = entry.getValue();
					}
				}
				start = leftMost + 1;
				map.remove(s.charAt(leftMost));
			}
			map.put(c, i);
		}
		if (map.size() == 2 && maxLen == 0) {
			return s;
		}
		return maxSubstring;
	}
