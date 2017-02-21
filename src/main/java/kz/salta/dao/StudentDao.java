package kz.salta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kz.salta.model.Student;

public class StudentDao {
	private static ArrayList<Student> foundStudents;
	private static Connection conn=null;
	private static Statement stmt=null;
	private static PreparedStatement preparedStmt = null;
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
	
	public static Student getStudentById(Long studentId) {
		Student student=null;
		conn=DBConnection.getInstance().getDbConnection();
		
		try {
			stmt=conn.createStatement();
			preparedStmt = conn.prepareStatement("SELECT id, name, group_name, age FROM student WHERE id=?");
			preparedStmt.setLong(1, studentId);
			result = preparedStmt.executeQuery();
			
			while(result.next()) {
				Long id=result.getLong("id");
				String studentName=result.getString("name");
				String groupName=result.getString("group_name");
				Byte age=result.getByte("age");
				System.out.println("Student: id "+id+", name "+studentName+", group "+groupName+", age "+age);
				student=new Student(id,studentName,groupName,age);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return student;
	}
	
	public static void createStudent(Student student) {
		conn=DBConnection.getInstance().getDbConnection();
		
		try {
			preparedStmt = conn.prepareStatement("INSERT INTO student(id, name, group_name, age) values(?,?,?,?)");
			preparedStmt.setLong(1, student.getId());
			preparedStmt.setString(2, student.getName());
			preparedStmt.setString(3, student.getGroupName());
			preparedStmt.setByte(4, student.getAge());
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void updateStudent(Student student) {
		conn=DBConnection.getInstance().getDbConnection();
		
		try {
			preparedStmt = conn.prepareStatement("UPDATE student set name=?, group_name='test22', age=55 WHERE id=4");
			
			preparedStmt.setString(1, student.getName());
			//preparedStmt.setString(2, student.getGroupName());
			//preparedStmt.setByte(3, student.getAge());
//			preparedStmt.setLong(4, student.getId());
			preparedStmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
