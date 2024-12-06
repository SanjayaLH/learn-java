package com.learn.assignment;

import java.util.Objects;

class Package implements Comparable<Package> {
    String id;
    double weight;
    String city;

    public Package(String id, double weight, String city) {
        this.id = id;
        this.weight = weight;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Package{id='" + id + "', weight=" + weight + ", city='" + city + "'}";
    }

    //why Override this
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Package pkg = (Package) obj;
        return Objects.equals(id, pkg.id);
    }

    //why Override this
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * @param otherPkg package object which need to compare the weight
     * @return heavier packages should delivered first
     */
    @Override
    public int compareTo(Package otherPkg) {
        return Double.compare(otherPkg.getWeight(), this.weight);
    }
}