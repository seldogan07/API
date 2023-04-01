package post_request;

import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.*;

public class Post03 extends base_urls.JsonPlaceHolderBaseUrl {
    /*
     Given
        https://jsonplaceholder.typicode.com/todos

    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
 */
    @Test
    public void post03(){
        //Set the url
        spec.pathParam("first","todos");
        //Set the expected data
        JsonPlaceHolderPojo expectedData= new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);
        //Send the request and get the response
        Response response=given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

    }
}
