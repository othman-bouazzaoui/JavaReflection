package com.oth;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ScanPackage {
	
	
	public static void main(String[] args) {
		
		List<Class<?>> classes = find("com.oth.models");
		for(Class<?> cl : classes) {
			System.out.println("Class -> " + cl.getName());
		}
	}
	
	private static final char PCK_SEPARATOR = '.';
	
	private static final char DIR_SEPARATOR = '/';
	
	private static final String CLASS_FILE_SUFFIX = ".class";
	
	private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists ?";
	
	public static List<Class<?>> find(String scannedPackage){
		
		String scannedPath = scannedPackage.replace(PCK_SEPARATOR, DIR_SEPARATOR);
		
		URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
		
		if(scannedUrl == null) {
			throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
		}
		
		File scannedDir = new File(scannedUrl.getFile());
		List<Class<?>> classes = new ArrayList<>();
		
		if(scannedDir.listFiles() != null) {
			for(File file : scannedDir.listFiles()) {
			classes.addAll(find(file, scannedPackage));
			}
			
		}
		return classes;
	}

	private static List<Class<?>> find(File file, String scannedPackage) {
		
		List<Class<?>> classes = new ArrayList<>();
		String resource = scannedPackage+ PCK_SEPARATOR + file.getName();
		
		if(file.isDirectory()) {
			
			for(File f : file.listFiles()) {
			
				classes.addAll(find(f, resource));
			}
		}else if (resource.endsWith(CLASS_FILE_SUFFIX)){
			
			int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
			
			String className = resource.substring(0, endIndex);
			try {
				classes.add(Class.forName(className));
			}catch(ClassNotFoundException e) {
				System.out.println("Class Not found");
			}
			
		}
		return classes;
	}
	
	

}
