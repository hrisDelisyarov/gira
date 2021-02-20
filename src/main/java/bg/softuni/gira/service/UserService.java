package bg.softuni.gira.service;

import bg.softuni.gira.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByEmailAndPassword(String email, String password);
}
