package com.oth;

import com.oth.models.ProfessorClass;

import java.lang.reflect.Method;

public class GetMethodeDataFromClassObject {

	public static void main(String[] args) {
		
		try {
			
			Class<?> professorClass = Class.forName("com.oth.models.ProfessorClass");
			
			System.out.println("******************* Get All Methodes ******************");

			Method[] methods = professorClass.getMethods();
			
			for(Method m : methods) {
				System.out.println("Method Name : " + m.getName());
			}
			
			System.out.println("******************* Get Methode by Name ******************");

			Method getInfoMethode = professorClass.getMethod("getInfo");
			
			System.out.println("Method Name : " + getInfoMethode.getName());
			
			
			System.out.println("******************* Get Methode by Name With param******************");
			
			Method setInfoMethode = professorClass.getMethod("setInfo",String.class);
			
			System.out.println("Method Name With param : " + setInfoMethode.getName());
			
			
			
			System.out.println("******************* Get Methode return Type******************");
			
			Class<?> returnType = getInfoMethode.getReturnType();
			
			System.out.println("returnType Name : " + returnType.getName());
			System.out.println("returnType SimpleName : " + returnType.getSimpleName());
			
			System.out.println("******************* appel Method 1******************");

			ProfessorClass professorObject = new ProfessorClass();
			
			setInfoMethode.invoke(professorObject, "new info by java reflection");
			
			System.out.println("******************* appel Method 2******************");

			String value = (String) getInfoMethode.invoke(professorObject);
			
			System.out.println(value);
			
			System.out.println("******************* private Method ******************");

			Method privateMethod = professorClass.getDeclaredMethod("helloFromPrivate", String.class);
			privateMethod.setAccessible(true);
			
			privateMethod.invoke(new ProfessorClass(), "Othman");
			
			
		} catch (Exception e) {

		}
		
		
		
	}

}
