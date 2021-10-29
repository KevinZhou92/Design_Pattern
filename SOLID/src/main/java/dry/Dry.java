package dry;


import com.sun.tools.javac.util.StringUtils;


public class UserService {
    private UserRepo userRepo;// DI

    public User login(String email, String password) {
        if (!EmailValidation.validate(email)) {
            // ... throw InvalidEmailException...
        }
        if (!PasswordValidation.validate(password)) {
            // ... throw InvalidPasswordException...
        }
        User user = userRepo.getUserByEmail(email);
        if (user == null || !password.equals(user.getPassword()) {
            // ... throw AuthenticationFailureException...
        }
        return user;
    }
}

public class UserRepo {
    public boolean checkIfUserExisted(String email, String password) {
        //...query db to check if email&password exists
    }

    public User getUserByEmail(String email) {
        //...query db to get user by email...
    }
}}

