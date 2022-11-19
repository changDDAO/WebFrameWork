package practice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		String fixedSentence = temp.replace(" ","");
		System.out.println(fixedSentence);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < fixedSentence.length(); i++) {
            if (map.containsKey(fixedSentence.charAt(i))) {
                int n = map.get(fixedSentence.charAt(i)) + 1;
                map.put(fixedSentence.charAt(i), n);
            } else {
                map.put(fixedSentence.charAt(i), 1);
            }
        }
        System.out.println(map);
    }
	}


