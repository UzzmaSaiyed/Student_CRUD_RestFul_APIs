package com.student.java;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentService {
    private static final Map<Integer, String> students = new HashMap<>();
    
    @GET
    public Response getStudents() {
        return Response.ok(students).build();
    }

    @GET
    @Path("/{id}")
    public Response getStudent(@PathParam("id") int id) {
        if (!students.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
        }
        return Response.ok(Map.of(id, students.get(id))).build();
    }
    

    @POST
    public Response addStudent(Map<String, Object> studentData) {
        try {
            int id = (int) studentData.get("id");
            String name = (String) studentData.get("name");
            
            if (students.containsKey(id)) {
                return Response.status(Response.Status.CONFLICT).entity("Student already exists").build();
            }
            
            students.put(id, name);
            return Response.status(Response.Status.CREATED).entity(students).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid JSON format").build();
        }
    }
    
    @PUT
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") int id, Map<String, Object> studentData) {
        if (!students.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
        }
        try {
            String name = (String) studentData.get("name");
            students.put(id, name);
            return Response.ok(students).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid JSON format").build();
        }
    }
    

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") int id) {
        if (!students.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
        }
        students.remove(id);
        return Response.noContent().build();
    }
}
