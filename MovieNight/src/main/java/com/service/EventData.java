/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.servlet.MovieNightServlet;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * @author viru
 */
@Path("/event")
public class EventData {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Firestore db = FirestoreClient.getFirestore();
        JSONObject object = new JSONObject();
        ApiFuture<QuerySnapshot> future = db.collection("Events").document("userid2").collection("eventsCollection").get();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (DocumentSnapshot document : documents) {
                object.append(document.getId(), document.getData());
            }
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (Exception e) {
            MovieNightServlet.logException(e);
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("error" + e).build();
        }
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") String id) {
        Firestore db = FirestoreClient.getFirestore();
        JSONObject object = new JSONObject();
        DocumentReference docRef = db.collection("Events").document("userid2").collection("eventsCollection").document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        try {
            DocumentSnapshot document = future.get();
            object.append(document.getId(), document.getData());
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (Exception e) {
            MovieNightServlet.logException(e);
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("error" + e).build();
        }
    }

}
