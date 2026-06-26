package com.pinot.central.resource;

import io.swagger.v3.oas.annotations.Operation;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;


/**
 * @author ankush.nakaskar
 */
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/event")
public class OpenTracingResource {


    @GET
    @Path("/{event}")
    @Operation(summary = "API to test open tracing with different scenarios",description = "This API is used to test open tracing with different scenarios like normal flow, queue, memq, api call and thread")
    public Response openTracingTesting(@PathParam("event") final String event) {
        log.info("openTelemetry is  {}","start");


        try{
            System.out.println("Inside the openTracingTesting...... ");
            return Response.ok().entity("Success").build();
        }finally {
            log.info("openTelemetry is  {}","value");

        }

    }





}
