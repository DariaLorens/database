package com.bisenessmap.app.database;


import com.bisenessmap.app.database.entity.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaceRepository extends MongoRepository<Place, String> {
}
