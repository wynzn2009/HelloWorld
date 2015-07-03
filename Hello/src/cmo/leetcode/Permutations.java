package cmo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> alist = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if(nums==null||nums.length==0){
			return null;
		}
		if(nums.length==1){
			list.add(nums[0]);
			alist.add(list);
			return alist;
		}
		
		boolean[] flag = new boolean[nums.length];
		Arrays.fill(flag, false);
		help(0,list,nums,alist,flag);
		return alist;
    }
	private void help(int r,List<Integer> list,int[] nums,List<List<Integer>> alist,boolean[] flag){
		if(nums.length==r){
			List<Integer> lista = new ArrayList<Integer>(list);
			alist.add(lista);
			return;
		}else{
			for(int i=0;i<nums.length;i++){
				if(flag[i]==false){
					list.add(nums[i]);
					flag[i] = true;
					help(r+1,list,nums,alist,flag);
					list.remove(list.size()-1);
					flag[i] = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map a = new HashMap();
		a.put(1, 1);
		Permutations p = new Permutations();
		int[] nums = {0,1};
		p.permute(nums);
	}

}
