/**
 * Project 1 . The project is to do coding for a Parking Spot System. A system that 
               can take input from customer and manage the parking for them.
               This class handles the input and output from the console. It
               provides a text-based interface for customers.
               It calls different methods and provide options to choose.* 
 * @author     Fouad Nazir Ahmad    Saleemi *
 * @version    11.0.6 , 27/04/2020                 
 */
import java.util.Scanner;

public class Application {
    public static void main(String[] args)
    {
     
        CarPark carPark = new CarPark();  /** It stores the object of the CarPark class. */
        ParkingSlot parkingSlot = new ParkingSlot(); /** It stores the object of the ParkingSlot class. */
        Car car = new Car();  /** It stores the object of the Car class. */
        int count = 0;  /** It stores zero value. */
        String userInput;  /** It stores user input. */
        
        do{  /** A loop through the options */
            System.out.println("+---------------------------------+");
            System.out.println("|        Welcome to the           |");
            System.out.println("|         Car Parking             |");
            System.out.println("+---------------------------------+");
            Scanner scanner = new Scanner(System.in);  /** It stores the object of the Scanner Class. */
            System.out.println("Pleas select an option: \n" + "\n 0 Add a Parking Slot. " + " \n 1 Delete a Parking Slot. "  + " \n 2 Print. " 
                            + " \n 3 Park a Car." + " \n 4 Find a Car." + " \n 5 Remove a Car." + " \n 6 Exit."); /** It displays options. */
            
            userInput = scanner.nextLine(); /** It stores user input. */
                 
            switch(userInput) /** It passes user input. */
            {

                case "0":  
                    System.out.println("Please Enter a Parking SlotID like D21, F32:"); /** It displays message. */
                    parkingSlot.identifier  = scanner.nextLine(); /** It stores Parking SlotID. */
                    System.out.println("Please Enter Slot Type like Visitor or Staffmember:");  /** It displays message. */
                    parkingSlot.parkingSlotType = scanner.nextLine(); /** It stores Parking Slot Type. */
                    carPark.addparkingSlot( parkingSlot.identifier, parkingSlot.parkingSlotType); /** It invokes addparkingSlot method . */
                   
                    break;

                case "1":
                    System.out.println("Please Enter a Parking SlotID like D21, F32"); /** It displays message. */
                    parkingSlot.identifier  = scanner.nextLine(); /** It stores Parking SlotID. */
                    carPark.deleteSlot(parkingSlot.identifier);  /** It invokes deleteSlot method . */
           
                    break;

                case "2":
                    carPark.printSlot(); /** It invokes printSlot method . */
                    break;

                case "3":
                    System.out.println("Please Enter a Parking SlotID like D21, F32:"); /** It displays message. */
                    String slotID = scanner.nextLine(); /** It stores Parking SlotID. */
                    System.out.println("Please Enter Car Owner Name like John:"); /** It displays message. */
                    car.carOwnerName = scanner.nextLine(); /** It stores car owner name. */
                    System.out.println("Please Enter Car Registration Number like T2345, G1122:"); /** It displays message. */
                    car.registrationNumber = scanner.nextLine(); /** It stores car registration number. */
                    System.out.println("Are you a visitor or staffmember:"); /** It displays message. */
                    car.carOwnerType = scanner.nextLine(); /** It stores car owner type. */
                    carPark.addCar(slotID, car.carOwnerName, car.registrationNumber, car.carOwnerType); /** It invokes addCar method . */
                    
                    break;

                case "4":
                    System.out.println("Please Enter Car Registration Number like T2345, G1122:"); /** It displays message. */
                    car.registrationNumber = scanner.nextLine();  /** It stores car registration number. */
                    carPark.findCar(car.registrationNumber);  /** It invokes findCar method . */

                    break;

                case "5":
                    System.out.println("Please Enter Car Registration Number like T2345, G1122:"); /** It displays message. */
                    car.registrationNumber = scanner.nextLine(); /** It stores car registration number. */
                    carPark.removeCar(car.registrationNumber); /** It invokes removeCar method . */
                   
                    break;

                case "6":
                    count = 1; /** It stores value one. */
                    break;

                default: /** It displays default message. */
                    System.out.println("--------------------------------------------------------");
                    System.out.println("                    Notification!!!                     ");
                    System.out.println("          Please choose an option from 0 - 6"            );
                    System.out.println("--------------------------------------------------------");
            }
        } while(count == 0);  /** A condition which breaks loop when count i s0 . */
    
    System.out.println("+---------------------------------+");  /** It displays message while exit. */
    System.out.println("|        You Exit from the        |");
    System.out.println("|          Car Parking            |");
    System.out.println("+---------------------------------+");
    }
}
