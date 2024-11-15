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

import com.example.controller.dao.services.CuentaServices;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *
 * @author Grupo6
 */
@Path("/cuenta")
public class CuentaApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllCuentas() throws Exception {
        CuentaServices cs = new CuentaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            responseMap.put("status","OK");
            responseMap.put("data",cs.getAllCuentas());
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
    public Response saveCuenta(String cuentaJson) throws Exception {
        CuentaServices cs = new CuentaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            cs.CuentaFromJson(cuentaJson);
            cs.save();
            responseMap.put("status","OK");
            responseMap.put("data",cs.getCuenta());
            return Response.ok(om.writeValueAsString(responseMap)).build();
        } catch (Exception e) {
            e.printStackTrace();   
            responseMap.put("status","ERROR");
            responseMap.put("data",e.getMessage());
            // Si no encontró la persona por su id devuevle un bad_request
            if(e.getMessage().equals("PersonaNotFound")) 
                return Response.status(Status.BAD_REQUEST)
                                .entity(om.writeValueAsString(responseMap)).build();
            // Error del Servidor sino
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                            .entity(om.writeValueAsString(responseMap)).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteCuenta(@PathParam("id") Integer id) throws Exception {
        CuentaServices cs = new CuentaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            responseMap.put("status","OK");
            responseMap.put("data",cs.getCuentaById(id));
            cs.deleteCuenta(id);
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
    public Response getCuentaById(@PathParam("id") Integer id) throws Exception {
        CuentaServices cs = new CuentaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            responseMap.put("status","OK");
            responseMap.put("data",cs.getCuentaById(id));
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
    public Response getAllCuentas(String cuentaJson) throws Exception {
        CuentaServices cs = new CuentaServices(0);
        HashMap<String,Object> responseMap = new HashMap<>();
        ObjectMapper om = new ObjectMapper();

        try {
            cs.CuentaFromJson(cuentaJson);
            cs.update();
            responseMap.put("status","OK");
            responseMap.put("data",cs.getCuenta());
            return Response.ok(om.writeValueAsString(responseMap)).build();
        } catch (Exception e) {
            responseMap.put("status","ERROR");
            responseMap.put("data",e.getMessage());
            // Si no encontró la persona por su id devuevle un bad_request
            if(e.getMessage().equals("PersonaNotFound")) 
                return Response.status(Status.BAD_REQUEST)
                                .entity(om.writeValueAsString(responseMap)).build();
            // Error del Servidor sino
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                            .entity(om.writeValueAsString(responseMap)).build();
        }
    }

}
