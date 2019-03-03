package services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/todo")
public class Todo {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Invoke with JSON!";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "Hello Jersey" + "</body></h1>"
				+ "</html> ";
	}

//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public ArrayList<Task> getTodos() {
//
//		return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "Hello Jersey" + "</body></h1>"
//				+ "</html> ";
//	}
//
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public void addTask() {
//
//	}
//
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public void addTask() {
//
//	}

}