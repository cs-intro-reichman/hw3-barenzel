/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		boolean anagram = false; 
		if ((str1 == " ") && (str2 == " ")) {
			anagram = true;
			return anagram;	
		}	
		String word1 = "";
		String word2 = "";
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			if (ch != ' ') {
				word1 = word1 + ch;
			}
		}
		for (int i = 0; i < str2.length(); i++) {
			char ch = str2.charAt(i);
			if (ch != ' ') {
				word2 = word2 + ch;
			}
		}
		word1 = preProcess(word1);
		word2 = preProcess(word2);
		if (word1.length() != word2.length()) {
			anagram = false;
			return anagram;
		} else {
			for (int i = 0; i < word1.length(); i++) { 
				for (int j = 0; j < word2.length(); j++) {
					if (word2.charAt(j) != word1.charAt(i)) {
						anagram = false;
						continue;
					} else {
						anagram = true;
						break;
					}
				}
			}
		}
		return anagram;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String ans = "";
		int i = 0;
		while (i < str.length()) {
			char ch = str.charAt(i);
			if (ch == ' ') {
				ch = ' ';
				ans = ans + ch;
			} else if ((str.charAt(i) <='Z') && (str.charAt(i) >= 'A')) {
				ch = (char) (str.charAt(i) + 32);
				ans = ans + ch;
			} else if ((str.charAt(i) >= 'a') && (str.charAt(i) <= 'z')) {
				ans = ans + ch;
			} else if ((str.charAt(i) >= '0') && (str.charAt(i) <= '9')) {
				ans = ans + ch;
			} else {
				i++;
				continue;
			}
			i++;	
		}
		return ans;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String oldStr = str;
		String newStr = "";
		char newChar;
		while (oldStr.length() > 0) {
			int num = (int) (Math.random() * oldStr.length());
			newChar = oldStr.charAt(num);
			newStr = newStr + newChar;
			oldStr = oldStr.substring(0, num) + oldStr.substring(num + 1);
		}
		return newStr;
	}
}
