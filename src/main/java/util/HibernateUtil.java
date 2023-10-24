package util;

	import java.util.Properties;

	import org.hibernate.SessionFactory;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.cfg.Environment;
	import org.hibernate.service.ServiceRegistry;

	import com.bean.Student;
	import com.bean.Class;
	import com.bean.Subject;
	import com.bean.Teacher;
	import com.bean.Admin;
	import com.bean.SubTeachClass;

	public class HibernateUtil {
	    private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();

	                // Hibernate settings equivalent to hirbanate.cfg.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernateProject?useSSL=false");
	                settings.put(Environment.USER, "root");
	                settings.put(Environment.PASS, "root");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

	                settings.put(Environment.SHOW_SQL, "true");

	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	                settings.put(Environment.HBM2DDL_AUTO, "update");

	                configuration.setProperties(settings);
	                configuration.addAnnotatedClass(Student.class);
	                configuration.addAnnotatedClass(Class.class);
	                configuration.addAnnotatedClass(Subject.class);
	                configuration.addAnnotatedClass(Teacher.class);
	                configuration.addAnnotatedClass(Admin.class);
	                configuration.addAnnotatedClass(SubTeachClass.class);

	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                        .applySettings(configuration.getProperties()).build();
	                System.out.println("Hibernate Java Config serviceRegistry created");
	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	                return sessionFactory;
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }
	}






