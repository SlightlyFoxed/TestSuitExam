package io.swagger.petstore;

import api.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SwaggerTest2 {
    static TagsPostPojo tagsPostPojo1;
    static CategoryPostPojo categoryPostPojo1;
    static RootPostPojo rootPostPojo1;
    private final static String URL = "https://petstore.swagger.io/";

    @Step("Создание body для собаки")
    public static void createDog(){
        tagsPostPojo1 = new TagsPostPojo();
        tagsPostPojo1.setId(1400);
        tagsPostPojo1.setName("A pain in the ass for a human");


        categoryPostPojo1 = new CategoryPostPojo();
        categoryPostPojo1.setId(1200);
        categoryPostPojo1.setName("Foxtrot");

        rootPostPojo1 = new RootPostPojo();
        rootPostPojo1.setId(1200);
        rootPostPojo1.setCategory(categoryPostPojo1);
        rootPostPojo1.setName("Sobaken");
        rootPostPojo1.setPhotoUrls(new String[]{"string"});
        rootPostPojo1.setTags(new TagsPostPojo[]{tagsPostPojo1});
        rootPostPojo1.setStatus("available");
    }
    @Step("Создание body для собаки с помощью HashMap")
    public void createDogWithHash (){
        HashMap tagsMap = new HashMap();
        tagsMap.put("id", 1400);
        tagsMap.put("name", "A pain in the ass for a human");

        HashMap doggy1 = new HashMap();
        doggy1.put("id", 1200);
        doggy1.put("category", categoryPostPojo1);
        doggy1.put("name", "Sobaken");
        String photoArr[] = {"string"};
        doggy1.put("photoUrls", photoArr);
        Map tagsArr[] ={tagsMap};
        doggy1.put("tags", tagsArr);
        doggy1.put("status", "available");
    }

    @Test(priority = 1,suiteName ="Тесты работы с API PetStore",testName = "Создание собаки (POST запрос)",description = "Создание собаки (POST запрос)")
    public static void testPostPet () {
        createDog();

        /*
        String bodyBody = "{\n" +
                "  \"id\": 1200,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1200,\n" +
                "    \"name\": \"Foxstrot\"\n" +
                "  },\n" +
                "  \"name\": \"Sobaken\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1400,\n" +
                "      \"name\": \"A pain in the ass for a human\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";*/

         given()
                .baseUri(URL)
                //.header("Content-Type","application/json")
                .accept(ContentType.JSON)
                .contentType("application/json")
                .body(rootPostPojo1)
                 .log().all()
                .when().post("v2/pet")
                .then().assertThat().statusCode(200)
                 .assertThat().body("id",equalTo(rootPostPojo1.getId()),
                         "category.id",equalTo(categoryPostPojo1.getId()),
                         "category.name",equalTo(categoryPostPojo1.getName()),
                         "name",equalTo(rootPostPojo1.getName()),
                         "tags[0].id",equalTo(tagsPostPojo1.getId()),
                         "tags[0].name",equalTo(tagsPostPojo1.getName()))
                .log().all();
    }
    @Test (priority = 2,suiteName ="Тесты работы с API PetStore",testName = "Получение собаки (Get запрос)",description = "Получение собаки (Get запрос)")
    @Attachment
    public void getPetAssert (){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecOK200());
        RootPostPojo petCategory = given()
                .when()
                .get("v2/pet/1200")
                .then().statusCode(200)
                .assertThat().body("id",equalTo(rootPostPojo1.getId()),
                        "category.id",equalTo(categoryPostPojo1.getId()),
                        "category.name",equalTo(categoryPostPojo1.getName()),
                        "name",equalTo(rootPostPojo1.getName()),
                        "tags[0].id",equalTo(tagsPostPojo1.getId()),
                        "tags[0].name",equalTo(tagsPostPojo1.getName()))
                .log().all()
                .extract().body().jsonPath().getObject("category",RootPostPojo.class);
    }
    @Test (priority = 3,suiteName ="Тесты работы с API PetStore",testName ="Изменение собаки (PUT запрос)",description = "Изменение собаки (PUT запрос)")
    public void putPetAssert (){
        createDog();
        rootPostPojo1.setName("Dristun");


        given()
                .baseUri(URL)
                .header("Content-Type","application/json")
                .accept(ContentType.JSON)
                .contentType("application/json")
                .body(rootPostPojo1)
                .log().all()
                .when()
                .put("v2/pet")
                .then().statusCode(200)
                .assertThat().body("id",equalTo(rootPostPojo1.getId()),
                        "category.id",equalTo(categoryPostPojo1.getId()),
                        "category.name",equalTo(categoryPostPojo1.getName()),
                        "name",equalTo(rootPostPojo1.getName()),
                        "tags[0].id",equalTo(tagsPostPojo1.getId()),
                        "tags[0].name",equalTo(tagsPostPojo1.getName()))
                .log().all();

    }
    @Test (priority = 4,suiteName ="Тесты работы с API PetStore",testName = "Удаление собаки (DELETE запрос)",description = "Удаление собаки (DELETE запрос)")
    public void deletePet (){
        given()
                .baseUri(URL)
                .accept(ContentType.JSON)
                .contentType("application/json")
                .when()
                .delete("v2/pet/1200")
                .then().statusCode(200)
                .assertThat().body("code",equalTo(200),
                        "type",equalTo("unknown"),
                        "message",equalTo("1200"))
                .log().all();

    }

}
