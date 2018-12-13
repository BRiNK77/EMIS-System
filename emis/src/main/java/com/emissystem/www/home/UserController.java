package com.emissystem.www.home;

import com.emissystem.www.home.model.User;
import org.mindrot.jbcrypt.*;
import static com.emissystem.www.home.EmisMain.userDao;

public class UserController {

    // Authenticate the user by hashing the inputted password using the stored salt,
    // then comparing the generated hashed password to the stored hashed password
    public static boolean authenticate(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }
        User user = userDao.getUserByUsername(email);
        if (user == null) {
            return false;
        }
        String hashedPassword = BCrypt.hashpw(password, user.getSALT());
        return hashedPassword.equals(BCrypt.hashpw(user.getPASS(), user.getSALT()));
    }

    public static void setPassword(String username, String oldPassword, String newPassword) {
        if (authenticate(username, oldPassword)) {
            String newSalt = BCrypt.gensalt();
            String newHashedPassword = BCrypt.hashpw(newSalt, newPassword);
            // Update the user salt and password
        }
    }
}
