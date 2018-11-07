package com.bisenessmap.app.database;

import com.bisenessmap.app.database.entity.BisenessType;
import com.bisenessmap.app.database.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
    @Autowired
    private PlaceRepository placeRepository;

    public DbSeeder(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("######PLACES LIST AT BEGINNING######");
        System.out.println(placeRepository.findAll());
        System.out.println("###################################\n\n");

        // drop all places
        System.out.println("######NOW I DELETE ALL PLACES######\n\n");
        this.placeRepository.deleteAll();

        System.out.println("######ADDING 2 PLACES######");
        Place italia = new Place(
                "1",
                "Italia",
                "59.929715, 30.374329",
                new BisenessType("Cafe"),
                4,
                700
        );

        Place itmo = new Place(
                "2",
                "ITMO",
                "80.929715, 35.374329",
                new BisenessType("Univers"),
                2,
                1500
        );

     /*   List<Place> placesList = new ArrayList<>();
        placesList.add(italia2);
        placesList.add(itmo); */
        placeRepository.save(italia);
        placeRepository.save(itmo);

        System.out.println("######PLACES LIST AFTER ADDING######");
        System.out.println(placeRepository.findAll());
        System.out.println("###################################\n\n");    }

    }

