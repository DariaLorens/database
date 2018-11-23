package com.bisenessmap.app.database;

import com.bisenessmap.app.database.Repositories.BisenessTypeRepository;
import com.bisenessmap.app.database.Repositories.PlaceRepository;
import com.bisenessmap.app.database.entity.BisenessType;
import com.bisenessmap.app.database.entity.Place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private BisenessTypeRepository bisenessTypeRepository;

    public DbSeeder(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.bisenessTypeRepository = bisenessTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

     /*   System.out.println("######PLACES LIST AT BEGINNING######");
        System.out.println(placeRepository.findAll());
        System.out.println("###################################\n\n");

        // drop all places
        System.out.println("######NOW I DELETE ALL PLACES######\n\n");
        this.placeRepository.deleteAll(); */

        System.out.println("######ADDING 2 PLACES######");

        Place i5 = new Place(
                "Friends Time",
                new Point(59.935939, 30.359860),
                new BisenessType("Karaoke"),
                5,
                1000
                );

      //  List<Place> placesList = new ArrayList<>();
     //   placesList.add(i5);
     //   placeRepository.saveAll(placesList);

//        System.out.println(Querys.getOnly(placeRepository, bisenessTypeRepository));

        List<BisenessType> bisenessTypes = bisenessTypeRepository.findAll();

        System.out.println("######PLACES LIST AFTER ADDING######");
        System.out.println(Querys.getOnly(placeRepository, bisenessTypeRepository));
        System.out.println("###################################\n\n");
    }

    }

