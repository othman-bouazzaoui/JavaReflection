package com.oth.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProfessorClass extends PersonClass implements ProfessorInterface, Serializable {

	private double salary;
	private String module;
	public String info = "info";

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public ProfessorClass(Long id, String firstName, String lastName, int age, double salary, String module) {
		this.salary = salary;
		this.module = module;
	}

	public ProfessorClass(double salary, String module) {
		this.salary = salary;
		this.module = module;
	}

	public ProfessorClass(Long id, String firstName, String lastName, int age, double salary) {
		super(id, firstName, lastName, age);
	}

	public ProfessorClass(ProfessorClass c) {
	}

	public ProfessorClass(String firstName) {
		super(firstName);
	}

	public ProfessorClass() {

	}
	
	@SuppressWarnings("unused")
	private void helloFromPrivate(String v) {
		System.out.println("hello : " + v);
	}

}
