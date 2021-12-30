package com.fintech.accounts;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static io.restassured.RestAssured.given;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AccountsApplicationTests {

    @Test
    public void updateAccount() {
        String endpoint = "http://localhost:8000/fintech/account/UpdateAccount";
        String body = """
                {
                    "accountNo":"1000000005",
                    "customertype":"New",
                    "firstName":"John",
                    "otherNames":"Nate",
                    "lastName":"Doe",
                    "address":"test address",
                    "gender":"Male",
                    "phone":"1232454545",
                    "email":"johndoe@sample.com"
                }
                """;

        var response = given().contentType(ContentType.JSON)
                .body(body).when().put(endpoint).then()
                .assertThat().statusCode(200);
    }

    @Test
    public void getAccount() {
        String endpoint = "http://localhost:8000/fintech/account/getAccount/{accountNo}";
        var response =
                given()
                        .pathParam("accountNo", 1000000005)
                                .when()
                                        .get(endpoint)
                                                .then()
                        .assertThat()
                        .statusCode(200);

    }

}
