package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Task;

/**
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final Client client = ClientBuilder.newClient();

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
		System.out.println("doGet ");

		WebTarget webTarget = client.target("http://localhost:8080/maven-webapp-101/rest/todo/list");
		Set<Task> L = webTarget.request(MediaType.APPLICATION_JSON).get(HashSet.class);

		HttpSession session = request.getSession();
		session.setAttribute("list", L);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost ");

		if ("add".equals(request.getParameter("action"))) {
			System.out.println("doPost /add");

			WebTarget webTarget = client.target("http://localhost:8080/maven-webapp-101/rest/todo/add");
			Task T = new Task();
			String param = request.getParameter("task");
			T.setName(param);
			webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(T, MediaType.APPLICATION_JSON));

		}

		if ("remove".equals(request.getParameter("action"))) {
			System.out.println("doPost /remove");

			WebTarget webTarget = client.target("http://localhost:8080/maven-webapp-101/rest/todo/remove");
			Task T = new Task();
			String param = request.getParameter("task");
			T.setName(param);
			webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(T, MediaType.APPLICATION_JSON));

		}

		doGet(request, response);

	}

}
