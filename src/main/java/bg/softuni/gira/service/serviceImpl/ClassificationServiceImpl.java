package bg.softuni.gira.service.serviceImpl;

import bg.softuni.gira.model.entity.Classification;
import bg.softuni.gira.model.entity.enums.ClassificationName;
import bg.softuni.gira.repository.ClassificationRepository;
import bg.softuni.gira.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public  ClassificationServiceImpl(ClassificationRepository classificationRepository){

        this.classificationRepository = classificationRepository;
    }
    @Override
    public void initClassifications() {
        if (classificationRepository.count()==0){
            Arrays.stream(ClassificationName.values())
                    .forEach(classificationName -> {
                        Classification classification = new Classification
                                (classificationName,"Description for "+classificationName.name());
                        classificationRepository.save(classification);
                    });
        }
    }
}
