/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firebasedemo;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.internal.Nullable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author viru
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException, ExecutionException {
        FileInputStream serviceAccount
                = new FileInputStream("D:\\restwebservices\\FirebaseDemo\\demoproject.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setStorageBucket("demoproject-13eab.appspot.com")
                .build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        //************************* Adding Data *******************************************//
//        DocumentReference docRef = db.collection("users").document();
//        CollectionReference colref=db.collection("Events").document("users").collection("EventsList").document();
//        DocumentReference colref = db.collection("Events").document("users").collection("EventsList").document();
//        Map<String, Object> data = new HashMap<>();
//        data.put("first", "Alan");
//        data.put("middle", "Mathison");
//        data.put("last", "Turing");
//        data.put("born", 1912);
//        ApiFuture<WriteResult> result = colref.set(data);
//        System.out.println("Update time : " + result.get().getUpdateTime());
        //***********************************************************************************
        //*********************Adding Data **************************************************//
//        City city = new City("Los Angeles", "CA", "USA", false, 3900000L,
//                Arrays.asList("west_coast", "socal"));
//        ApiFuture<WriteResult> future = db.collection("cities").document("LA").set(city);
//        CollectionReference cities = db.collection("cities");
//        List<ApiFuture<WriteResult>> futures = new ArrayList<>();
//        futures.add(cities.document("SF").set(new City("San Francisco", "CA", "USA", false, 860000L,
//                Arrays.asList("west_coast", "norcal"))));
//        futures.add(cities.document("LA").set(new City("Los Angeles", "CA", "USA", false, 3900000L,
//                Arrays.asList("west_coast", "socal"))));
//        futures.add(cities.document("DC").set(new City("Washington D.C.", null, "USA", true, 680000L,
//                Arrays.asList("east_coast"))));
//        futures.add(cities.document("TOK").set(new City("Tokyo", null, "Japan", true, 9000000L,
//                Arrays.asList("kanto", "honshu"))));
//        futures.add(cities.document("BJ").set(new City("Beijing", null, "China", true, 21500000L,
//                Arrays.asList("jingjinji", "hebei"))));
//        ApiFutures.allAsList(futures).get();
//        System.out.println("Update time : " + future.get().getUpdateTime());
        //******************** Add document data with auto-generated id. *****************************//
//        Map<String, Object> data = new HashMap<>();
//        data.put("name", "Tokyo");
//        data.put("country", "Japan");
//        ApiFuture<DocumentReference> addedDocRef = db.collection("cities").add(data);
//        System.out.println("Added document with ID: " + addedDocRef.get().getId());
        //*********************Create an initial document to update *********************//
//        DocumentReference frankDocRef = db.collection("users").document("frank");
//        Map<String, Object> initialData = new HashMap<>();
//        initialData.put("name", "Frank");
//        initialData.put("age", 12);
//
//        Map<String, Object> favorites = new HashMap<>();
//        favorites.put("food", "Pizza");
//        favorites.put("color", "Blue");
//        favorites.put("subject", "Recess");
//        initialData.put("favorites", favorites);
//
//        ApiFuture<WriteResult> initialResult = frankDocRef.set(initialData);
//
//        // Confirm that data has been successfully saved by blocking on the operation
//        initialResult.get();
//        // Update age and favorite color
//        Map<String, Object> updates = new HashMap<>();
//        updates.put("age", 13);
//        updates.put("favorites.color", "Red");
//        // Async update document
//        ApiFuture<WriteResult> writeResult = frankDocRef.update(updates);
//// ...
//        System.out.println("Update time : " + writeResult.get().getUpdateTime());
        //************************************************************************************//
//        DocumentReference docRef = db.collection("objects").document("some-id");
//// Update the timestamp field with the value from the server
//        ApiFuture<WriteResult> writeResult = docRef.update("timestamp", FieldValue.serverTimestamp());
//        System.out.println("Update time : " + writeResult.get());
//***************Retrieving data for a particular documant **************************//
//        DocumentReference docRef = db.collection("cities").document("SF");
//        ApiFuture<DocumentSnapshot> future = docRef.get();
//        DocumentSnapshot document = future.get();
//        if (document.exists()) {
//            System.out.println("Document data: " + document.getData());
//        } else {
//            System.out.println("No such document!");
//        }
//       ********//asynchronously retrieve multiple documents ************************
//        ApiFuture<QuerySnapshot> future
//                = db.collection("cities").whereEqualTo("capital", true).get();
//        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
//        for (DocumentSnapshot document : documents) {
//            System.out.println(document.getId() + " => " + document.getData());
//        }
//****************AddOnListener method ************************************************//
//        DocumentReference docRef = db.collection("cities").document("SF");
//        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirestoreException e) {
//                if (e != null) {
//                    System.err.println("Listen failed: " + e);
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()) {
//                    System.out.println("Current data: " + snapshot.getData());
//                } else {
//                    System.out.print("Current data: null");
//                }
//            }
//        });

        //********************************Listen to multiple documents in a collection****************//
        db.collection("cities")
                .whereEqualTo("state", "CA")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                            @Nullable FirestoreException e) {
                        if (e != null) {
                            System.err.println("Listen failed:" + e);
                            return;
                        }

                        List<String> cities = new ArrayList<>();
                        for (DocumentSnapshot doc : snapshots) {
                            if (doc.get("name") != null) {
                                cities.add(doc.getString("name"));
                            }
                        }
                        System.out.println("Current cites in CA: " + cities);
                    }
                });
        //******************uploading file *************************************************//
        //**********************************************************************************//
    }

}
