package bg.softuni.gira.service;

import bg.softuni.gira.model.entity.Classification;
import bg.softuni.gira.model.entity.enums.ClassificationName;

public interface ClassificationService {

    void initClassifications();

    Classification findByClassificationName(ClassificationName classification);
}
