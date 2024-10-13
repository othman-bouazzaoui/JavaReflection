package com.oth;

import com.oth.models.PersonClass;

public class GetClassObject {

	public static void main(String[] args) {
		
		//M�thode 1 : qui permet de r�cup�rer l'objet Class qui point sur la Class PersonClass.
		try {
			Class<?> personClass1 = Class.forName("com.oth.models.ProfessorClass");

			System.out.println("Class Name : " + personClass1.getName());
			
		} catch (ClassNotFoundException e) {

			System.out.println("Class Not Found");
		}
		
		//M�thode 2 :
		PersonClass p = new PersonClass();
		
		Class<?> personClass2 = p.getClass();
		
		System.out.println("Class Name : " + personClass2.getName());
		
		
		//M�thode 3 : 
		Class<?> personClass3 = PersonClass.class;
		
		System.out.println("Class Name : " + personClass3.getName());
		
	}

}
