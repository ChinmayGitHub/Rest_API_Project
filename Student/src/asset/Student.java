package asset;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.wink.common.annotations.Asset;

import beans.StudentBean;

@Asset
public class Student {
	private StudentBean s = null;
	
	public  Student() {this( null ); }
	
	public Student(StudentBean s)
	{ this.s = s; }

	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public StudentBean getStudent()
	{ return s; }

	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void setStudent(StudentBean s) 
	{ this.s = s; }

}
