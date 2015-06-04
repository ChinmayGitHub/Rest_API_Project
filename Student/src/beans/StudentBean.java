package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Student")
public class StudentBean {

 private int studentID;
 private String studentName;
 private String studentAddress;
 private String studentTelNo;

 public StudentBean() {}

 public StudentBean(int id, String name, String address, String telno) {
   this.studentID = id;
   this.studentName = name;
   this.studentAddress = address;
   this.studentTelNo = telno;
 }

public int getStudentID() {
	return studentID;
}

public void setStudentID(int studentID) {
	this.studentID = studentID;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}

public String getStudentAddress() {
	return studentAddress;
}

public void setStudentAddress(String studentAddress) {
	this.studentAddress = studentAddress;
}

public String getStudentTelNo() {
	return studentTelNo;
}

public void setStudentTelNo(String studentTelNo) {
	this.studentTelNo = studentTelNo;
}

 
}
