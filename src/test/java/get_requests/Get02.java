package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Get02 {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */
    @Test
    public void get02(){
        //Set the URL
        String url="https://restful-booker.herokuapp.com/booking/0";
        //Set the expected

        //Send the request and get the response
        Response response=given().when().get(url);
        response.prettyPrint();
        //Do assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        //How to assert if response body contains any data
        //Response body contains "Not Found"
        assertEquals("Not Found",response.asString());
        //Response body does not contain "TechProEd"
        assertFalse(response.asString().contains("TechProEd"));
    }
}
