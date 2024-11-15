/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.controller.dao.services.PersonaServices;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *
 * @author Grupo6
 */
@Path("/persona")
public class PersonaApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllPersonas() throws Exception {
        PersonaServices ps = new PersonaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            responseMap.put("status","OK");
            responseMap.put("data",ps.getAllPersonas());
            return Response.ok(om.writeValueAsString(responseMap)).build();
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("status","ERROR");
            responseMap.put("data",e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                            .entity(om.writeValueAsString(responseMap)).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/save")
    public Response savePersona(String personaJson) throws Exception {
        PersonaServices ps = new PersonaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            ps.personaFromJson(personaJson);
            ps.save();
            responseMap.put("status","OK");
            responseMap.put("data",ps.getPersona());
            return Response.ok(om.writeValueAsString(responseMap)).build();
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("status","ERROR");
            responseMap.put("data",e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                            .entity(om.writeValueAsString(responseMap)).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deletePersona(@PathParam("id") Integer id) throws Exception {
        PersonaServices ps = new PersonaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            responseMap.put("status","OK");
            responseMap.put("data",ps.getPersonaById(id));
            ps.deletePersona(id);
            return Response.ok(om.writeValueAsString(responseMap)).build();
        } catch (Exception e) {
            e.printStackTrace();
            
            responseMap.put("status","ERROR");
            responseMap.put("data",e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                            .entity(om.writeValueAsString(responseMap)).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{id}")
    public Response getPersonaById(@PathParam("id") Integer id) throws Exception {
        PersonaServices ps = new PersonaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            responseMap.put("status","OK");
            responseMap.put("data",ps.getPersonaById(id));
            return Response.ok(om.writeValueAsString(responseMap)).build();
        } catch (Exception e) {
            responseMap.put("status","ERROR");
            responseMap.put("data",e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                            .entity(om.writeValueAsString(responseMap)).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/")
    public Response getAllPersonas(String personaJson) throws Exception {
        PersonaServices ps = new PersonaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            ps.personaFromJson(personaJson);
            ps.update();
            responseMap.put("status","OK");
            responseMap.put("data",ps.getPersona());
            return Response.ok(om.writeValueAsString(responseMap)).build();
        } catch (Exception e) {
            responseMap.put("status","ERROR");
            responseMap.put("data",e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                            .entity(om.writeValueAsString(responseMap)).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/enumerations")
    public Response enumerations() throws Exception {
        PersonaServices ps = new PersonaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        HashMap<String,Object> enumerations = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            enumerations.put("tiposIdentificacion", ps.tiposIdentificacion());
            enumerations.put("roles",ps.roles());
            enumerations.put("generos", ps.generos());

            responseMap.put("status", "OK");
            responseMap.put("data",enumerations);

            return Response.ok(om.writeValueAsString(responseMap)).build();
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("status", "ERROR");
            responseMap.put("data", e.getMessage());

            return Response.status(Status.INTERNAL_SERVER_ERROR)
            .entity(responseMap).build();
        }
    }

}
