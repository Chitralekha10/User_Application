package Controller;

import jakarta.servlet.Registration;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class Delete extends HttpServlet {
	protected void processRequest(HttpServletRequest req,HttpServletResponse resp){
		try {
		HttpSession session=req.getSession();
		Model.Registration reg=new Model.Registration(session);
		int id=Integer.parseInt(req.getParameter("userid"));
		System.out.println(id+"-------id is ididi jdkj");
		String status=reg.delete(id);
		if(status.equals("success")) {
		req.setAttribute("status", "Account Deleted Sucessfully");
		RequestDispatcher re=req.getRequestDispatcher("DeleteUser.jsp");
		re.forward(req, resp);
		}else {
		req.setAttribute("status", "Failure Occured");
		RequestDispatcher re=req.getRequestDispatcher("DeleteUser.jsp");
		re.forward(req, resp);
		}
		}catch(Exception e) {
		e.printStackTrace();
		}
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
