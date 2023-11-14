package io.swagger.petstore;

import api.RootPojo;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SwaggerTest3 {
    private final static String URL = "https://petstore.swagger.io/";

    @Test
    public void getPetCategory (){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecOK200());
        RootPojo petCategory = given()
                .when()
                .get("v2/pet/1200")
                .then().statusCode(200)
                .log().all()
                .extract().body().jsonPath().getObject("category",RootPojo.class);

    }
}
