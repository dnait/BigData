package com.alarmsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alarmsystem.dao.AlarmSystemDao;
import com.alarmsystem.dao.GetsSetsActivity;
import com.alarmsystem.dao.GetsSetsHome;

/**
 * Servlet implementation class AlarmSystemServlet
 */
@WebServlet("/status-mvc")
public class AlarmSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlarmSystemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\"><html>");
		out.println("<head><title>Alarm System Status</title></head>");
		out.println("<body style=\"font:14px verdana,arial,sans-serif\">");
		out.println("<h1>Alarm System Status</h1>");
		out.println("Enter your home id to see the most recent activity for the system");	
		out.println("<p>&nbsp;</p>");
		out.println("<form id=\"form1\" name=\"form1\" method=\"get\" action=\"\">");
		out.println("Home id: ");
		out.println("<input type=\"text\" name=\"h_id\" id=\"h_id\" />");
		out.println("<input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Submit\"/>");
		out.println("</form>");
		out.println("<p>&nbsp;</p>");
	
		if (request.getParameter("h_id") != null)
		{	
			AlarmSystemDao asd = new AlarmSystemDao(request.getParameter("h_id"));
			Iterator<GetsSetsActivity> igsa = asd.getResultIterator();
			Iterator<GetsSetsHome> igsh = asd.getResultIteratorHome();
			
			if(igsa.hasNext() == true)
			{
				while (igsh.hasNext())
				{
					GetsSetsHome home = igsh.next();
					out.println("<p>");
					out.println("<b>" + home.getContactName() + "</b>, ");
					out.println(home.getAddress() + ", " + home.getCity() + ", " + home.getState() + ", " + home.getZip()); 
					out.println("</p>");
				}
				
				out.println("<table style=\"font:14px verdana,arial,sans-serif\" cellpadding=\"4\">");
				
				while (igsa.hasNext()) {
					GetsSetsActivity activity = igsa.next();
					
					out.println("<tr>");
					out.println("<td>" + activity.getEvent() + "</td>");
					out.println("<td>" + activity.getDatetime() + "</td>");
					out.println("</tr>");
				}
				
				out.println("</table>");
			}
			else
			{
				out.println("<b>Sorry</b>, no results for home id " + request.getParameter("h_id"));
			}			
		}

		out.println("</body></html>");		
	}

}
