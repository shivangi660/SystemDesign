/*
Builder Pattern demo
1. This comprises of a static class Vehichle for which the constructor will be private
2. This class vehichle will be built inside the builder class whose constructor will be public. This will comprise of all the mandatory fields
3. for the fields which are not mandatory, we will have setters available for the same.

Points to Remember:
1. Set the constructor of the Vehichle class as Private.
2. Set all the parameters (not only the required paraetrs) in the constructor of the vehichle class taking values from the builder class.
 */


class Vehicle{
    // required parameters
    private int noOfTyres;
    private String vehicleName;

    // optional parameters
    private int airbags;
    private String brakes;

    private Vehicle(VehicleBuilder builder){
        this.noOfTyres = builder.noOfTyres;
        this.vehicleName = builder.vehicleName;
        this.airbags = builder.airbags;
        this.brakes = builder.brakes;
    }

    public int getAirbags() {
        return this.airbags;
    }

    public String getBrakes() {
        return this.brakes;
    }

    public static class VehicleBuilder {
        private int noOfTyres;
        private String vehicleName;

        private int airbags;
        private String brakes;

        public VehicleBuilder(int noOfTyres, String vehichleName) {
            this.noOfTyres = noOfTyres;
            this.vehicleName = vehicleName;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public VehicleBuilder setBrakes(String brakes) {
            this.brakes = brakes;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

class BuilderPatternExample {
        public static void main(String[] args) {
            Vehicle car = new Vehicle.VehicleBuilder(4, "Car").setAirbags(2).setBrakes("Simple").build();
            Vehicle bike = new Vehicle.VehicleBuilder(2,"bike").setAirbags(0).setBrakes("ABR").build();

            System.out.println("Car Vehichle : " + car.getAirbags());
            System.out.println("Bike Vehichle : " + bike.getBrakes());
        }
}