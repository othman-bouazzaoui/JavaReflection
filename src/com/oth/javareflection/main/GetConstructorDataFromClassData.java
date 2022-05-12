package com.oth.javareflection.main;

import java.lang.reflect.Constructor;

import com.oth.javareflection.types.ProfessorClass;

public class GetConstructorDataFromClassData {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		try {
			
			Class<?> professorClass = Class.forName("com.oth.javareflection.types.ProfessorClass");

			System.out.println("************* Etape 1 : Get All Constructors *****************************");
			
			Constructor<?>[] constructors = professorClass.getConstructors();
			
			for(Constructor<?> c : constructors) {
				
				System.out.println("Constructor : " + c.getName());
				
				Class<?>[] paramClass = c.getParameterTypes();
				
				for(Class<?> param: paramClass) {
					System.out.println(" 		param 		: " + param.getSimpleName());
				}
				
			}
			
			System.out.println("************* Etape 2 : Get Constructor by param *****************************");
			
			System.out.println("************* Exemple 1 *****************************");

			Constructor<?> constructorParam = professorClass.getConstructor(ProfessorClass.class);

			Class<?>[] paramConst = constructorParam.getParameterTypes();
			
			for(Class<?> param: paramConst) {
				System.out.println(" 		param 		: " + param.getSimpleName());
			}
			
			System.out.println("************* Exemple 2 *****************************");

			Constructor<?> constructorParam1 = professorClass.getConstructor(Long.class, String.class, String.class, int.class, double.class, String.class);

			Class<?>[] paramConst1 = constructorParam1.getParameterTypes();
			
			for(Class<?> param: paramConst1) {
				System.out.println(" 		param 		: " + param.getSimpleName());
			}
			
			

		} catch (ClassNotFoundException e) {

			System.out.println("Class Not Found");
		}

	}

}
