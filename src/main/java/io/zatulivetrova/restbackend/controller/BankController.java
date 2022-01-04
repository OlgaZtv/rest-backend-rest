package io.zatulivetrova.restbackend.controller;

import io.swagger.annotations.ApiOperation;
import io.zatulivetrova.restbackend.domain.LoginInfo;
import io.zatulivetrova.restbackend.domain.UserInfo;
import io.zatulivetrova.restbackend.exception.InvalidUsernameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {

    private Map<String, UserInfo> users = Map.of(
            "Olga", UserInfo.builder().userName("Olga").build(),
            "Ivan", UserInfo.builder().userName("Ivan").build(),
            "Masha", UserInfo.builder().userName("Masha").build()
    );

    @PostMapping("user/login")
    @ApiOperation("Авторизация")
    public UserInfo doLogin(@RequestBody LoginInfo loginInfo) {
        if (loginInfo.getUserName().equals("Olga")) {
            return UserInfo.builder()
                    .loginDate(new Date())
                    .userName(loginInfo.getUserName())
                    .build();
        } else {
            throw new InvalidUsernameException();
        }
    }

    @GetMapping("users/getAll")
    @ApiOperation("Получение всех юзеров")
    public List<UserInfo> getAllUsersInfo() {
        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        //List <UserInfo> result = new ArrayList<>();
        //for (Map.Entry<String, UserInfo> entry : users.entrySet()) {
        //result.add(entry.getValue());
        //}
        //return result;
    }
}
