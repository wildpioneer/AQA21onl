package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import org.openqa.selenium.json.TypeToken;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestRailApiTest2 extends BaseApiTest {

    @Test
    public void getAllUsers() {
        User expectedUser = User.builder()
                .name("Alex Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .body("get(0).name", is(expectedUser.getName()))
                .body("get(0).email", equalTo(expectedUser.getEmail()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getTest() {
        int userID = 1;

        User expectedUser = User.builder()
                .name("Alex Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        User actualUser = given()
                .pathParam("user_id", userID)
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class);

        System.out.println(actualUser.toString());
        Assert.assertTrue(expectedUser.equals(actualUser));
    }

    @Test
    public void getTest1() throws FileNotFoundException {
        int userID = 1;
        Gson gson = new Gson();

        FileReader reader = new FileReader("/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Groups/AQA21onl/src/test/resources/expectedUser.json");
        User expectedUser = gson.fromJson(reader, User.class);

        String json = gson.toJson(expectedUser);
        System.out.println(json);


        Response response = given()
                .pathParam("user_id", userID)
                .get(Endpoints.GET_USER);

        User actualUser = gson.fromJson(response.getBody().asString(), User.class);

        System.out.println(actualUser.toString());
        Assert.assertTrue(expectedUser.equals(actualUser));
    }

    @Test
    public void getAllUsers1() {
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .name("Alex Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .when()
                .get(Endpoints.GET_ALL_USERS);

        User[] actualUsers = gson.fromJson(response.getBody().asString(), User[].class);

        User actualUser = new User();
        for (User user :
                actualUsers) {
            if (user.getId() == 1) {
                actualUser = user;
            }

        }
        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getAllUsers2() {
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .name("Alex Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .when()
                .get(Endpoints.GET_ALL_USERS);

        Type listType = new TypeToken<ArrayList<User>>() {}.getType();
        List<User> actualUsersList = gson.fromJson(response.getBody().asString(), listType);

        Assert.assertEquals(actualUsersList.get(0), expectedUser);
    }

}
