/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firebasedemo;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
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
        DocumentReference colref = db.collection("Events").document("users").collection("EventsList").document();
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Alan");
        data.put("middle", "Mathison");
        data.put("last", "Turing");
        data.put("born", 1912);
        ApiFuture<WriteResult> result = colref.set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
        //***********************************************************************************
        //******************uploading file *************************************************//
        
        
        //**********************************************************************************//

    }

}
