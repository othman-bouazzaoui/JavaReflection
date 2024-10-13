package com.oth;



import com.oth.models.PersonAnnotation;
import com.oth.models.PersonClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetAnnotationValue {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {

		Class<?> personClass= PersonClass.class;
		
		System.out.println("************ get All annotation ************");
		
		Annotation[] annotations = personClass.getAnnotations();
		
		for(Annotation a : annotations) {
			
			System.out.println("Annotation :" + a.annotationType().getSimpleName());
		
			PersonAnnotation personAnnotation  = (PersonAnnotation) a;
			
			System.out.println(personAnnotation.name() +" - " + personAnnotation.value());
		}
		
		System.out.println("************ get annotation by Name ************");

		Annotation annotation = personClass.getAnnotation(PersonAnnotation.class);
		
		PersonAnnotation personAnnotation = (PersonAnnotation) annotation;
		
		System.out.println(personAnnotation.name() +" - " + personAnnotation.value());
		
		System.out.println("************ get Attribut annotation ************");

		Field field = personClass.getField("firstName");
		
		Annotation[] fieldAnnotation = field.getAnnotations();
		
		for(Annotation a : fieldAnnotation) {
			
			System.out.println("Field Name : " + field.getName());
			System.out.println("Annotation field : " + a.annotationType().getSimpleName());
			
			PersonAnnotation personAnnotationField = (PersonAnnotation) a;
			
			System.out.println(personAnnotationField.name() + " - " + personAnnotationField.value());
			
		}
		
		System.out.println("************ get Method annotation ************");

		Method method = personClass.getMethod("getFirstName");
		
		Annotation[] methodAnnotations  = method.getAnnotations();
		
		for(Annotation a : methodAnnotations) {
			
			System.out.println("Method Name : " + method.getName());
			
			PersonAnnotation personAnnotationMethod = (PersonAnnotation) a;
			
			System.out.println(personAnnotationMethod.name() +" - " + personAnnotationMethod.value());
		}
		
		System.out.println("************ get Method annotation by Name ************");

		Annotation annotationByNAme = method.getAnnotation(PersonAnnotation.class);
		
		PersonAnnotation personAnnotationMethod = (PersonAnnotation)annotationByNAme;
		
		System.out.println(personAnnotationMethod.name() + " - " + personAnnotationMethod.value() );
		
		System.out.println("************ get param annotation  ************");

		
		Method m2 = personClass.getMethod("setFirstName", String.class);
		
		Class<?>[] parameterTypes = m2.getParameterTypes();
		
		for(Class<?> paramType : parameterTypes) {
			
			System.out.println("parametre Type : " + paramType.getSimpleName());
			
			for(Annotation a : paramType.getAnnotations()) {
				
				PersonAnnotation persAnnotation = (PersonAnnotation) a;
				
				System.out.println(persAnnotation.name() + " - " + persAnnotation.value());
			}
			
		}
		
		System.out.println("***********************************************");
		
		Annotation[][] ann1 = m2.getParameterAnnotations();
		
		Annotation[] ann2 = ann1[0];
		
		for(Annotation a : ann2) {
			
			PersonAnnotation persAnnotation = (PersonAnnotation) a;
			
			System.out.println(persAnnotation.name() + " - " + persAnnotation.value());
		}
 		
	}

}
