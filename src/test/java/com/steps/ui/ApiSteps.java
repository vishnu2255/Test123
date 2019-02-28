package com.steps.ui;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.utilities.LoginPayload;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.util.Map;

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
        requestSpecification = RestAssured.given();

        response = requestSpecification
                .contentType("application/json")
                .body(body)
                .post();


    }

    @Then("^I validate the response contains error message \"([^\"]*)\"$")
    public void iValidateTheResponseContainsErrorMessage(String input) {

        JsonPath jsonPath = response.jsonPath();
        Map<String,String> map = jsonPath.get("error");
        String msg = map.get("message");
        Assert.assertTrue(msg.equalsIgnoreCase(input));

    }

}
