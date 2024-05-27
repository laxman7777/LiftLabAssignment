package com.Liftlabs.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.Assert;
import com.Liftlabs.requests.ApiRequest;
import com.Liftlabs.test.TestData;
import com.Liftlabs.test.Root;

public class PetStoreSteps {
    private Response response;
    private ApiRequest apiRequest ;
    private RequestSpecification request;
    

    @Given("I set the base URI")
    public void i_set_the_base_uri() {
        
    	apiRequest = new ApiRequest();
        request = apiRequest.getRequest();
    	
    }

    @When("I get pets with status {string}")
    public void i_get_pets_with_status(String status) {
    	request = request.queryParam("status", status);
           
    }
    
    @When("I {word} request with resource {string}")
    public void i_request_with_resource(String method, String resource) {
    	
        method = method.replace("\"", "").trim().toLowerCase();
       // System.out.println("Trimmed and Lowercased HTTP Method: '" + method + "'");
       // System.out.println("Resource: '" + resource + "'");
        
        switch (method) {
            case "get":
                response = request.when().get(resource);
                break;
            case "put":
                response = request.when().put(resource);
                break;
            case "post":
                response = request.when().post(resource);
                break;
            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }
      
    }


    @Then("I should receive status code {int}")
    public void i_should_receive_status_code(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    
    

    @Then("the response should match the schema {string}")
    public void the_response_should_match_the_schema(String schemaPath) {
        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
    }
    @When("I update pet with ID {long} and name {string} and status {string} and tag {string}")
    public void i_update_pet_with_id_and_name_and_status_and_tag(Long id, String name, String status, String tag) {
       
    	 Root pet = TestData.createPet(id, name,status,tag);
         
         request = request.body(pet);
        
    }
    @Then("the response should contain updated pet information with ID {long} and name {string} and status {string} and tag {string}")
    public void the_response_should_contain_updated_pet_information_with_id_and_name_and_status_and_tag_tag_update(Long id, String name, String status, String tag) {
        
    	 Root pet = response.as(Root.class);
    	 
         Assert.assertEquals(pet.getId(), id);
         Assert.assertEquals(pet.getCategory().getId(), 1);
         Assert.assertEquals(pet.getCategory().getName(), "string");
         Assert.assertEquals(pet.getName(), name);
         Assert.assertEquals(pet.getStatus(), status);
         Assert.assertEquals(pet.getTags().get(0).getId(), 1);
         Assert.assertEquals(pet.getTags().get(0).getName(), tag);
         
    }
   

   
}