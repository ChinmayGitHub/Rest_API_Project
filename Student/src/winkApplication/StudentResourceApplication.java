package winkApplication;


import javax.ws.rs.core.Application;
import resource.StudentResource;
import java.util.HashSet;
import java.util.Set;

public class StudentResourceApplication extends Application {
	 
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(StudentResource.class);
 
        return classes;
    }
}