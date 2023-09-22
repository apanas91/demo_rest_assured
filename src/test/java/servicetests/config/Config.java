package servicetests.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Config {

    private static String token = "";

    public static void setToken(String t) {
        token = t;
    }

    public static RequestSpecification serviceSpec() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:8081")
                .setBasePath("api/v1")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        if (token != null && !token.isEmpty()) {
            builder.addHeader("Authorization", "Bearer " + token);
        }

        return builder.build();
    }
}
