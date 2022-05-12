package com.oth.javareflection.types;


@PersonAnnotation(name = "Class Person", value = "Class Person value")
public class PersonClass {

	private Long id;

    @PersonAnnotation(name = "firstName Attribut", value = "firstName value")
	public String firstName;
	private String lastName;
	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@PersonAnnotation(name = "firstName Method", value = "firstName Method value")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(@PersonAnnotation(name = "firstName param", value = "firstName param") String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PersonClass(Long id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public PersonClass() {

	}
	
	public PersonClass(String firstName) {
		this.firstName = firstName;
	}
	
}
