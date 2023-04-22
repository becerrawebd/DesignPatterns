package org.designpatterns.car;

public class Engine {

    private Integer cylinders;

    private Boolean turbo;

    public Engine(Integer cylinders, Boolean turbo) {
        this.cylinders = cylinders;
        this.turbo = turbo;
    }

    public Integer getCylinders() {
        return cylinders;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public Boolean getTurbo() {
        return turbo;
    }

    public void setTurbo(Boolean turbo) {
        this.turbo = turbo;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "cylinders=" + cylinders +
                ", turbo=" + turbo +
                '}';
    }
}
