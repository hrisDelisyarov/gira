package bg.softuni.gira.service.serviceImpl;

import bg.softuni.gira.model.entity.Task;
import bg.softuni.gira.model.entity.enums.Progress;
import bg.softuni.gira.model.service.TaskServiceModel;
import bg.softuni.gira.model.service.UserServiceModel;
import bg.softuni.gira.repository.TaskRepository;
import bg.softuni.gira.service.ClassificationService;
import bg.softuni.gira.service.TaskService;
import bg.softuni.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final ClassificationService classificationService;
    private final UserService userService;

    public TaskServiceImpl(ModelMapper modelMapper, TaskRepository taskRepository,
                           ClassificationService classificationService, UserService userService){

        this.modelMapper = modelMapper;
        this.taskRepository = taskRepository;
        this.classificationService = classificationService;
        this.userService = userService;
    }

    @Override
    public void add(TaskServiceModel taskServiceModel, UserServiceModel userServiceModel) {
        Task task = modelMapper.map(taskServiceModel,Task.class)
                .setClassification
                        (classificationService.findByClassificationName
                                (taskServiceModel.getClassification()))
                .setUser(userService.findByEmail(userServiceModel.getEmail()))
                .setProgress(Progress.OPEN);

        taskRepository.save(task);
    }
}
