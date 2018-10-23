package com.service;

import com.database.UserCollection;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.firebase.auth.FirebaseAuth;
import com.model.RegisterTokenPojo;
import com.model.TokenDataPojo;
import com.movienight.Constants;
import static com.servlet.MovieNightServlet.log;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author viru
 */
@Path("/register")
public class RegisterToken {

    private static final String LOG_TAG = "[RegisterToken]- ";

    private static TokenDataPojo dataPojo = null;
    private static RegisterTokenPojo registerTokenPojo = null;

    public static RegisterTokenPojo getRegisterTokenPojo() {
        return registerTokenPojo;
    }

    public static TokenDataPojo getDataPojo() {
        return dataPojo;
    }

    /**
     * receiving idToken, verifying and adding to user collection
     *
     * @param idToken
     * @return
     * @throws IOException
     */
    @POST
    @Path("/idToken")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response idToken(String idToken) throws IOException {

        registerTokenPojo = new ObjectMapper().readValue(idToken, RegisterTokenPojo.class);
        if (verifyIdToken(registerTokenPojo.getJwtToken())) {

            String[] split_string = idToken.split("\\.");
            String base64EncodedBody = split_string[1];
            Base64 base64Url = new Base64(true);
            String body = new String(base64Url.decode(base64EncodedBody));
            try {
                dataPojo = new ObjectMapper().readValue(body, TokenDataPojo.class);
            } catch (Exception e) {
                log(LOG_TAG + e, Constants.LOGGER_TYPE_INFO);
            }
            UserCollection.UserCollectionList();
            return Response.status(Response.Status.OK)
                    .entity("Success")
                    .build();
        } else {
            log(LOG_TAG + "Token Expired or not valid", Constants.LOGGER_TYPE_INFO);
            return Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity("Token Expired or not valid")
                    .build();
        }
    }

    public static Boolean verifyIdToken(String idToken) {
        try {
            FirebaseAuth.getInstance().verifyIdToken(idToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
