import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class RestAPI extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
	      // Get a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	      // Print an HTML page as the output of the query
	      out.println("<html>");
	      out.println("<head><title>Query Response</title></head>");
	      out.println("<body>");
	      File f = new File("C:\\Users\\TD\\MyBatis\\config.xml");
	        Reader reader = new FileReader(f);

	        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
	        EmployeeDao ed = new EmployeeDao(factory);
	        List<Employee> eL = ed.getAllEmployees();
	        Gson gson = new Gson();
	        String jsonInString = gson.toJson(eL);
	        reader.close();
	        out.println(jsonInString);
	   }
}


