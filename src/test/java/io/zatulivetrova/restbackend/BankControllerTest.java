package io.zatulivetrova.restbackend;

import io.restassured.specification.RequestSpecification;
import io.zatulivetrova.restbackend.domain.UserInfo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.with;

public class BankControllerTest {


    private RequestSpecification spec = with()
            .baseUri("http://localhost:8080")
            .basePath("/");

    @Test
    void bankControllerTest() {
        UserInfo[] userInfos = spec.get("user/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserInfo[].class);

        System.out.println();


        //Stream.of(userInfos)
        //.filter(userInfo -> userInfo.getUserName().equals("Dima"))
        //.findFirst()
        //.peek(userInfos -> System.out.println(userInfos.getUserName()))
        //.orElseThrow(()-> new RuntimeException())
    }
}
