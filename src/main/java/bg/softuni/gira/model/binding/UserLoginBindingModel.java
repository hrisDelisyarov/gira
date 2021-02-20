package bg.softuni.gira.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    @Email(message = "Enter a valid email")
    private String email;
    @Size(min = 3,max = 20,message = "Password must be between 3 and 20 characters")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public UserLoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
