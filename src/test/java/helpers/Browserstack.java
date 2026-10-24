package helpers;

import static io.restassured.RestAssured.given;


public class Browserstack {

//     curl -u "pavel_s0CitJ:cmQtmJkaLXrcUx57WzEi" -X GET "https://api.browserstack.com/app-automate/sessions/2a9f07bef69a123d5d50648da0cc690356209104.json"
//     automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("pavel_s0CitJ", "cmQtmJkaLXrcUx57WzEi")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}