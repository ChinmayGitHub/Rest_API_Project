package storage;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;




import beans.StudentBean;
 

 
public class StudentDAO {
 
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
 
    public StudentBean getStudentDetails(int studentID) throws SQLException {
        String studentName = null;
        String studentAddress = null;
        String studentTelNo = null;
 
        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
        }
 
        String sqlStatement = "select * from studentsdetails where studentID = " + studentID + "";
        rs = statement.executeQuery(sqlStatement);
 
        StudentBean student = null;
        while (rs.next()) {
            student = new StudentBean();
            studentName = rs.getString("studentName");
            studentAddress = rs.getString("studentAddress");
            studentTelNo = rs.getString("studentTelNo");
 
            student.setStudentID(studentID);
            student.setStudentName(studentName);
            student.setStudentAddress(studentAddress);
            student.setStudentTelNo(studentTelNo);
        }
 
        statement.close();
        connection.close();
 
        return student;
    }
 
    public List<StudentBean> getStudents() throws SQLException {
        String studentName = null;
        String studentAddress = null;
        String studentTelNo = null;
        int studentID = 0;
 
        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
        }
 
        String sqlStatement = "Select * from studentsdetails";
        rs = statement.executeQuery(sqlStatement);
 
        List<StudentBean> students= new ArrayList<StudentBean>();
 
        while (rs.next()) {
            StudentBean student = new StudentBean();
 
            studentID = rs.getInt("studentID");
            studentName = rs.getString("studentName");
            studentAddress = rs.getString("studentAddress");
            studentTelNo = rs.getString("studentTelNo");
 
            student.setStudentID(studentID);
            student.setStudentName(studentName);
            student.setStudentAddress(studentAddress);
            student.setStudentTelNo(studentTelNo);
 
            students.add(student);
        }
 
        statement.close(); 
        connection.close();
 
        return students;
    }
    
	public boolean addStudent(String studentName1, String studentAddress1,String studentTelNo1) throws SQLException {
        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
        }
		String sql="insert into studentsdetails (`studentName`, `studentAddress`, `studentTelNo`) values ('"+studentName1+"','"+studentAddress1+"','"+studentTelNo1+"');";
		System.out.println(sql);
		if(1==statement.executeUpdate(sql))
		{
			return true;
		}
		else
		{
			return false;
		}
		// TODO Auto-generated method stub
		
	}
	
 
    private Connection getConnection() {
 
        String driverName = "com.mysql.jdbc.Driver";
        String conectionURI = "jdbc:mysql://localhost:3306/studentdb";
        String userName = "root";
        String password = "";
 
        try {
            Class.forName(driverName);
 
            try {
                connection = DriverManager.getConnection(conectionURI, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        return connection;
    }


}