package com.database;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.model.RegisterTokenPojo;
import com.model.TokenDataPojo;
import com.movienight.Constants;
import com.service.RegisterToken;
import static com.service.RegisterToken.getDataPojo;
import static com.servlet.MovieNightServlet.log;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author viru
 */
public class UserCollection {

    private static final String LOG_TAG = "[UserCollection]- ";

    /**
     * Creating a user document in Firestore using userid as document id
     */
    public static void UserCollectionList() {
        RegisterTokenPojo registerTokenPojo = RegisterToken.getRegisterTokenPojo();
        TokenDataPojo dataObj = getDataPojo();
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(Constants.USERS_COLLECTION).document(dataObj.getUserid());
        Map<String, Object> data = new HashMap<>();
        data.put("user_id", dataObj.getUserid());
//        data.put("name", registerTokenPojo.getName());
        data.put("phone_number", dataObj.getPhonenumber());
        data.put("sign_in_provider", dataObj.getFirebasePojo().getSign_in_provider());
        ApiFuture<WriteResult> result = docRef.set(data);
        try {
            log(LOG_TAG + "User Collection - Update time : " + result.get().getUpdateTime(), Constants.LOGGER_TYPE_INFO);
        } catch (Exception ex) {
            log(LOG_TAG + "Authentication incorrect", Constants.LOGGER_TYPE_INFO);
            Logger.getLogger(UserCollection.class.getName()).log(Level.toLevel("SEREVER"), null, ex);
        }
    }

}
