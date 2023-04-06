package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class Get12 extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Gov. Vrinda Panicker", "Sen. Devika Embranthiri" and "Rev. Jay Shukla" are among the users
        And
            The female users are less than or equals to male users
    */

    @Test
    public void get12() {
        //Set the url
        spec.pathParam("first", "users");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then().
                statusCode(200).
                body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data",hasSize(10),"data.status",hasItem("active"),"data.name",hasItems("Sushma Somayaji","Girika Dwivedi","Anjali Sharma III"));
        //The female users are less than or equals to male users
        //1st way
        JsonPath jsonpPath =response.jsonPath();
        List<String> allGenders = jsonpPath.getList("data.gender");
        System.out.println("allGenders = " + allGenders);
        int numberOfFemale=0;
        for (String w:allGenders){
            if(w.equals("female")){
                numberOfFemale++;
            }
        }
        System.out.println("numberOfFemale = " + numberOfFemale);
        assertTrue(numberOfFemale<=allGenders.size()-numberOfFemale);

        //2nd way
        int numberOfFemaleUser= jsonpPath.getList("data.findAll{it.gender=='female'}").size();
        System.out.println("numberOfFemaleUser = " + numberOfFemaleUser);
        int numberOfMaleUser= jsonpPath.getList("data.findAll{it.gender=='male'}").size();
        System.out.println("numberOfMaleUser = " + numberOfMaleUser);
        assertTrue(numberOfFemaleUser<=numberOfMaleUser);

    }


}