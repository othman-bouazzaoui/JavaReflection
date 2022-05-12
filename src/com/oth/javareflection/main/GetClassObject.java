package com.oth.javareflection.main;

import com.oth.javareflection.types.PersonClass;

public class GetClassObject {

	public static void main(String[] args) {
		
		//Méthode 1 : qui permet de récupèrer l'objet Class qui point sur la Class PersonClass.
		try {
			Class<?> personClass1 = Class.forName("com.oth.javareflection.types.PersonClass");

			System.out.println("Class Name : " + personClass1.getName());
			
		} catch (ClassNotFoundException e) {

			System.out.println("Class Not Found");
		}
		
		//Méthode 2 :
		PersonClass p = new PersonClass();
		
		Class<?> personClass2 = p.getClass();
		
		System.out.println("Class Name : " + personClass2.getName());
		
		
		//Méthode 3 : 
		Class<?> personClass3 = PersonClass.class;
		
		System.out.println("Class Name : " + personClass3.getName());
		
	}

}
