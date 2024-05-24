package Controllers;

import DTOs.ResponseStatus;
import DTOs.SignUpRequestDto;
import DTOs.SignUpResponseDto;
import Models.User;
import Services.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto){

        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try{
            User user = userService.login(signUpRequestDto.getEmail(),signUpRequestDto.getPassword());
            signUpResponseDto.setResponseStatus(ResponseStatus.LOGGEDIN);
            signUpResponseDto.setUserId(user.getId());
        }
        catch(Exception exception){
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILED);
        }
        return signUpResponseDto;
    }
}
