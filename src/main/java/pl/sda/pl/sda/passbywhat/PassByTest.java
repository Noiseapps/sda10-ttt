package pl.sda.pl.sda.passbywhat;


/**
 * Więcej info na:
 * https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
 */
public class PassByTest {




    static class Car {
        String name;
        public Car(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("Opel");
        Car car2 = new Car("Opel");
        System.out.println(car1);
        System.out.println(car2);

        System.out.println();

        alterCar(car1);
        System.out.println(car1);
        overwriteCar(car2);
        System.out.println(car2);
    }

    static void alterCar(Car car) {
        car.setName("Audi");
    }

    static void overwriteCar(Car car) {
        car = new Car("Audi");
    }
}
