package com.steps.ui;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.utilities.LoginPayload;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiSteps {


    private RequestSpecification requestSpecification;
    private Response response;
    private JsonObject jsonObject;
    private String body;


    @Given("^I create a payload with email \"([^\"]*)\" password \"([^\"]*)\"$")
    public void iCreateAPayloadWithEmailPassword(String uname, String pass){

        LoginPayload loginPayload = new LoginPayload();
        loginPayload.setEmail(uname);
        loginPayload.setPassword(pass);

        Gson gson = new Gson();
        body = gson.toJson(loginPayload);


    }

    @And("^I send a post request to the url \"([^\"]*)\"$")
    public void iSendAPostRequestToTheUrl(String url){
        RestAssured.baseURI = url.toString();
        requestSpecification = given();
        response = requestSpecification
                .contentType("application/json")
                .body(body)
                .post();

              String ms =  given()
                .when()
                        .body(body)
                        .post()
                        .then()
                        .extract()
                        .path("error.message");

        System.out.println(ms);

//             ValidatableResponse validatableResponse = given()
//                .body(body)
//                .post()
//                .then()
//                .assertThat().body("error.msg", Matchers.equalToIgnoringCase("User credentials are invalid."));
//        String temp = response


    }

    @Then("^I validate the response contains error message \"([^\"]*)\"$")
    public void iValidateTheResponseContainsErrorMessage(String input) {

        JsonPath jsonPath = response.jsonPath();
        Map<String,String> map = jsonPath.get("error");
        String msg = map.get("message");
        Assert.assertTrue(msg.equalsIgnoreCase(input));

        test();

    }

    public void test(){

       ValidatableResponse validatableResponse = given()
              .pathParam("race",2017)
              .when()
              .get("http://ergast.com/api/f1/{race}/circuits.json")
              .then()
              .assertThat()
              .body("MRData.CircuitTable.Circuits.circuitId",Matchers.hasSize(20));

        String s = validatableResponse.toString();
        System.out.println(s);
    }

    public void test2(){

        ResponseSpecification checkstatuscode =
                 new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

                       given()
                              .when()
                              .get("http://ergast.com/api/f1/2017/circuits.json")
                              .then()
                              .assertThat()
                              .spec(checkstatuscode);

        String cid = given()
                        .when()
                        .get("http://ergast.com/api/f1/2017/circuits.json")
                        .then()
                        .extract()
                        .path("MRData.CircuitTable.Circuits.circuitId[0]");

        System.out.println(cid);
    }

}
