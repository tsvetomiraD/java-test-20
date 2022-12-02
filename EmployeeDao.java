import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmployeeDao {

	public EmployeeDao() {
		// TODO Auto-generated constructor stub
	}
	SqlSessionFactory factory;

    public EmployeeDao(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public Employee getEmployeeById(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("getEmployeeById", id);
        }
    }

    public List<Employee> getEmployeesByJob(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("getEmployeesByJob", id);
        }
    }

    public List<Employee> getAllEmployees() {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("getAllEmployees");
        }
    }

    public int addEmployee(Employee e) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("addEmployee", e);
        }
    }

    public boolean updateEmployee(Employee e) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("updateEmployee", e);
        }
    }

    public boolean deleteEmployee(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("deleteEmployee", id);
        }
    }

}
