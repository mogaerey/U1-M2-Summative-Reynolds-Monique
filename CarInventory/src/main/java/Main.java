import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<CarInventory> cars = new ArrayList<CarInventory>();
        char choice = 'Y';
        String make, model, color;
        int year, miles, selection;

        System.out.println("Please enter the vehicle information to start your vehicle inventory!:");

        while (choice == 'Y') {
            System.out.print("Make:");
            make = scan.next();

            System.out.print("Model:");
            model = scan.next();

            System.out.print("Year:");
            year = scan.nextInt();
            while (year <= 1950 || year > 2020) {
                System.out.println("Your entry is invalid. Please enter a year between 1950 - 2019");
                System.out.print("Year:");
                year = scan.nextInt();
            }

            System.out.print("Color:");
            color = scan.next();

            System.out.print("Mileage:");
            miles = scan.nextInt();
            while (miles < 0 || miles > 9999999){
                System.out.println("Your entry is invalid. Please re-enter your mileage between 1 - 9999999");
                System.out.print("Mileage:");
                miles = scan.nextInt();
            }

            cars.add(new CarInventory(make, model, year, color, miles));
            System.out.println(" ");

            System.out.print("Enter Another Record? (Y/N)");
            String word = scan.next();
            word = word.toUpperCase();
            choice = word.charAt(0);
        }


        while (choice == 'N') {
            System.out.println(" ");
            System.out.println("What would you like to do next?");
            System.out.println(" ");
            System.out.println("Select: 1)Delete last vehicle  2)List all cars 3)Perform search 4)quit");
            selection = scan.nextInt();
            if (selection == 1) {
                if (cars.size() > 0)
                    cars.remove(cars.size() - 1);
                for (CarInventory input : cars)
                    System.out.println(input);
            } else if (selection == 2) {
                for (CarInventory input : cars)
                    System.out.println(input);
            } else if (selection == 3) {
                System.out.println("Enter the number to search by: 1)Make 2)Model 3)Year 4)Color  " +
                        "5)Miles");
                int select1 = scan.nextInt();

                switch (select1) {
                    case 1:
                        System.out.println("Enter the make:");
                        doMakeSearch(cars);
                        break;
                    case 2:
                        System.out.println("Enter the model:");
                        doModelSearch(cars);
                        break;
                    case 3:
                        System.out.println("Enter the year:");
                        doYearSearch(cars);
                        break;
                    case 4:
                        System.out.println("Enter the color:");
                        doColorSearch(cars);
                        break;
                    case 5:
                        System.out.println("Enter the maximum mileage limit:");
                        doMilesSearch(cars);
                        break;
                }
            }else if(selection == 4){
                System.out.println("Thank you! Goodbye!");
                return;
            }
        }
    }

    private static void doMakeSearch( ArrayList<CarInventory> cars){
        Scanner scan = new Scanner(System.in);
        String search1 = scan.next();
        for (CarInventory input : cars) {
            if (input.getMake().equalsIgnoreCase(search1)) {
                System.out.println(" ");
                System.out.println(input);
            }
        }

    }
    private static void doModelSearch( ArrayList<CarInventory> cars){
        Scanner scan = new Scanner(System.in);
        String search2 = scan.next();
        for (CarInventory input : cars) {
            if (input.getModel().equalsIgnoreCase(search2)) {
                System.out.println(" ");
                System.out.println(input);
            }
        }

    }
    private static void doYearSearch( ArrayList<CarInventory> cars){
        Scanner scan = new Scanner(System.in);
        int search3 = scan.nextInt();
        for (CarInventory input : cars) {
            if (input.getYear()== search3) {
                System.out.println(" ");
                System.out.println(input);
            }
        }

    }
    private static void doColorSearch( ArrayList<CarInventory> cars){
        Scanner scan = new Scanner(System.in);
        String search4 = scan.next();
        for (CarInventory input : cars) {
            if (input.getColor().equalsIgnoreCase(search4)) {
                System.out.println(" ");
                System.out.println(input);
            }
        }

    }

    private static void doMilesSearch( ArrayList<CarInventory> cars){
        Scanner scan = new Scanner(System.in);
        int search5 = scan.nextInt();
        for (CarInventory input : cars) {
            if (input.getMiles()<= search5) {
                System.out.println(" ");
                System.out.println(input);
            }
        }

    }
}