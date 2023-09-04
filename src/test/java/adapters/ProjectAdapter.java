package adapters;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import models.Projects;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {
    private Gson gson = new Gson();

    public Response add(Project expectedProject) {
        return given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    public Projects getAllProjects() {
        Response response = given()
                .get(Endpoints.GET_ALL_PROJECTS)
                .then()
                .log().body()
                .extract()
                .response();

        return gson.fromJson(response.getBody().asString(), Projects.class);
    }
}
