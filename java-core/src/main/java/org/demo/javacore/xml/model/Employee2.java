package org.demo.javacore.xml.model;

public class Employee2 {
	private String name;
    private String gender;
    private int age;
    private String role;
    private int id;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
	@Override
    public String toString() {
        return "Employee:: Name=" + this.name + " Age=" + this.age + " Gender=" + this.gender +
                " Role=" + this.role;
    }
}
