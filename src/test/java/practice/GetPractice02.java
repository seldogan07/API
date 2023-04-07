package practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class GetPractice02 extends base_urls.PetStoreBaseUrl {
     /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sends Get request
    Then
        Assert that number of pets whose status is "available" is more than 100
     */
    @Test
    public void petStoreAvaliablePets(){
        spec.pathParams("first","pet","second","findByStatus").queryParam("status","available");
        Response response =given(spec).get("/{first}/{second}");
        response.prettyPrint();

        int availablePetNumber= response.jsonPath().getList("id").size();
        System.out.println("availablePetNumber = " + availablePetNumber);
        assertTrue(availablePetNumber>100);

    }
}
