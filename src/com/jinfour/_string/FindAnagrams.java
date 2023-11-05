package com.jinfour._string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

    public static void main(String[] args) {
        FindAnagrams fd = new FindAnagrams();
        fd.findAnagrams("ababc", "ab");
    }



    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            len++;
            if(len > p.length()) {
                int start = i-p.length();
                if(sMap.get(s.charAt(start)) > 1) {
                    sMap.put(s.charAt(start), sMap.get(s.charAt(start))-1);
                }else {
                    sMap.remove(s.charAt(start));
                }
                len--;
            }
            if(check(sMap, pMap)) {
                ans.add(i-p.length()+1);
            }
        }
        return ans;
    }

    boolean check(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        for(char c : pMap.keySet()) {
            if(!sMap.containsKey(c) || sMap.get(c) != pMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
