package com.main;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import com.main.services.DataStructureService;
import com.main.services.impl.DataStructureImpl;

public class TimeSpaceMain {
	private static final int INPUT2=100000;
	
	
	/*
	 * List<List<Long>> calculatedTimeAndSpace
	 * {
	 * 		{startTime, endTime},
	 * 		{initialFreeSpace, FinalFreeSpace}
	 * }
	 */
	private static List<List<Long>> calculatedTimeAndSpace;
	
	public static void main(String[] args) {
		
		//to access helper methods,  like print etc.
		HelperServices services = new HelperServices();
		
		
		ArrayList<Integer> arrList = new ArrayList<>();
		DataStructureImpl arrayList = new DataStructureImpl(arrList);
		calculatedTimeAndSpace =arrayList.calculateTimeAndSpace(INPUT2);
		services.printTimeAndSpace(calculatedTimeAndSpace, INPUT2, "Array List");				//print the time and space taken to insert 100,000 into arrayList;
		
		calculatedTimeAndSpace = arrayList.calculateTimeAndSpaceForDelettion(INPUT2);			//calculatedTimeAndSpace : { {startTime, EndTime}, {intial-free-space, final-free-space} };
		services.printTimeAndSpaceForDeletion(calculatedTimeAndSpace, INPUT2, "Array List");	//print the time and space taken to remove 100,000 elements from arrayList;
		
		services.printSeprator();
		
		LinkedList<Integer> linList = new LinkedList<>();
		DataStructureImpl linkedList = new DataStructureImpl(linList);
		calculatedTimeAndSpace = linkedList.calculateTimeAndSpace(INPUT2);
		services.printTimeAndSpace(calculatedTimeAndSpace, INPUT2,"Linked List");
		calculatedTimeAndSpace =linkedList.calculateTimeAndSpaceForDelettion(INPUT2);
		services.printTimeAndSpaceForDeletion(calculatedTimeAndSpace, INPUT2, "Linked List");
		
		services.printSeprator();
		
		HashSet<Integer> hSet = new HashSet<>();
		DataStructureImpl hashSet = new DataStructureImpl(hSet);
		calculatedTimeAndSpace = hashSet.calculateTimeAndSpace(INPUT2);
		services.printTimeAndSpace(calculatedTimeAndSpace, INPUT2, "Hash Set");
		calculatedTimeAndSpace = hashSet.calculateTimeAndSpaceForDelettion(INPUT2);
		services.printTimeAndSpaceForDeletion(calculatedTimeAndSpace, INPUT2, "Hash Set");
		
		
		services.printSeprator();
		
		TreeSet<Integer> tSet = new TreeSet<>();
		DataStructureImpl treeSet = new DataStructureImpl(tSet);
		calculatedTimeAndSpace = treeSet.calculateTimeAndSpace(INPUT2);
		services.printTimeAndSpace(calculatedTimeAndSpace, INPUT2, "Tree Set");
		calculatedTimeAndSpace =treeSet.calculateTimeAndSpaceForDelettion(INPUT2);
		services.printTimeAndSpaceForDeletion(calculatedTimeAndSpace, INPUT2, "tree set");
		
		services.printSeprator();
		
		HashMap<Integer, Integer> hMap = new HashMap<>();
		DataStructureImpl hashMap = new DataStructureImpl(hMap);
		calculatedTimeAndSpace = hashMap.calculateTimeAndSpace(INPUT2);
		services.printTimeAndSpace(calculatedTimeAndSpace, INPUT2, "Hash Set");
		calculatedTimeAndSpace = hashMap.calculateTimeAndSpaceForDelettion(INPUT2);
		services.printTimeAndSpaceForDeletion(calculatedTimeAndSpace, INPUT2, "hash Map");
		
		services.printSeprator();
		
		TreeMap<Integer, Integer> tMap = new TreeMap<>();
		DataStructureImpl treeMap = new DataStructureImpl(tMap);
		calculatedTimeAndSpace = treeMap.calculateTimeAndSpace(INPUT2);
		services.printTimeAndSpace(calculatedTimeAndSpace, INPUT2, "Tree Map");
		calculatedTimeAndSpace = treeMap.calculateTimeAndSpaceForDelettion(INPUT2);
		services.printTimeAndSpaceForDeletion(calculatedTimeAndSpace, INPUT2, "Tree Map");
		
	}

}
