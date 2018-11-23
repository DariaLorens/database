package com.bisenessmap.app.database.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Places")
public class Place {
    @Id
    private String id;
    private String name;
 //   @Indexed(name = "location_index", direction = )
    private Point location;
    private BisenessType bisenessType;
    private double rating;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int price;

    protected Place(){
    }

    public Place( String name, Point location, BisenessType bisenessType, double rating, int price){

        this.name = name;
        this.location = location;
        this.bisenessType = bisenessType;
        this.rating = rating;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getBisenessType() {
        return bisenessType.getName();
    }

    public void setBisenessType(BisenessType bisenessType) {
        this.bisenessType = bisenessType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Places{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", coordinate='" + location + '\'' +
                ", bisenessType='" + bisenessType + '\'' +
                ", rating='" + rating + '\'' +
                ", price=" + price +
                '}';
    }
}
