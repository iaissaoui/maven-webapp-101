package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Task;

/**
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();

		if (session.getAttribute("list") == null) {
			System.out.println("new access");
			ArrayList<Task> L = new ArrayList();
//			Task T = new Task();
//			T.setName("Num 1");
//			L.add(T);
			session.setAttribute("list", L);
		} else {
			System.out.println("repeat access");

		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String param = request.getParameter("task");
		System.out.println(param);

		// jersey client maintains the httpsession

		// doGet(request, response);

	}

}
