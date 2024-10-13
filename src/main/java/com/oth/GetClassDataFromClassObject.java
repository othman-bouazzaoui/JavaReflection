package com.oth;

import java.lang.reflect.Modifier;

public class GetClassDataFromClassObject {

	public static void main(String[] args) {
		
		try {
			
			Class<?> professorClass = Class.forName("com.oth.models.ProfessorClass");
			
			System.out.println("***************************  Class Infos *****************************");
		
			System.out.println("Class Name : " + professorClass.getName());
			System.out.println("Class Simple Name : " + professorClass.getSimpleName());
			
			System.out.println("************************** package ***********************************");
			
			Package pack = professorClass.getPackage();
			
			System.out.println("Package : " + pack.getName());
			
			System.out.println("************************** Modifier ***********************************");

			int professorModifier = professorClass.getModifiers();
			
			System.out.println("isPublic : " + Modifier.isPublic(professorModifier));
			System.out.println("isInterface : " + Modifier.isInterface(professorModifier));
			System.out.println("isAbstract : " + Modifier.isAbstract(professorModifier));
			System.out.println("isFinal : " + Modifier.isFinal(professorModifier));
			
			System.out.println("************************** Super Class ***********************************");

			Class<?> professorSuperClass = professorClass.getSuperclass();
			
			System.out.println("Simple Name of Super Class"+professorSuperClass.getSimpleName());
			
			System.out.println("************************** Implemented Interfaces ***********************************");

			Class<?>[] professorInterfaces = professorClass.getInterfaces();
			/*
			for(int i=0; i<professorInterfaces.length;i++) {
				System.out.println("Interface Name : " + professorInterfaces[i].getSimpleName());
			}
			*/
			for(Class<?> c : professorInterfaces ) {
				System.out.println("Interface Name : " + c.getSimpleName());
			}
			
		} catch (ClassNotFoundException e) {

			System.out.println("Class Not Fount");
		}

	}

}
