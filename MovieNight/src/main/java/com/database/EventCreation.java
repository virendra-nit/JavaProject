package com.database;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.model.EventCreatePojo;
import com.movienight.Constants;
import com.service.EventData;
import static com.servlet.MovieNightServlet.log;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author viru
 */
public class EventCreation {

    private static final String LOG_TAG = "[EventCreation]- ";

    /**
     * creating events based on user id eventid will be auto-generated
     */
    public static void eventCreationUserId() {

        EventCreatePojo eventCreatePojo = EventData.getEventCreatePojo();
         

        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(Constants.EVENTS_COLLECTION).document(eventCreatePojo.getUserid()).collection(Constants.EVENTS_LIST).document();
        Map<String, Object> data = new HashMap<>();
        data.put("posterImg", eventCreatePojo.getPosterImg());
        data.put("movieName", eventCreatePojo.getMovieName());
        data.put("dateTime", eventCreatePojo.getDateTime());
        data.put("invities", eventCreatePojo.getInvities());
        data.put("message", eventCreatePojo.getMessage());

        ApiFuture<WriteResult> result = docRef.set(data);

        try {
            log(LOG_TAG + "Events Collection - Update time : " + result.get().getUpdateTime(), Constants.LOGGER_TYPE_INFO);
        } catch (Exception ex) {
            log(LOG_TAG + "Event creation failed", Constants.LOGGER_TYPE_INFO);
            Logger.getLogger(UserCollection.class.getName()).log(Level.toLevel("SEREVER"), null, ex);
        }
    }

}
