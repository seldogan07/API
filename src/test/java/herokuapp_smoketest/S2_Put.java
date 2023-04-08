package herokuapp_smoketest;

import org.junit.Test;

public class S2_Put {
    /*
    Given
    https://restful-booker.herokuapp.com/booking/"id"
    And
    {
    "firstname" : "Mark",
    "lastname" : "Twain",
    "totalprice" : 555,
    "depositpaid" : false,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2024-01-01"
    },
    "additionalneeds" : "Extra pillow"
}
When
Send put request
Then
Status Code should be 200
And
 Body should be
 {
    "firstname": "Mark",
    "lastname": "Twain",
    "totalprice": 555,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-01-01",
        "checkout": "2024-01-01"
    },
    "additionalneeds": "Extra pillow"
}
     */
    @Test
    public void putTest(){
        //Set the url

        //Set the expected data

        // Send the request and get the response

        // Do assertion

    }
}
