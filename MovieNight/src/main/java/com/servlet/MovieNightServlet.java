package com.servlet;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.movienight.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 *
 * @author viru
 */
public class MovieNightServlet extends ServletContainer {

    private static final String LOG_TAG = "[Main]- ";

    public void init() throws ServletException {
        setupLog4J();

        super.init();

        //Initializing Firebase admin sdk
        FileInputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream(Constants.CREDIENTIAL_FILE);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    //                    .setDatabaseUrl(Constants.DATABASE_URL)
                    .build();
            FirebaseApp.initializeApp(options);
            log(LOG_TAG + "Firebase initialized successfully", Constants.LOGGER_TYPE_INFO);
        } catch (Exception ex) {
            logException(ex);
            Logger.getLogger(MovieNightServlet.class.getName()).log(Level.toLevel("SEREVER"),ex);
        }
    }

    /**
     * setting up Log4J
     */
    private static void setupLog4J() {
        String path = "";
        path = "D:\\GitKrakenProject\\JavaProject\\MovieNight";
        File file = new File(path);
        path = file.getParent();

        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%5p [%t] %d{ISO8601} - %m%n";
        layout.setConversionPattern(conversionPattern);

        DailyRollingFileAppender rollingAppender_Info = new DailyRollingFileAppender();
        rollingAppender_Info.setFile(path + "/logs/info.log");
        rollingAppender_Info.setDatePattern("'-'yyyy-MM-dd");
        rollingAppender_Info.setLayout(layout);
        rollingAppender_Info.activateOptions();

        org.apache.log4j.Logger rootLogger_Info = org.apache.log4j.Logger.getLogger(Constants.LOGGER_TYPE_INFO);
        rootLogger_Info.setLevel(org.apache.log4j.Level.INFO);
        rootLogger_Info.addAppender(rollingAppender_Info);

        DailyRollingFileAppender rollingAppender_Error = new DailyRollingFileAppender();
        rollingAppender_Error.setFile(path + "/logs/error.log");
        rollingAppender_Error.setDatePattern("'-'yyyy-MM-dd");
        rollingAppender_Error.setLayout(layout);
        rollingAppender_Error.activateOptions();

        org.apache.log4j.Logger rootLogger_Error = org.apache.log4j.Logger.getLogger(Constants.LOGGER_TYPE_ERROR);
        rootLogger_Error.setLevel(org.apache.log4j.Level.ERROR);
        rootLogger_Error.addAppender(rollingAppender_Error);

    }

    public static void logException(Exception ex) {
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        String exception = sw.toString();
        log(LOG_TAG + exception, Constants.LOGGER_TYPE_ERROR);
    }

    public static void log(String msg, String logType) {
        switch (logType) {
            case Constants.LOGGER_TYPE_INFO:
                org.apache.log4j.Logger LOGGER_INFO = org.apache.log4j.Logger.getLogger(Constants.LOGGER_TYPE_INFO);
                LOGGER_INFO.info(msg);
                break;
            case Constants.LOGGER_TYPE_ERROR:
                org.apache.log4j.Logger LOGGER_ERROR = org.apache.log4j.Logger.getLogger(Constants.LOGGER_TYPE_ERROR);
                LOGGER_ERROR.error(msg);
                break;
        }
    }
}
