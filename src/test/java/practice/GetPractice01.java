package practice;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class GetPractice01 extends HerOkuAppBaseUrl {

      /*
        Given
                https://restful-booker.herokuapp.com/booking/43
        When
                I send GET Request to the URL
        Then
                Status code is 200
                        {
                            "firstname": "Josh",
                            "lastname": "Allen",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds":  "midnight snack"
                        }
     */


    @Test
    public void get01() throws IOException {

        spec.pathParams("first", "booking", "second", 202);

        BookingDatesPojo bookingDatesPojo= new BookingDatesPojo("2018-01-01", "2019-01-01");

        BookingPojo expectedData= new BookingPojo("Josh", "Allen", 111, true, bookingDatesPojo, "midnight snack");
        System.out.println("expectedData = " + expectedData);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        BookingPojo actualData =new ObjectMapper().readValue(response.asString(),BookingPojo.class);
        System.out.println("actualData = " + actualData);
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),200);
        assertEquals(actualData.getFirstname(),expectedData.getFirstname());
        assertEquals(actualData.getLastname(),expectedData.getLastname());
        assertEquals(actualData.getTotalprice(),expectedData.getTotalprice());
        assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid());
        assertEquals(actualData.getBookingdates().getCheckin(),bookingDatesPojo.getCheckin());
        assertEquals(actualData.getBookingdates().getCheckout(),bookingDatesPojo.getCheckout());
        assertEquals(actualData.getAdditionalneeds(),expectedData.getAdditionalneeds());
        softAssert.assertAll();
    }

 /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sends Get request
    Then
        Assert that number of pets whose status is "available" is more than 100
     */





}