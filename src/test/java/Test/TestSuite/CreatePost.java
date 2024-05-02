package Test.TestSuite;

import config.PathConfig;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import pojo.CreatePojo;
import utils.UserRegister;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;


@DisplayName("API Test Rest request Create")
public class CreatePost extends PathConfig {

    CreatePojo user;
    @BeforeEach
    public void beforeEach () {
        user = new UserRegister().fillUser();
    }
    @Test
    @DisplayName("Validar que o metodo Post retorna status code 201")
    public void testCreatePost() {
        given()
                .contentType(ContentType.JSON)
                .body(user)
        .when()
                .post(path+"/users")

        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("Contracts/CreatePost.json"))
                .log()
                .all();
    }
    @Test
    @DisplayName("Validar campos obrigatórios")
    public void testRequiredFields() {
        given()
                .contentType(ContentType.JSON)
                .body(user)
        .when()
                .post(path+"/users")

        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(matchesJsonSchemaInClasspath("Contracts/CreatePost.json"))
                .log()
                .all();
    }
    @Test
    @DisplayName("Validação do contrato")
    public void testContract() {
        given()
                .contentType(ContentType.JSON)
                .body(user)
        .when()
                .post(path+"/users")

        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(matchesJsonSchemaInClasspath("Contracts/CreatePost.json"))
                .log()
                .all();
    }

}
