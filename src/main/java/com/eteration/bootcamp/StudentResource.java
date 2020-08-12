package com.eteration.bootcamp;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @GET
    public Response getAll() {
        List<Student> all = Student.listAll();
        return Response.ok(all).build();
    }

    @POST
    @Transactional
    public Response save(Student student) {
        Student s = new Student();
        s.name = student.name;
        s.no = student.no;
        s.status = true;
        s.persist();
        return Response.ok(s).build();
    }


    @PUT
    @Path("{id}")
    @Transactional
    public Response save(Student student, @PathParam("id") Long id) {
        Student s = Student.findById(id);
        s.name = student.name;
        s.no = student.no;
        s.status = false;

        return Response.ok(s).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response save(@PathParam("id") Long id) {
        Student s = Student.findById(id);
        s.delete();

        return Response.ok(s).build();
    }
}