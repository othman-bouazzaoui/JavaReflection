package com.oth;

import com.oth.models.ProfessorClass;

import java.lang.reflect.Method;

public class GetterSetterMethod {

	public static boolean isGetter(Method method) {

		//startWith get or is(boolean)
		if (!method.getName().startsWith("get") && !method.getName().startsWith("is")) {
			return false;
		}

		//no param
		if (method.getParameterTypes().length != 0) {
			return false;
		}

		if (void.class.equals(method)) {
			return false;
		}
		return true;

	}

	public static boolean isSetter(Method method) {

		//start with set
		if (!method.getName().startsWith("set")) {
			return false;
		}

		//one param
		if (method.getParameterTypes().length != 1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		Class<ProfessorClass> pClass = ProfessorClass.class;

		Method[] methods = pClass.getMethods();

		for (Method m : methods) {
			System.out.println(String.format("Methode Name %s isGetter (%b), isSetter (%b)", m.getName(), isGetter(m), isSetter(m)));
		}

	}

}
