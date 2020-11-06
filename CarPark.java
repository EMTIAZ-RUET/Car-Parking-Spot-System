/**
 * Project 1 . This class has ArrayList, objects , methods and variables. It
               maintains the Parking Slot List which includes Adding a slot, deletion
               of a slot, Parking a car, find a car, remove a car and print the slots.
               It has getters and setter methods.* 
 * @author     Fouad Nazir Ahmad    Saleemi  *
 * @version    11.0.6 , 27/04/2020                 
 */
import java.util.ArrayList;


public class CarPark {
       
 ArrayList<ParkingSlot> parkingSlotList = new ArrayList<>();   /** Declared an ArrayList that holds object of ParkingSlot class .*/

 
    
    
    
    
    public boolean isParkingSlotUnique(String identifier) /** @param It takes Parking SlotID as parameters.*/ /** It checks that Parking SlotID is unique and not repeated.*/  
        {
            boolean isUnique = true;    /** It stores boolean value which is initiallized*/ 
            for(ParkingSlot s : parkingSlotList)   /** A loop through the  ArrayList of ParkingSlot to access each object. */
                {
                    if(s.identifier.equals(identifier)) /** A condition to check that Parking SlotID is in the list or not. */
                        {
                            isUnique = false;  /** It stores new boolean value if the condition is true. */
                        }
               }
            return isUnique; /** @return It returns the current boolean value */
        }
 
    
    
    public boolean isCorrectType(String Type)   /** @param It takes Type as parameters which stores type of slot or car.*//** It checks whether the input type is correct or not.*/  
        {
            boolean correctType = true;  /** It stores boolean value which is initiallized*/ 
            if(!((Type.toUpperCase().equals("VISITOR")) || (Type.toUpperCase().equals("STAFFMEMBER"))) )  /** A condition to check that input type belongs to the legal type category or not. */
            {
                correctType = false;    /** It stores new boolean value if the condition is true. */
            }
            return correctType;  /** @return It returns the current boolean value */
        }
   
    
    public void addparkingSlot(String identifier,String parkingSlotType)  /** @param It takes Parking SlotID and its type as parameter.*//** It adds a Parking Slot in the ParkingSlort List.*/
       {
            if(isParkingSlotUnique(identifier) == false) /** A condition to check that isParkingSlotUnique() returns false. */
                {
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println(" Notification!!!                                                 ");
                    System.out.println( "Parking Slot Number already exists. Please enter another number.");                                                    
                    System.out.println("-----------------------------------------------------------------");
                   
                   
                }
            
            else if(isCorrectType(parkingSlotType) == false) /** A condition to check that isCorrectType() returns false. */
                { 
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println(" Notification!!!                                                 ");
                    System.out.println( " You have entered wrong Parking Slot Type.                      ");                                                    
                    System.out.println("-----------------------------------------------------------------");
                
                    
                }
            
            
            else  /** If above conditions are not true, then run below code. */
                {
                    ParkingSlot slot = new ParkingSlot(); /** It stores the object of the ParkingSlot class. */
                    String identifierNumber = identifier; /** It stores the Parking SlotID. */
                        if(identifierNumber.matches("[A-Z][0-9]{2}"))  /** A condition to check that Parking SlotID matches the regular expression or not . */
                            {
                               slot.identifier = identifier;  /** It assigns the Parking SlotID value.  */
                               slot.parkingSlotType = parkingSlotType;  /** It assigns the Parking Slot Type value.  */
                               slot.carParked = "No";   /** It assigns that Parking Slot is occupied or not.  */
                               parkingSlotList.add(slot);  /** It adds the object to the ArrayList of ParkingSlot.  */ 
                            }
                        else   /** If above conditions are not true, then run below code. */
                            {
                                System.out.println("-----------------------------------------------------------------");
                                System.out.println(" Notification!!!                                                 ");
                                System.out.println( " Please Enter the Parking Slot Number in Correct Format.        ");                                                    
                                System.out.println("-----------------------------------------------------------------");
                              
                            }
                }

        }
       
    
    
    
    
