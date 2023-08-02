package helper;

import models.Project;
import models.User;
import utils.configuration.ReadProperties;

public class DataHelper {

    public static User getAdminUser() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        return user;
    }

    public static User getStandartUser() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        return user;
    }

    public static Project getCommonProject() {
        Project project = new Project.Builder()
                .withProjectName("ssdfsd")
                .withProjectType(1)
                .withFlag(true)
                .withAnnouncement("asdasd")
                .build();

        return project;
    }
}
