package bg.softuni.gira.init;

import bg.softuni.gira.service.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitialization implements CommandLineRunner {
    private final ClassificationService classificationService;

    public DatabaseInitialization(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {
        classificationService.initClassifications();
    }
}
