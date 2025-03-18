//package com.student.java;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.Context;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//@Path("/students")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class StudentService {
//    private static final Map<Integer, String> students = new HashMap<>();
//    
//    @GET
//    public Response getStudents() {
//        return Response.ok(students).build();
//    }
//
//    @GET
//    @Path("/{id}")
//    public Response getStudent(@PathParam("id") int id) {
//        if (!students.containsKey(id)) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
//        }
//        return Response.ok(Map.of(id, students.get(id))).build();
//    }
//
//    @POST
//    public Response addStudent(@QueryParam("id") int id, @QueryParam("name") String name) {
//        if (students.containsKey(id)) {
//            return Response.status(Response.Status.CONFLICT).entity("Student already exists").build();
//        }
//        students.put(id, name);
//        return Response.status(Response.Status.CREATED).entity(students).build();
//    }
//    
//    @PUT
//    @Path("/{id}")
//    public Response updateStudent(@PathParam("id") int id, @QueryParam("name") String name) {
//        if (!students.containsKey(id)) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
//        }
//        students.put(id, name);
//        return Response.ok(students).build();
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response deleteStudent(@PathParam("id") int id) {
//        if (!students.containsKey(id)) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
//        }
//        students.remove(id);
//        return Response.noContent().build();
//    }
//    
//
//}

package com.student.java;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

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


//package com.student.java;
//
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import java.util.HashMap;
//import java.util.Map;
//
//@Path("/students")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class StudentService {
//    private static final Map<Integer, Student> students = new HashMap<>();
//
//    @GET
//    public Response getStudents() {
//        return Response.ok(students.values()).build();
//    }
//
//    @GET
//    @Path("/{id}")
//    public Response getStudent(@PathParam("id") int id) {
//        if (!students.containsKey(id)) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
//        }
//        return Response.ok(students.get(id)).build();
//    }
//
//    @POST
//    public Response addStudent(Student student) {
//        int id = student.getId();
//        if (students.containsKey(id)) {
//            return Response.status(Response.Status.CONFLICT).entity("Student already exists").build();
//        }
//        students.put(id, student);
//        return Response.status(Response.Status.CREATED).entity(student).build();
//    }
//
//    @PUT
//    @Path("/{id}")
//    public Response updateStudent(@PathParam("id") int id, Student student) {
//        if (!students.containsKey(id)) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
//        }
//        students.put(id, student);
//        return Response.ok(student).build();
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response deleteStudent(@PathParam("id") int id) {
//        if (!students.containsKey(id)) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
//        }
//        students.remove(id);
//        return Response.noContent().build();
//    }
//}