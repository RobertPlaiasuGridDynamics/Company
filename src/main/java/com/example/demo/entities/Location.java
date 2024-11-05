package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String region;
    @OneToMany
    private Set<Employee> employees;

    protected Location() {
    }

    public Location(String city, String region) {
        this.city = city;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        return Objects.equals(id, location.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
