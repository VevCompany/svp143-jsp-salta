package kz.salta.dao;

import java.util.ArrayList;

import kz.salta.model.Student;

public class StudentDao {
	private static ArrayList<Student> foundStudents;
	
	public static ArrayList<Student> findByName(String name){
		ArrayList<Student> students = StudentList.getStudents();
		if(name.isEmpty()) {
			return students;
		}
		foundStudents=new ArrayList<Student>();
		for (Student student : students) {
			if(student.getName().equals(name)) {
				foundStudents.add(student);
			}
		}
		return foundStudents;
	}
}
