package com.rgt.user.mgmt.service;

import java.io.File;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class UserHelper {
	
	private int id=0;
	
	//return unique id;
	public int uniqueId()
	{
		 this.setId();
		 return ++id;
	}
	
	public void setId()
	{
		File[] listOfFiles = listOfFiles();
		for(File file : listOfFiles)
		{
			String fileName = file.getName();
			int end_idx = fileName.indexOf('.');
			int idx = Integer.parseInt(fileName.substring(4, end_idx));
			this.id = this.id<idx?idx:this.id;
		}
	}
	
	public File[] listOfFiles()
	{
		String path = "data\\users";
		File fObj = new File(path);
		File[] listOfFiles = null;
		if(fObj.exists() && fObj.isDirectory()) {
			listOfFiles = fObj.listFiles();
		}
		return listOfFiles;
	}
}
