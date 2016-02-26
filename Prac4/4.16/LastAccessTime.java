import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.ServletConfig;
import java.text.DateFormat;

public class LastAccessTime extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	
	HttpSession session = req.getSession();
	Date CreationTime = new Date(session.getCreationTime());
	Date LastAccess = new Date(session.getLastAccessedTime());
	Date now = new Date();
	DateFormat foreatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
	out.println("<html><head><title>Session Last aceess time</title></head>");
	out.println("<body>");
	out.println("<h3>Enroll No:140053131020</h3>");
	out.println("<h2>Session Creation and Last aceess time:</h2>");
	out.println("Time and date is:"+foreatter.format(now)+"<br><br>");
	out.println("The session creation time is: "+foreatter.format(CreationTime)+"");
	out.println("The session Last Access time is: "+foreatter.format(LastAccess)+"");
	out.println("</body></html>");
	
	
	}
}