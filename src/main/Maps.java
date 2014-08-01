package main;

import java.util.HashMap;

public class Maps {
	public static HashMap<Character, int[]> HexBinaryMap = loadHash();
	public static Character[] PidMap = loadPids();
	
	private static HashMap<Character, int[]> loadHash(){
		HashMap<Character, int[]> map = new HashMap<Character, int[]>();
		map.put('1', new int[] {0,0,0,1});
		map.put('2', new int[] {0,0,1,0});
		map.put('3', new int[] {0,0,1,1});
		map.put('4', new int[] {0,1,0,0});
		map.put('5', new int[] {0,1,0,1});
		map.put('6', new int[] {0,1,1,0});
		map.put('7', new int[] {0,1,1,1});
		map.put('8', new int[] {1,0,0,0});
		map.put('9', new int[] {1,0,0,1});
		map.put('A', new int[] {1,0,1,0});
		map.put('B', new int[] {1,0,1,1});
		map.put('C', new int[] {1,1,0,0});
		map.put('D', new int[] {1,1,0,1});
		map.put('E', new int[] {1,1,1,0});
		map.put('F', new int[] {1,1,1,1});
		return map;
	}
	
	private static Character[] loadPids(){
		Character[] pids = {'1','2','3','4','5','6','7','8','9','A', 'B', 'C', 'D', 'E', 'F'};
		return pids;
	}
}
