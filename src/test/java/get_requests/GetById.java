package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetById extends base_urls.HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/1
    When
        User send Get request
    Then
        Status code should be 200
    And
        Body should be like
        {
    "firstname" : "Jack",
    "lastname" : "Doe",
    "totalprice" : 150,
    "depositpaid" : false,
    "bookingdates" : {
        "checkin" : "2023-03-24",
        "checkout" : "2023-03-25"
    },
    "additionalneeds" : "Breakfast"
    }
     */
    @Test
    public void GetById() {
        //Set the url
        spec.pathParams("first","booking","second",23);
        //Set the expected data

        //Send the request and theresponse
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();
        //Do Assertion
        response.then().statusCode(200).
                body("firstname",equalTo("Jane"),
                        "lastname",equalTo("Doe"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo(2023-03-24),
                        "bookingdates.checkout",equalTo(2023-03-25),
                        "additionalneeds",equalTo("Breakfast"));

    }

}
