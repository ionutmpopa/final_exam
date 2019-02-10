package com.iopo;

import java.util.Objects;

public class Package {

    private String targetLocation;
    private int kiloMeters;
    private int packageValue;
    private String deliveryDate;

    public Package(String targetLocation, int kiloMeters, int packageValue, String deliveryDate) {
        this.targetLocation = targetLocation;
        this.kiloMeters = kiloMeters;
        this.packageValue = packageValue;
        this.deliveryDate = deliveryDate;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    public int getKiloMeters() {
        return kiloMeters;
    }

    public void setKiloMeters(int kiloMeters) {
        this.kiloMeters = kiloMeters;
    }

    public int getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(int packageValue) {
        this.packageValue = packageValue;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Delivering for" + "<" + getTargetLocation() +">" + "and date <" + getDeliveryDate() + "> in <" + getKiloMeters() +"> seconds\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return kiloMeters == aPackage.kiloMeters &&
                packageValue == aPackage.packageValue &&
                Objects.equals(targetLocation, aPackage.targetLocation) &&
                Objects.equals(deliveryDate, aPackage.deliveryDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(targetLocation, kiloMeters, packageValue, deliveryDate);
    }
}
