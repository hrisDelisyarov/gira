package bg.softuni.gira.model.binding;

import bg.softuni.gira.model.entity.enums.ClassificationName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AddTaskBindingModel {
    @Size(min = 3,max = 20,message = "Name must be between 3 and 20 characters")
    //@NotBlank(message = "Name must be between 3 and 20 characters")
    private String name;
    @Size(min = 5,message = "Description must be at least 5 characters")
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    private LocalDate dueDate;
    @NotNull
    private ClassificationName classification;

    public AddTaskBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AddTaskBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddTaskBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public AddTaskBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationName getClassification() {
        return classification;
    }

    public AddTaskBindingModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }
}
