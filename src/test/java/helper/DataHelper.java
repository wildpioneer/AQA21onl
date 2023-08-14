package helper;

import models.Project;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.configuration.ReadProperties;

public class DataHelper {
    static Logger logger = LogManager.getLogger(DataHelper.class);

    public static User getAdminUser() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        logger.info(user.toString());
        return user;
    }

    public static Project getProject() {
        Project project = new Project();
        project.setProjectName("WP_TEST_01");
        project.setAnnouncement("Test Description");
        project.setFlag(false);
        project.setProjectType(1);

        return project;
    }
}
