package asset;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import beans.StudentBean;

@XmlRootElement
public class StudentSet {

	private List<StudentBean> ls = null;

	/**default constructor*/
	public StudentSet() {
		ls = new LinkedList<StudentBean>();
	}

	public StudentSet(Collection<StudentBean> data) {
		this();
		ls.addAll(data);
	}

	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@XmlElement
	public List<StudentBean> getStudentSet() {
		return ls;
	}
}
