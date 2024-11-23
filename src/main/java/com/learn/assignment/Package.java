package com.learn.assignment;

import java.util.Objects;

class Package implements Comparable<Package>{
    String id;
    double weight;
    String city;

    public Package(String id, double weight, String city) {
        //System.out.println("------------In Package()--------------");
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
        //System.out.println("=========calling toString()=========");
        return "Package{id='" + id + "', weight=" + weight + ", city='" + city + "'}";
    }
    //why Override this
    @Override
    public boolean equals(Object obj) {
        //System.out.println("=========calling equals()=========");
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
        return id == pkg.id;
    }
    //why Override this
    @Override
    public int hashCode() {
        //System.out.println("=========calling hashCode()----------");
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Package otherPkg) {
        //System.out.println("+++++++++++++calling compareTo()+++++++++++++");
        return Double.compare(otherPkg.getWeight(),this.weight);//heavier packages should delivered first
    }
}

