package com.sda.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.frontend.UserInterface;
import com.sda.weather.localization.LocalizationController;
import com.sda.weather.localization.LocalizationRepository;
import com.sda.weather.localization.LocalizationService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Application {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        LocalizationRepository localizationRepository = new LocalizationRepository(sessionFactory);
        LocalizationService localizationService = new LocalizationService(localizationRepository);
        LocalizationController localizationController = new LocalizationController(localizationService, objectMapper);


        UserInterface userInterface = new UserInterface(localizationController);
        userInterface.run();

    }
}
