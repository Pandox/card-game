package integration;


import com.jayway.restassured.http.ContentType;
import integration.shared.IntegrationServer;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MatchmakingIT extends IntegrationServer {

    @Test
    public void should_queue_2_players_and_match_them() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"player\": 1 }")
            .when()
            .post("http://127.0.0.1:15081/api/matchmaking")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_CREATED)
            .and()
            .body("id", equalTo(1));

        given()
            .contentType(ContentType.JSON)
            .body("{ \"player\": 2 }")
            .when()
            .post("http://127.0.0.1:15081/api/matchmaking")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_CREATED)
            .and()
            .body("id", equalTo(1));


        get("http://127.0.0.1:15081/api/matchmaking/1")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_OK)
            .and()
            .body("battleground_id", equalTo(1));
    }

}
