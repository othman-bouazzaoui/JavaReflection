package com.oth;

import com.oth.models.ProfessorClass;

import java.lang.reflect.Field;

public class GetAttributDataFromClassObject {

	public static void main(String[] args) {

		try {
			
			Class<?> professorClass = Class.forName("com.oth.models.ProfessorClass");
		
			System.out.println("******************* Get All fields ******************");
			
			Field[] fields = professorClass.getFields();
			
			for(Field f : fields) {
				System.out.println("Field Name : " + f.getName());
			}
			
			System.out.println("******************* Get Attr By Name ******************");
			
			Field f = professorClass.getField("data");
			System.out.println("Field Name : " + f.getName());
			
			System.out.println("******************* Get Attr Type ******************");

			Class<?> attrType = f.getType();
			
			System.out.println("Type du Attribut : " + attrType.getSimpleName());
		
			System.out.println("******************* Set Value to Field ******************");

			ProfessorClass professorObject = new ProfessorClass();
			Field infoField = professorClass.getField("info");
			
			infoField.set(professorObject, "information ...");
			
			System.out.println("info : " + professorObject.getInfo());
			
			System.out.println("******************* Get Value Field ******************");

			String value = (String) infoField.get(professorObject);
			
			System.out.println("get info : " + value);
			
			System.out.println("******************* private Fields ******************");

			professorObject.setModule("new Tech");
			
			Field moduleField = professorClass.getDeclaredField("module");
			
			moduleField.setAccessible(true);
			
			value = (String) moduleField.get(professorObject);
			
			System.out.println("get module : " + value);

			
			
			
		} catch (Exception e) {

			System.out.println("Class Not Found");
		}

	}

}
