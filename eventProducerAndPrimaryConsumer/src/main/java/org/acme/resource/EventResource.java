package org.acme.resource;

import org.acme.model.EventData;
import org.acme.producer.EventProducer;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/event")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

    @Inject
    EventProducer producer;

    @POST
    public Response send(EventData eventData) {
        producer.sendEventToKafka(eventData);
        // Return an 202 - Accepted response.
        return Response.accepted().build();
    }
}