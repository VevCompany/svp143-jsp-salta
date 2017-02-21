package kz.salta.model;

public class Student {
	
	private Long id;
	private String name;
	private String group_name;
	private Byte age;
	
	public Student(Long id, String name, String group_name, Byte age){
		this.id=id;
		this.name = name;
		this.group_name = group_name;
		this.age=age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupName() {
		return group_name;
	}

	public void setGroupName(String group_name) {
		this.group_name = group_name;
	}

	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}
	
}
