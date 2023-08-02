package helper;

import models.User;
import utils.configuration.ReadProperties;

public class DataHelper {

    public static User getUser() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        return user;
    }
}
