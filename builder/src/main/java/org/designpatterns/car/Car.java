package org.designpatterns.car;

public class Car {

    private final Integer doors;
    private final Color color;
    private final Engine engine;

    public Car(Integer doors, Color color, Engine engine){
        this.doors = doors;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "doors=" + doors +
                ", color=" + color +
                ", engine=" + engine +
                '}';
    }

    public static CarBuilder getBuilder(){
        return new CarBuilder();
    }


    public static final class CarBuilder {
        private Integer doors;
        private Color color;
        private Engine engine;

        private CarBuilder(){}

        public CarBuilder withDoors(Integer doors){
            this.doors = doors;
            return this;
        }

        public CarBuilder withColor(Color color){
            this.color = color;
            return this;
        }

        public CarBuilder withEngine(Engine engine){
            this.engine = engine;
            return this;
        }

        public Car build(){
            return new Car(this.doors,this.color,this.engine);
        }
    }
}
