package com.bisenessmap.app.database;

import com.bisenessmap.app.database.Repositories.BisenessTypeRepository;
import com.bisenessmap.app.database.Repositories.PlaceRepository;
import com.bisenessmap.app.database.entity.BisenessType;
import com.bisenessmap.app.database.entity.Place;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import java.util.List;

public class Querys {


    public static List<Place> getOnlyNeed(PlaceRepository placeRepository, double x, double y, int km) {
        Point point = new Point(59.932229, 30.330791);
        Distance distance = new Distance(1, Metrics.KILOMETERS);
        List<Place> places = placeRepository.findByLocationNear(point, distance);
        return places;

    }

    public static String getOnly(PlaceRepository placeRepository, BisenessTypeRepository bisenessTypeRepository//, double x, double y, int km
    ) {
        String rez = "";
        int col = 0;
        double reit = 0;
        double price = 0;
        Point point = new Point(59.932229, 30.330791);
        Distance distance = new Distance(50, Metrics.KILOMETERS);
        List<Place> places = placeRepository.findByLocationNear(point, distance);
        List<BisenessType> bisenessTypes = bisenessTypeRepository.findAll();

        for (int i = 0; i < bisenessTypes.size(); i++ ){
            String type = bisenessTypes.get(i).getName();
            for (int y = 0; y < places.size(); y++ ){
                String place = places.get(y).getBisenessType();
                if (type.equals(place)) {
                    col = col + 1;
                    reit = reit + places.get(y).getRating();
                    price = price + places.get(y).getPrice();
                }
            }
            rez = rez + "[" + type + " col:" + col + " reit:" + reit/col + " price:" + price/col + "] ";
            col = 0;
            reit = 0;
            price = 0;
        }
        rez = rez + places.toString();

        return rez;
    }
}
