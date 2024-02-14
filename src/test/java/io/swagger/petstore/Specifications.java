package io.swagger.petstore;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public static RequestSpecification requestSpec (String ulr){
        return new RequestSpecBuilder()
                .setBaseUri(ulr)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Step("Быстрая проверка на статус код 200")
    public static ResponseSpecification responseSpecOK200 (){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    @Step("Быстрая проверка на статус код 400")
    public static ResponseSpecification responseSpecError404 (){
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }

    public static void installSpecification (RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