    public void printSlot()  /** It print out all the Parking Slots present in the ArrayList of ParkingSlot .*/
       {
            for(ParkingSlot s : parkingSlotList)   /** A loop through the  ArrayList of ParkingSlot to access each object. */
                {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("The Parking Slot Number is: " + s.identifier);   /** It displays Parking SlotID .*/
                    System.out.println("The Parking Slot Type is: " + s.parkingSlotType);  /** It displays Parking Slot Type .*/
                    System.out.println("A car is Parked in the Slot or Not: " + s.carParked);  /** It displays Parking Slot is occupied or not .*/
                        if(s.carParked.equals("Yes"))  /** A condition to check that car is parked in the Parking Slot. */
                           {
                                System.out.println("The Car Owner Name is: " + s.carOwnerName); /** It displays car owner name .*/
                                System.out.println("The Car Owner Type is: " + s.carOwnerType); /** It displays car owner type .*/
                                System.out.println("The Car Registration Number is: " + s.caRregistrationNumber); /** It displays car registration number .*/
                           }
                    System.out.println("--------------------------------------------------------");

                }
       }
    
    
   
    
    
    public void findCar(String carRegistrationNumber) /** @param It takes car registration number as parameter.*/ /**   It find a car in the Parking Slot List.*/
        {
            for(ParkingSlot s : parkingSlotList)  /** A loop through the  ArrayList of ParkingSlot to access each object. */
                {
                    if(s.caRregistrationNumber.equals(carRegistrationNumber))  /** A condition to check that the input car registration number is present in the  Parking Slot List. */
                       {
                           System.out.println("--------------------------------------------------------");
                           System.out.println("The Parking Slot Number is: " + s.identifier);  /** It displays Parking SlotID .*/
                           System.out.println("The Parking Slot Type is: " + s.parkingSlotType); /** It displays Parking Slot Type .*/
                           System.out.println("The Car Owner Type is:  " + s.carOwnerType);   /** It displays car owner type .*/
                           System.out.println("The Car Owner Name is: " + s.carOwnerName);   /** It displays car owner name .*/
                           System.out.println("--------------------------------------------------------");

                       }
                    

                }
        }
    
    
    
