package resource;


import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import asset.Student;
import asset.StudentSet;
import beans.StudentBean;
import storage.StudentDAO;


@Path("/students")
public class StudentResource {

	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentSet getStudents() {
		System.out.println("Test 123");
		StudentDAO studentDao = new StudentDAO();
		List<StudentBean> students = null;

		try {
			students = studentDao.getStudents();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new StudentSet(students);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response addStudent(Student s) throws SQLException {
		
		ResponseBuilder response = null;
		StudentBean student = s.getStudent();
		StudentDAO studentDao = new StudentDAO();

		boolean stat=studentDao.addStudent(student.getStudentName(), student.getStudentAddress(), student.getStudentTelNo());

		if(stat==true)
		{
			response = Response.ok("CREATED");
			response.status(Status.CREATED);
		}
		else
		{
			response = Response.ok("Not Created");
			response.status(Status.NOT_MODIFIED);
		}

		return response.build();
		}

	@GET
	@Path("{studentid}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student getStudentName(@PathParam("studentid") int studentID) {
		StudentDAO studentDao = new StudentDAO();
		StudentBean student = null;
		try {
			student = studentDao.getStudentDetails(studentID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new Student(student);
	}
}