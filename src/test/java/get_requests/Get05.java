package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class Get05 extends base_urls.HerOkuAppBaseUrl {
    /*
       Given
           https://restful-booker.herokuapp.com/booking
       When
           User sends get request to the URL
       Then
           Status code is 200
         And
             Among the data there should be someone whose firstname is "Jane" and lastname is "Doe"
    */
    @Test
    public void get05(){
        //set url7
        //https://restful-booker.herokuapp.com/booking/?firstname=Jane&lastname=Doe
        spec.pathParam("first","booking").queryParams("firstname","Jane",
                "lastname","Doe");
        //Set the expected data

        //Send the request and get the response
        Response response= given().spec(spec).when().get("{first}");
        response.prettyPrint();
        //Do Assertion
        //1st Way
   // response.then().statusCode(200).body("",hasSize(greaterThan(0)));
        //2nd Way
        assertTrue(response.asString().contains("bookingid"));
    }
}
