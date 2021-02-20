package bg.softuni.gira.service.serviceImpl;

import bg.softuni.gira.model.entity.User;
import bg.softuni.gira.model.service.UserServiceModel;
import bg.softuni.gira.repository.UserRepository;
import bg.softuni.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper){

        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void register(UserServiceModel userServiceModel) {
userRepository.save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByEmailAndPassword(String email, String password) {

    return userRepository.findByEmailAndPassword(email,password)
            .map(user -> modelMapper.map(user,UserServiceModel.class)).orElse(null);

    }
}
