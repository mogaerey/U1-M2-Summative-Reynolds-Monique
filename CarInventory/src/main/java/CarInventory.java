
import java.util.*;
import java.util.Scanner;

public class CarInventory {

    Scanner scan = new Scanner(System.in);
    public String make, model, color;
    public int year, miles;

    public CarInventory(String make, String model, int year, String color, int miles) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.miles = miles;

    }

    public String toString() {
        return "Make:" + make + "    " + " Model:" + model + "   " + " Year:" + year + "   " + " Color:" + color +
                "   " + " Mileage:" + miles;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {

        this.make = make;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {

    }
}