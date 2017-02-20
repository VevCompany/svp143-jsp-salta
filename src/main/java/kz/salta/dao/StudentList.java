package kz.salta.dao;

import java.util.ArrayList;

import kz.salta.model.Student;

public class StudentList {
	
public static ArrayList<Student> getStudents(){
		
		ArrayList<Student> list = new ArrayList<Student>();
		Student s = null;
		for(int i = 0; i < 10; i++){
//			s = new Student("Name"+i, "Group_"+i);
			list.add(s);
		}
		
		return list;
		
	}

}
