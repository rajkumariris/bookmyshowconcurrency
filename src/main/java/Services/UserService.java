package Services;

import Exceptions.UserException;
import Models.User;
import Repositories.UserRepository;

import java.util.Optional;

public class UserService {
     private UserRepository userRepository;

     public UserService(UserRepository userRepository){
         this.userRepository = userRepository;
     }
    public  User login(String email, String password)
    {
         Optional<User> optionalUser =  userRepository.findByEmailId(email);
         if(optionalUser.isEmpty())
         {
             //throw new UserException("User is not Found SignUp");
             SignUp(email, password);
         }
           User user = optionalUser.get();
           String userpassword = user.getPassword();

           if(password.equals(userpassword)){
               return user;
           }
          throw new UserException("password is incorrect ");
    }


    public User SignUp(String email, String password){
         return null;
    }
}
