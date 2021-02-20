package bg.softuni.gira.model.entity;

import bg.softuni.gira.model.entity.enums.ClassificationName;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private ClassificationName classificationName;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    public Classification() {
    }

    public Classification(ClassificationName classificationName, String description) {
        this.classificationName=classificationName;
        this.description=description;
    }

    public ClassificationName getClassificationName() {
        return classificationName;
    }

    public Classification setClassificationName(ClassificationName classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
