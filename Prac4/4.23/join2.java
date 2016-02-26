import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class join2 extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws IOException, ServletException
{
res.setContentType("text/html");
PrintWriter pw = res.getWriter();
Connection con;
PreparedStatement ps;
ResultSet rs;
try
{
Class.forName("org.postgresql.Driver");
con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/s2b140053131020","postgres","sudhir7");
ps = con.prepareStatement("SELECT * FROM student NATURAL JOIN bank");
rs = ps.executeQuery();
pw.println("Enroll No : 140053131020");
pw.println("<table border=1><tr>");
pw.println("<td>stu_rollno</td>");
pw.println("<td>stu_Name</td>");
pw.println("<td>stu_branch</td>");
pw.println("<td>account_no</td>");
pw.println("<td>balance</td>");
pw.println("</tr>");
pw.println("</table>");
while(rs.next())
{
Integer stu_rollno = rs.getInt("id");
String stu_Name = rs.getString("name");
String stu_branch = rs.getString("branch");
Integer acc_no = rs.getInt("account_no");
Integer balance = rs.getInt("balance");
pw.println("<table border=1><tr>");
pw.println("<td>"+stu_rollno+"</td>");
pw.println("<td>"+stu_Name+"</td>");
pw.println("<td>"+stu_branch+"</td>");
pw.println("<td>"+acc_no+"</td>");
pw.println("<td >"+balance+"</td>");
pw.println("</tr>");
pw.println("</table>");
}
try
{
con.close();
ps.close();
}
catch(Exception e)
{
pw.println(e);
}
}
catch(SQLException sx)
{
pw.println(sx);
}
catch(ClassNotFoundException cx)
{
pw.println(cx);
}
}
}