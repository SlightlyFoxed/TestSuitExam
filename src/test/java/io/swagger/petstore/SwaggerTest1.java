package io.swagger.petstore;

import api.CategoryPojo;
import api.RootPojo;
import api.RootPostPojo;
import api.TagPojo;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class SwaggerTest1 {
    private final static String URL = "https://petstore.swagger.io/";

    @Test(testName = "Получение собаки (Get запрос)")
    public void getPetCategory (){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecOK200());
        RootPostPojo petCategory = given()
                .when()
                .get("v2/pet/1200")
                .then().statusCode(200).log().all()
                .extract().body().jsonPath().getObject("category", RootPostPojo.class);

    }


}
