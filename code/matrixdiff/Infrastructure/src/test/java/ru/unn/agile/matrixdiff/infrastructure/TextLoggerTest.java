package ru.unn.agile.matrixdiff.infrastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;

public class TextLoggerTest {
    private TextLogger logger;
    private static final String NAME_OF_FILE_LOG = "./testTimles.log";

    @Before
    public void enteringDateForInterface() {
        logger = new TextLogger(NAME_OF_FILE_LOG);
    }

    @After
    public void tearDown() {
        if (new File(NAME_OF_FILE_LOG).isFile()) {
            try {
                Files.delete(new File(NAME_OF_FILE_LOG).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger = null;
    }

    @Test
    public void canLogMessageToLogfile() {
        logger.log("Hello world!");
    }

    @Test
    public void canGetLogFromLogfile() {
        logger.getLog();
    }

    @Test
    public void checkCorrectSavingStroke() {
        String firstMessage = "test message";

        logger.log(firstMessage);
        String storedMessage = logger.getLog().get(0);

        assertTrue(storedMessage.endsWith(firstMessage));
    }

    @Test
    public void checkCorrectSavingDate() {
        String[] testMes = new String[]{
                "message 1", "message 2", "message 3"};

        for (String message : testMes) {
            logger.log(message);
        }
        List<String> listMessages = logger.getLog();

        for (int i = 0; i < listMessages.size(); i++) {
            testMes[i].endsWith(listMessages.get(i));
        }
    }

    @Test
    public void canCreateLoggerAnotherFilename() {
        String filenameTime = "timlesLog.log";
        logger = new TextLogger(filenameTime);
        assertNotNull(logger);
    }

}
