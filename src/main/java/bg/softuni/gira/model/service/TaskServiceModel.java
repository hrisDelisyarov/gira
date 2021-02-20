package bg.softuni.gira.model.service;

import bg.softuni.gira.model.entity.Classification;
import bg.softuni.gira.model.entity.User;
import bg.softuni.gira.model.entity.enums.ClassificationName;
import bg.softuni.gira.model.entity.enums.Progress;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class TaskServiceModel {
    private String name;
    private String description;
    private Progress progress;
    private LocalDate dueDate;
    private ClassificationName classification;
    private User user;


    public TaskServiceModel() {
    }

    public String getName() {
        return name;
    }

    public TaskServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Progress getProgress() {
        return progress;
    }

    public TaskServiceModel setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationName getClassification() {
        return classification;
    }

    public TaskServiceModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }
}
