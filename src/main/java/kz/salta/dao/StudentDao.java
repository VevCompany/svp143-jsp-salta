package kz.salta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kz.salta.model.Student;

public class StudentDao {
	private static ArrayList<Student> foundStudents;
	private static Connection conn=null;
	private static Statement stmt=null;
	private static ResultSet result=null;
	
	public static ArrayList<Student> findByName(String name){
		ArrayList<Student> students = new ArrayList<Student>();
		conn=DBConnection.getInstance().getDbConnection();
		
		try {
			stmt=conn.createStatement();
			String sql="SELECT id, name, group_name, age FROM student";
			result=stmt.executeQuery(sql);
			
			while(result.next()) {
				Long id=result.getLong("id");
				String studentName=result.getString("name");
				String groupName=result.getString("group_name");
				Byte age=result.getByte("age");
				System.out.println("Student: id "+id+", name "+studentName+", group "+groupName+", age "+age);
				students.add(new Student(id,studentName,groupName,age));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
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
