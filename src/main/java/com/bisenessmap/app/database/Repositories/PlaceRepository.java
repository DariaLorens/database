package com.bisenessmap.app.database.Repositories;


import com.bisenessmap.app.database.entity.Place;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlaceRepository extends MongoRepository<Place, String> {
List<Place> findByLocationNear(Point location, Distance distance);
}
