package services.rest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Task;

@Path("/todo")
public class Todo {

	private static Set<Task> tasks = new HashSet<Task>();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList() {
		System.out.println("returning list " + tasks);
		GenericEntity<Set<Task>> entity;
		entity = new GenericEntity<Set<Task>>(tasks) {
		};

		return Response.ok(entity).build();

	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTask(Task t) {
		System.out.println("adding " + t.getName());
		tasks.add(t);

	}

	@POST
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeTask(Task t) {
		System.out.println("deleting " + t.getName());

		Set<Task> set = new HashSet();

		for (Task tt : tasks) {
			if (!tt.getName().equals(t.getName())) {
				set.add(tt);
			}
		}

		tasks = set;

	}

}