package tests;

import baseEntities.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

@Slf4j
public class LoggerTest extends BaseTest {
    Logger logger = LogManager.getLogger(LoggerTest.class);

    @Test
    public void loggerTest() {
        logger.trace("Trace Message...");
        logger.debug("Debug Message...");
        logger.info("Info Message...");
        logger.warn("Warning Message...");
        logger.error("Error Message...");
        logger.fatal("Fatal Message...");

        log.info("Lombok - log message");
        log.error("Lombok - log message");
        log.warn("Lombok - log message");
    }
}