    public void removeCar(String carRegistrationNumber) /** @param It takes car registration number as parameter.*/ /**  It removes a car in the Parking Slot List.*/
        {
            for(ParkingSlot s : parkingSlotList)  /** A loop through the  ArrayList of ParkingSlot to access each object. */
                {
                    if(s.caRregistrationNumber.equals(carRegistrationNumber))  /** A condition to check that the input car registration number is present in the  Parking Slot List. */
                        {
                            s.carParked = "No"; /** It assigns the Parking Slot occupied value.  */
                            s.caRregistrationNumber = "None";  /** It assigns the car registration number value.  */
                            s.carOwnerName = "None"; /** It assigns the car owner  value.  */
                            s.carOwnerType = "None";  /** It assigns the car owner type value.  */

                        }
                    

                }
        }
    
    
    public boolean isCarParked(String carRegistrationNumber)   /** @param It takes car registration number as parameter.*//** It checks whether the car is parked in the Parking Slot or not.*/
        {
            boolean isParkedInOne = true;  /** It stores boolean value which is initiallized*/ 
                for(ParkingSlot s : parkingSlotList)  /** A loop through the  ArrayList of ParkingSlot to access each object. */
                    {
                        String carRegistrationNumber2 = carRegistrationNumber;  /** It stores car registration number.*/ 
                           if(s.caRregistrationNumber.equals(carRegistrationNumber2)) /** A condition to check that car is present in the Parking Slot. */
                                {
                                    isParkedInOne = false;  /** It stores new boolean value if the condition is true. */
                                }
                    }
            return isParkedInOne;   /** @return: It returns the current boolean value */
        }
    
    
    public void addCar(String slotID, String carOwnerName, String carRegistrationNumber, String carOwnerType ) /** @param: It takes car registration number, Parking SlotID, car owner name and car owner type as parameter.*//** It parks the car in the Parking Slot or not.*/
            {
             
                for(ParkingSlot s : parkingSlotList)  /** A loop through the  ArrayList of ParkingSlot to access each object. */
                {
                        String carRegistrationNumber1 = carRegistrationNumber;  /** It stores car registration number.*/ 
                        String carOwnerType1 = carOwnerType;  /** It stores car owner type.*/ 
                        
                       

                            if(s.identifier.equals(slotID)) /** A condition to check that the input car registration number is present in the  Parking Slot List. */
                                {
                                    
                                    if(!carRegistrationNumber1.matches("[A-Z][0-9]{4}"))  /** A condition to check that the input car registration number is not match the pattern. */
                                        {
                                            System.out.println("-----------------------------------------------------------------");
                                            System.out.println(" Notification!!!                                                 ");
                                            System.out.println( "Please Enter Car Registration Number in Correct Format.         ");                                                    
                                            System.out.println("-----------------------------------------------------------------");
                                
                                            
                                        }



                                   else if (!carOwnerType1.equals(s.parkingSlotType)) /** If above conditions are not true, then run below code and check condition that the input car owner type is not present in the Parking Slot List*/
                                        {
                                            System.out.println("--------------------------------------------------------------------------------------------------------------");
                                            System.out.println(" Notification!!!                                                                                              ");
                                            System.out.println("Parking Slot is for "+ s.parkingSlotType +"."+ "You are a "+ carOwnerType1 + "." + "Please write correctly or select Correct Type.");                                                    
                                            System.out.println("--------------------------------------------------------------------------------------------------------------");
                                           
                                           
                                        }

                                   else if(isCarParked(carRegistrationNumber1) == false) /** If above conditions are not true, then run below code and check condition that  if car is parked in the Parking Slot List.*/
                                        {
                                            System.out.println("-----------------------------------------------------------------");
                                            System.out.println(" Notification!!!                                                 ");
                                            System.out.println( "Car is already parked in another slot.                          ");                                                    
                                            System.out.println("-----------------------------------------------------------------");
                                           
                                           
                                        }

                                  
                                   else /** If above conditions are not true, then run below code */

                                        {
                                            s.carParked = "Yes"; /** It assigns the occupied or not value.  */
                                            s.carOwnerName = carOwnerName; /** It assigns the car owner name value.  */
                                            s.caRregistrationNumber = carRegistrationNumber;  /** It assigns the car registration number value.  */
                                            s.carOwnerType = carOwnerType;  /** It assigns the car owner type value.  */
                                        }

                           }
                }
                    
                  

            }
        
            
    
    
    
     public void deleteSlotHelper(ParkingSlot parkingSlot) /** @param It takes Parking SlotID as parameter.*/ /** It deletes the object of the Parking Slot from List*/
        {
            parkingSlotList.remove(parkingSlot); /** Pass the object to the deletion method of the Parking Slot class. */
        }
    
    public void deleteSlot(String slotID) /** @param: It takes car registration number as parameter.*//** It deletes the Parking Slot from the List.*/
        {
              
            ParkingSlot parkingSlot = new ParkingSlot(); /** It stores the object of the ParkingSlot class. */
            
            for(ParkingSlot s : parkingSlotList )  /** A loop through the  ArrayList of ParkingSlot to access each object. */
                
                {
                    if(s.identifier.equals(slotID) && s.carParked.equals("No") )   /** A condition to check that car registration number is present in the Parking Slot List and Parking Slot is not occupied. */
                        { 
                            parkingSlot = s; /** It assigns the object of the ParkingSlot class. */
                        }
                    
                    
                    
                   
                    
                   
                }
            deleteSlotHelper(parkingSlot);  /** Pass the object to the method of deleteSlot. */
                 
       }
}
