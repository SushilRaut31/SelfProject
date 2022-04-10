

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if((username != null && username.equals("sushil"))&& (password != null && password.equals("12345"))){
			 HttpSession session = request.getSession();
			 session.setAttribute("IsLoggedIn", true);
			 session.setAttribute("username", username);
			 response.sendRedirect("dashboard");
		}else {
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			out.print("Please Try Again !!");
			out.print("<form action='login' method='POST'> " + 
			"Username : <input type='text' name='username'>"+
			"Password : <input type='text' name='password'>"+
			"<button type='submit'>Login</button>"+
			"</form>");
			out.print("</body></html>");
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
