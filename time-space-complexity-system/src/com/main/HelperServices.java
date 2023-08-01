package com.main;

import java.util.List;

public class HelperServices {
	
	
	
	public void printTimeAndSpace(List<List<Long>> timeSpace, int inputSize, String dataStructure)
	{
		System.out.println("Time and space taken by \"" + dataStructure + "\" to insert \"" + inputSize + "\" elements are : ");
		Long timeTaken = timeSpace.get(0).get(1)-timeSpace.get(0).get(0);
		System.out.println("    time : "+timeTaken+" nano seconds.");
		//System.out.println(timeSpace+" time: "+timeTaken);
		
		Long spaceTaken = timeSpace.get(1).get(1) - timeSpace.get(1).get(0);
		if(spaceTaken<0) spaceTaken = -1*spaceTaken;
		System.out.println("    Space : "+spaceTaken+" bytes");
		return;
	}
	
	public void printTimeAndSpaceForDeletion(List<List<Long>> timeSpace, int inputSize, String dataStructure)
	{
		System.out.println("Time taken by \"" + dataStructure + "\" to remove \"" + inputSize + "\" elements are : ");
		Long timeTaken = timeSpace.get(0).get(1)-timeSpace.get(0).get(0);
		System.out.println("    time : "+timeTaken+" nano seconds.");
		//System.out.println(timeSpace+" time: "+timeTaken);
		
		Long spaceTaken = timeSpace.get(1).get(1) - timeSpace.get(1).get(0);
		if(spaceTaken<0) spaceTaken = -1*spaceTaken;
		System.out.println("    Space free : "+spaceTaken+" bytes");
		return;
	}

	public void printSeprator() {
		System.out.println("");
		System.out.println("------------------------------------------------------------");
		System.out.println("");
		
	}
	
}
