package AllServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import allUtilities.TechTalksDetails;

/**
 * Servlet implementation class getAllTechTalks
 */
public class getAllTechTalks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getAllTechTalks() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TechTalksDetails techtalks=new TechTalksDetails();
		techtalks.getAllTechTalks();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
