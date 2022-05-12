package com.oth.javareflection.main;

import java.lang.reflect.Constructor;

import com.oth.javareflection.types.ProfessorClass;

public class InitializeObject {

	public static void main(String[] args) {

		try {

			System.out.println("****** Intanciation statique ***");
			ProfessorClass p = new ProfessorClass(10000d, "New Tech");
			System.out.println("Salary : " + p.getSalary());
			System.out.println("Module : " + p.getModule());

			System.out.println("****** Intanciation dynamique ex 1 ***");

			Class<?> professorClass = Class.forName("com.oth.javareflection.types.ProfessorClass");
			// Class<?> professorClass = ProfessorClass.class;

			
			//Java <= 8 
			//ProfessorClass pRef = (ProfessorClass) professorClass.newInstance();
			
			//Java >= 9
			ProfessorClass pRef = (ProfessorClass) professorClass.getDeclaredConstructor().newInstance();

			pRef.setFirstName("Othman");

			System.out.println("FirstName : " + pRef.getFirstName());
			
			System.out.println("****** Intanciation dynamique ex 2 ***");
			
			Constructor<?> cons = professorClass.getConstructor(String.class);
			
			ProfessorClass pRef1 = (ProfessorClass) cons.newInstance("Othman");
			
			System.out.println("FirstName : " + pRef1.getFirstName());


		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

}
