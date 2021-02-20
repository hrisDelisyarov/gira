package bg.softuni.gira.web;

import bg.softuni.gira.model.binding.UserLoginBindingModel;
import bg.softuni.gira.model.binding.UserRegisterBindingModel;
import bg.softuni.gira.model.service.UserServiceModel;
import bg.softuni.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users/")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper){

        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/login")
    public String login(Model model){
        if (!model.containsAttribute("userLoginBindingModel")){
            model.addAttribute("userLoginBindingModel",new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }


        return "login";
    }
    @PostMapping("/login")
    public String confirmLogin(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:/users/login";
        }
            UserServiceModel userServiceModel=userService
                    .findByEmailAndPassword(userLoginBindingModel.getEmail(),userLoginBindingModel.getPassword());
        if (userServiceModel==null){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";

        }
        httpSession.setAttribute("user",userServiceModel);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model){
        if (!model.containsAttribute("userRegisterBindingModel")){
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){
                if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                        .equals(userRegisterBindingModel.getConfirmPassword())){
                    redirectAttributes.addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
                    redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",bindingResult);
                    return "redirect:/users/register";
                }
                userService.register(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:/users/login";
    }
}
