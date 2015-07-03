package cmo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null||s.length()==0){
        	return true;
        }
		
		boolean[] zeroToN = new boolean[s.length()+1];
		zeroToN[0] = true;
		for(int i=0;i<s.length();i++){
			StringBuilder str = new StringBuilder(s.substring(0, i+1));
			for(int j=0;j<=i;j++){
				if(zeroToN[j]&&wordDict.contains(str.toString())){
					zeroToN[i+1] = true;
					break;
				}
				str.deleteCharAt(0);
			}
		}
		return zeroToN[s.length()];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
