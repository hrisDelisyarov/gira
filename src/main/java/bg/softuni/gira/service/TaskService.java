package bg.softuni.gira.service;

import bg.softuni.gira.model.service.TaskServiceModel;
import bg.softuni.gira.model.service.UserServiceModel;

public interface TaskService {

void add(TaskServiceModel taskServiceModel, UserServiceModel userServiceModel);
}
