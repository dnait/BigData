package com.vehicletracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicletracker.dao.GetsSets;
import com.vehicletracker.dao.VehicleTrackerDao;

/**
 * Servlet implementation class AlarmSystemServlet
 */
@WebServlet("/tracker-mvc")
public class VehicleTrackerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleTrackerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Double lat_for_map = 0.0;
		Double long_for_map = 0.0;
		
		if (request.getParameter("veh_id") != null)
		{	
			VehicleTrackerDao vtd_formap = new VehicleTrackerDao(request.getParameter("veh_id"), request.getParameter("date_val"));
			Iterator<GetsSets> igs_formap = vtd_formap.getResultIterator();
			
			if(igs_formap.hasNext() == true)
			{
				while (igs_formap.hasNext()) {
					GetsSets location_formap = igs_formap.next();
					
					lat_for_map = location_formap.getLatitude();
					long_for_map = location_formap.getLongitude();
				}
			}
		}
		
		PrintWriter out = response.getWriter();
				
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\"><html>");
		out.println("<head>");
		out.println("<title>Track a Vehicle</title>");
		out.println("<meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\"/>");
		out.println("<script type=\"text/javascript\" src=\"http://maps.google.com/maps/api/js?sensor=false\"></script>");
		out.println("<script type=\"text/javascript\"> function initialize() { ");
		out.println("var latlng = new google.maps.LatLng(" + lat_for_map + ", " + long_for_map + "); ");
		out.println("var settings = { zoom: 10, center: latlng, mapTypeControl: true, mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU}, navigationControl: true, navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL}, mapTypeId: google.maps.MapTypeId.ROADMAP}; ");
		out.println("var map = new google.maps.Map(document.getElementById(\"map_canvas\"), settings); ");
		out.println("var companyPos = new google.maps.LatLng(" + lat_for_map + ", " + long_for_map + "); ");
		out.println("var companyMarker = new google.maps.Marker({ position: companyPos, map: map, title:\"Vehicle\" }); ");
			out.println("} </script>");
		out.println("</head>");
		out.println("<body onload=\"initialize()\">");
		out.println("<h1>Track a Vehicle</h1>");
		out.println("Enter the track date and id of the vehicle you want to track");	
		out.println("<p>&nbsp;</p>");
		out.println("<form id=\"form1\" name=\"form1\" method=\"get\" action=\"\">");
		out.println("<table>");
		out.println("<tr><td>Date (e.g. 2014-05-19):</td>");
		out.println("<td><input type=\"text\" name=\"date_val\" id=\"date_val\"/></td></tr>");
		out.println("<tr><td>Vehicle id (e.g. FLN78197):</td>");
		out.println("<td><input type=\"text\" name=\"veh_id\" id=\"veh_id\" /></td></tr>");
		out.println("<tr><td></td><td><input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Submit\"/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<p>&nbsp;</p>");
	
		if (request.getParameter("veh_id") != null)
		{	
			VehicleTrackerDao vtd = new VehicleTrackerDao(request.getParameter("veh_id"), request.getParameter("date_val"));
			Iterator<GetsSets> igs = vtd.getResultIterator();
			
			if(igs.hasNext() == true)
			{
				out.println("<hr/>");
				out.println("<table cellpadding=\"4\">");
				out.println("<tr><td colspan=\"3\"><h2>" + request.getParameter("veh_id") + "</h2></td></tr>");
				out.println("<tr><td><b>Date and Time</b></td><td><b>Latitude</b></td><td><b>Longitude</b></td></tr>");
				
				while (igs.hasNext()) {
					GetsSets location = igs.next();
					
					out.println("<tr>");
					out.println("<td>" + location.getTime() + "</td>");
					out.println("<td>" + location.getLatitude() + "</td>");
					out.println("<td>" + location.getLongitude() + "</td>");
					out.println("</tr>");
				}
				
				out.println("</table>");
				out.println("<div id=\"map_canvas\" style=\"width:500px; height:500px\"></div>");
			}
			else
			{
				out.println("<hr/>");
				out.println("<p>&nbsp;</p>");
				out.println("Sorry, no results for vehicle id " + request.getParameter("veh_id") + " for " + request.getParameter("date_val"));
			}			
		}

		out.println("</body></html>");		
	}

}
