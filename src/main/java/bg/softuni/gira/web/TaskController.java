package bg.softuni.gira.web;

import bg.softuni.gira.model.binding.AddTaskBindingModel;
import bg.softuni.gira.model.service.TaskServiceModel;
import bg.softuni.gira.model.service.UserServiceModel;
import bg.softuni.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tasks/")
public class TaskController {

    private final ModelMapper modelMapper;
    private final TaskService taskService;

    public TaskController(ModelMapper modelMapper, TaskService taskService){
        this.modelMapper = modelMapper;
        this.taskService = taskService;
    }
    @GetMapping("/add")
    public String add(HttpSession httpSession, Model model){
        if (httpSession.getAttribute("user")==null){
            return "redirect:/users/login";
        }
            if (!model.containsAttribute("addTaskBindingModel")){
                model.addAttribute("addTaskBindingModel",new AddTaskBindingModel());
            }
        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid AddTaskBindingModel addTaskBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes,
                             HttpSession httpSession){
            if (bindingResult.hasErrors()){
                redirectAttributes.addFlashAttribute("addTaskBindingModel",addTaskBindingModel);
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addTaskBindingModel", bindingResult);
                return "redirect:/tasks/add";
            }
            UserServiceModel userServiceModel=(UserServiceModel)httpSession.getAttribute("user");
                taskService.add(modelMapper.map(addTaskBindingModel, TaskServiceModel.class),userServiceModel);
            return "redirect:/";
    }
}
