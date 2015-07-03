package cmo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
        	return 0;
        }
        if(nums.length==1){
        	return 1;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	set.add(nums[i]);
        }
        int longest = 1;
        while(!set.isEmpty()){
        	for(Integer a : set){
        		int temp = 1;
        		int aa = a;
        		Set<Integer> set1 = new HashSet<Integer>();
        		set1.add(a);
        		while(set.contains(++a)){
        			temp++;
        			set1.add(a);
        		}
        		while(set.contains(--aa)){
        			temp++;
        			set1.add(aa);
        		}
        		if(temp>longest){
        			longest = temp;
        		}
        		set.removeAll(set1);
        		break;
        	}
        }
    	return longest;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {0,0};
		LongestConsecutiveSequence.longestConsecutive(nums);
	}

}
