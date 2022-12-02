import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;

public class SendOneEmployee extends HttpServlet {
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
	        Employee e = ed.getEmployeeById(113);
	        Gson gson = new Gson();
	        String jsonInString = gson.toJson(e);
	        reader.close();
	        out.println(jsonInString);
	   }
}
