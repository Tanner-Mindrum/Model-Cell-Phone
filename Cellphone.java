package edu.project3;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Cellphone {

    public static void main(String[] args) {
        //Variables used throughout entire program
        String selection = "";
        String name = "";
        String phoneNumber = "";
        String emailAddress = "";
        String notes = "";
        Scanner in = new Scanner(System.in);
        boolean running = true;
        Phonebook phoneBook = new Phonebook();
        CallLog callLog = new CallLog();

        while (running) {
            /* The main menu of our cell phone, it gives the user the option
             *to access the phone book, make a call, receive a call, and access
             *the call log
             */
            System.out.println("Cellphone Menu");
            System.out.println("1. Access Phonebook");
            System.out.println("2. Make a Call");
            System.out.println("3. Receive a Call");
            System.out.println("4. Access Call Log");
            System.out.println("5. Quit");
            System.out.println("Enter a number to select a function: ");

            selection = in.nextLine().trim();


            //The user accesses the phone book if they input 1
            if (selection.equals("1")){
                System.out.println();
                boolean runningPhonebook = true;
                //Phonebook phoneBook = new Phonebook();


                while (runningPhonebook) {
                    //Phonebook sub-menu allows the user to add,
                    // modify, delete, display all contacts and favorites
                    System.out.println("Phonebook Sub-Menu");
                    System.out.println("1. Add Contact/Add Favorite");
                    System.out.println("2. Modify Contact");
                    System.out.println("3. Delete Contact");
                    System.out.println("4. Display Contact");
                    System.out.println("5. Display All Contacts");
                    System.out.println("6. Remove Favorite");
                    System.out.println("7. Display Favorite");
                    System.out.println("8. Rearrange Favorites");
                    System.out.println("9. Display All Favorites");
                    System.out.println("10. Exit phone book\n");
                    System.out.println("Enter a number to select an option: ");

                    selection = in.nextLine().trim();

                    //Add Contact/Add Favorite
                    if (selection.equals("1")) {
                        System.out.println();
                        Contact contactInfo = new Contact();

                        //Set contact info
                        System.out.println("Enter name: ");
                        name = in.nextLine().trim();
                        contactInfo.setName(name);

                        System.out.println("Enter Phone Number: ");
                        phoneNumber = in.nextLine().trim();
                        contactInfo.setPhoneNum(phoneNumber);

                        System.out.println("Enter Email Address: ");
                        emailAddress = in.nextLine().trim();
                        contactInfo.setEmail(emailAddress);

                        System.out.println("Enter Notes: ");
                        notes = in.nextLine().trim();
                        contactInfo.setNotes(notes);

                        //Add Favorite
                        System.out.println("Do you want to make this contact a favorite?\nTo add as favorite, enter \"y\", otherwise enter any other key: ");
                        selection = in.nextLine().trim();
                        if (selection.toLowerCase().equals("y")) {
                            phoneBook.addFavorite(contactInfo);
                        }


                        //Always add contact to Contacts arraylist in Phonebook class regardless of if it's a favorite
                        //or not
                        phoneBook.addContact(contactInfo);

                    }

                    //Modify Contact
                    else if (selection.equals("2")) {
                        boolean runningModify = true;
                        Contact catchCreateNewContact3 = new Contact();
                        while(runningModify){
                            //Prompts the user to add a contact they want to modify by name
                            System.out.println("Enter the name of the contact you want to modify: ");
                            String modifyName = in.nextLine().trim();
                            try{
                                int index = phoneBook.searchContact(modifyName);
                                if (index>-1) {
                                    Contact modifyInfo = new Contact();

                                    //Reset contact info
                                    System.out.println("Enter name: ");
                                    name = in.nextLine().trim();
                                    modifyInfo.setName(name);

                                    System.out.println("Enter Phone Number: ");
                                    phoneNumber = in.nextLine().trim();
                                    modifyInfo.setPhoneNum(phoneNumber);

                                    System.out.println("Enter Email Address: ");
                                    emailAddress = in.nextLine().trim();
                                    modifyInfo.setEmail(emailAddress);

                                    System.out.println("Enter Notes: ");
                                    notes = in.nextLine().trim();
                                    modifyInfo.setNotes(notes);

                                    phoneBook.modifyContact(modifyName, modifyInfo, index);
                                    runningModify = false;
                                }
                                //IOException is thrown if the name entered is not found
                                else if (index == -1){
                                    throw new IOException();
                                }
                            }
                            catch (IOException e){
                                System.out.println("Contact does not exist.");
                                System.out.println("Do you want to re-enter a new contact?\nEnter \"y\" or \"n\"");
                                String selection1 = in.nextLine().trim();
                                if (selection1.equals("y")) {

                                } else if (selection1.equals("n")) {
                                    System.out.println("Do you want to create a new contact using the previously entered contact?\nEnter \"y\" or \"n\"");
                                    String selection2 = in.nextLine().trim();
                                    if (selection2.equals("y")) {
                                        catchCreateNewContact3.setName(modifyName);

                                        //Making a new contact with name that was entered
                                        System.out.println("Enter Phone Number: ");
                                        phoneNumber = in.nextLine().trim();
                                        catchCreateNewContact3.setPhoneNum(phoneNumber);

                                        System.out.println("Enter Email Address: ");
                                        emailAddress = in.nextLine().trim();
                                        catchCreateNewContact3.setEmail(emailAddress);

                                        System.out.println("Enter Notes: ");
                                        notes = in.nextLine().trim();
                                        catchCreateNewContact3.setNotes(notes);

                                        phoneBook.addContact(catchCreateNewContact3);
                                        break;
                                    } else if (selection2.equals("n")) {
                                        System.out.println("Do you want to return to the Phonebook Sub-Menu?\nEnter \"y\" or \"n\"");
                                        String selection3 = in.nextLine().trim();
                                        if (selection3.equals("y")) {
                                            break;
                                        } else if (selection3.equals("n")) {
                                            runningModify = false;
                                            runningPhonebook = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //Delete contact
                    else if (selection.equals("3")) {
                        boolean runningDelete = true;
                        Contact catchCreateNewContact = new Contact();
                        while (runningDelete) {
                            //Program searches through the array list within phone book to find a matching name
                            System.out.println("Enter the name of the contact you want to delete: ");
                            String deleteName = in.nextLine().trim();
                            try {
                                int index = phoneBook.searchContact(deleteName);
                                if (index > -1) {
                                    phoneBook.deleteContact(deleteName, index);
                                    runningDelete = false;
                                }
                                //If name not found, throw IOException
                                else if (index == -1) {
                                    throw new IOException();
                                }
                            } catch (IOException e) {
                                System.out.println("Contact does not exist.");
                                System.out.println("Do you want to re-enter a new contact?\nEnter \"y\" or \"n\"");
                                String selection1 = in.nextLine().trim();
                                if (selection1.equals("y")) {

                                } else if (selection1.equals("n")) {
                                    System.out.println("Do you want to create a new contact using the previously entered contact?\nEnter \"y\" or \"n\"");
                                    String selection2 = in.nextLine().trim();
                                    if (selection2.equals("y")) {
                                        catchCreateNewContact.setName(deleteName);

                                        //Make a new contact with name entered
                                        System.out.println("Enter Phone Number: ");
                                        phoneNumber = in.nextLine().trim();
                                        catchCreateNewContact.setPhoneNum(phoneNumber);

                                        System.out.println("Enter Email Address: ");
                                        emailAddress = in.nextLine().trim();
                                        catchCreateNewContact.setEmail(emailAddress);

                                        System.out.println("Enter Notes: ");
                                        notes = in.nextLine().trim();
                                        catchCreateNewContact.setNotes(notes);

                                        phoneBook.addContact(catchCreateNewContact);
                                        break;
                                    } else if (selection2.equals("n")) {
                                        System.out.println("Do you want to return to the Phonebook Sub-Menu?\nEnter \"y\" or \"n\"");
                                        String selection3 = in.nextLine().trim();
                                        if (selection3.equals("y")) {
                                            break;
                                        } else if (selection3.equals("n")) {
                                            runningDelete = false;
                                            runningPhonebook = false;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    //Display contact one at a time
                    else if (selection.equals("4")) {
                        boolean runningDisplay = true;
                        Contact catchCreateNewContact2 = new Contact();
                        while(runningDisplay){
                            System.out.println("Enter the name of the contact you want to display: ");
                            String nameDisplay = in.nextLine().trim();
                            try{
                                int index = phoneBook.searchContact(nameDisplay);
                                if (index>-1){
                                    phoneBook.displayContact(nameDisplay, index);
                                    runningDisplay = false;
                                }
                                //If name was not found, throw IOException
                                else if (index == -1){
                                    throw new IOException();
                                }
                            }
                            catch (IOException e){
                                System.out.println("Contact does not exist.");
                                System.out.println("Do you want to re-enter a new contact?\nEnter \"y\" or \"n\"");
                                String selection1 = in.nextLine().trim();
                                if (selection1.equals("y")) {

                                } else if (selection1.equals("n")) {
                                    System.out.println("Do you want to create a new contact using the previously entered contact?\nEnter \"y\" or \"n\"");
                                    String selection2 = in.nextLine().trim();
                                    if (selection2.equals("y")) {
                                        catchCreateNewContact2.setName(nameDisplay);

                                        //Making a new contact using entered name
                                        System.out.println("Enter Phone Number: ");
                                        phoneNumber = in.nextLine().trim();
                                        catchCreateNewContact2.setPhoneNum(phoneNumber);

                                        System.out.println("Enter Email Address: ");
                                        emailAddress = in.nextLine().trim();
                                        catchCreateNewContact2.setEmail(emailAddress);

                                        System.out.println("Enter Notes: ");
                                        notes = in.nextLine().trim();
                                        catchCreateNewContact2.setNotes(notes);

                                        phoneBook.addContact(catchCreateNewContact2);
                                        break;
                                    } else if (selection2.equals("n")) {
                                        System.out.println("Do you want to return to the Phonebook Sub-Menu?\nEnter \"y\" or \"n\"");
                                        String selection3 = in.nextLine().trim();
                                        if (selection3.equals("y")) {
                                            break;
                                        } else if (selection3.equals("n")) {
                                            runningDisplay = false;
                                            runningPhonebook = false;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    //Display all contacts using toString
                    else if (selection.equals("5")) {
                        System.out.println("Contacts: ");
                        System.out.println(phoneBook.toString());
                    }

                    //Remove a favorite
                    else if (selection.equals("6")){
                        System.out.println("Enter the preset number of the favorite you want to remove: ");
                        String presetNumInput = in.nextLine().trim();
                        if (!Character.isDigit(presetNumInput.charAt(0))){
                            System.out.println("Not a valid preset number.");
                        }
                        else{
                            int presetNum = Integer.parseInt(presetNumInput);
                            //If there exists a favorite
                            if (phoneBook.sizeOfFavorite() != 0) {
                                //If the preset number they enter is actually a favorite
                                if (!(presetNum > phoneBook.sizeOfFavorite())){
                                    int indexOfFavorite = presetNum - 1;
                                    phoneBook.removeFavorite(indexOfFavorite);
                                }
                                else{
                                    System.out.println("Favorite does not exist.");
                                }
                            }
                            else{
                                System.out.println("You do not have any favorites.");
                            }
                        }
                    }

                    //Display single favorite
                    else if (selection.equals("7")){
                        System.out.println("Enter the preset number of the favorite you want to display: ");
                        String presetNumInput = in.nextLine().trim();
                        if (!Character.isDigit(presetNumInput.charAt(0))){
                            System.out.println("Not a valid preset number.");
                        }
                        else{
                            int presetNum = Integer.parseInt(presetNumInput);
                            if (phoneBook.sizeOfFavorite() != 0) {
                                if (!(presetNum > phoneBook.sizeOfFavorite())){
                                    int indexOfFavorite = presetNum - 1;
                                    Contact displayContact = phoneBook.findDisplayContact(indexOfFavorite);

                                    int fHeight = 800;
                                    int zWidth = 1250; //Same as fWidth, just changed name because I reconfigured with my text

                                    //Display image of contact
                                    
                                    /*
                                     * FOR USERS WHO OBTAINED CODE THROUGH GITHUB:
                                     * Uncomment lines 353-376 to use JFrame.
                                     * JFrame is used to display an image when you display a favorite contact.
                                     * You must change the directory from my directory, to somewhere on your local machine.
                                     * Supply your own images, then the display function will work on your local machine
                                     */
                                    
//                                    FavoriteContactFrame contact1 = new FavoriteContactFrame("C:\\Users\\tanne\\Pictures\\businesswoman1.png", zWidth, fHeight, displayContact.getName(), displayContact.getPhoneNum(), displayContact.getEmail(), displayContact.getNotes());
//                                    FavoriteContactFrame contact2 = new FavoriteContactFrame("C:\\Users\\tanne\\Pictures\\businessman2.png", zWidth, fHeight, displayContact.getName(), displayContact.getPhoneNum(), displayContact.getEmail(), displayContact.getNotes());
//                                    FavoriteContactFrame contact3 = new FavoriteContactFrame("C:\\Users\\tanne\\Pictures\\businessman3.png", zWidth, fHeight, displayContact.getName(), displayContact.getPhoneNum(), displayContact.getEmail(), displayContact.getNotes());
//                                    FavoriteContactFrame contact4 = new FavoriteContactFrame("C:\\Users\\tanne\\Pictures\\businesswoman4.png", zWidth, fHeight, displayContact.getName(), displayContact.getPhoneNum(), displayContact.getEmail(), displayContact.getNotes());
//                                    FavoriteContactFrame contact5 = new FavoriteContactFrame("C:\\Users\\tanne\\Pictures\\businesswoman5.png", zWidth, fHeight, displayContact.getName(), displayContact.getPhoneNum(), displayContact.getEmail(), displayContact.getNotes());
//
//                                    if (presetNum == 1){
//                                        contact1.displayContactFrame();
//                                    }
//                                    else if (presetNum == 2){
//                                        contact2.displayContactFrame();
//                                    }
//                                    else if (presetNum == 3){
//                                        contact3.displayContactFrame();
//                                    }
//                                    else if (presetNum == 4){
//                                        contact4.displayContactFrame();
//                                    }
//                                    else if (presetNum == 5){
//                                        contact5.displayContactFrame();
//                                    }
                                    
                                }
                                else{
                                    System.out.println("Favorite does not exist.");
                                }
                            }
                            else{
                                System.out.println("You do not have any favorites.");
                            }
                        }
                    }

                    //Rearrange favorites
                    else if (selection.equals("8")){
                        System.out.println("Enter the preset number of the favorite you want to move: ");
                        String presetNumInput = in.nextLine().trim();
                        if (!Character.isDigit(presetNumInput.charAt(0))){
                            System.out.println("Not a valid preset number.");
                        }
                        else{
                            int presetNum = Integer.parseInt(presetNumInput);
                            if (phoneBook.sizeOfFavorite() != 0) {
                                if (!(presetNum > phoneBook.sizeOfFavorite())){
                                    int indexOfFavorite = presetNum - 1;
                                    //Move favorite to this position
                                    System.out.println("Enter the new preset number of the favorite: ");
                                    String newPresetNumInput = in.nextLine().trim();
                                    if (!Character.isDigit(newPresetNumInput.charAt(0))){
                                        System.out.println("Not a valid preset number.");
                                    }
                                    else{
                                        int presetNum2 = Integer.parseInt(newPresetNumInput);
                                        int indexOfMove = presetNum2 - 1;
                                        phoneBook.moveFavorite(indexOfMove, indexOfFavorite);
                                    }
                                }
                                else{
                                    System.out.println("Favorite does not exist.");
                                }
                            }
                            else{
                                System.out.println("You do not have any favorites.");
                            }
                        }
                    }

                    //Display all favorites
                    else if (selection.equals("9")){
                        System.out.println("Favorites: ");
                        System.out.println(phoneBook.toStringFavorites());
                    }

                    //Exit the phonebook
                    else if (selection.equals("10")) {
                        runningPhonebook = false;
                    }
                }
            }
            //Make a call
            else if (selection.equals("2")||selection.equals("3")) {
                boolean runningCall = true;
                Contact enteredNumber = new Contact();
                CallInfo callHistoryInfo = new CallInfo();
                String time = new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());
                String date = new SimpleDateFormat("MM/dd/YY").format(Calendar.getInstance().getTime());

                while (runningCall) {
                    if(selection.equals("2")) {
                        System.out.println("To make a call, enter a name, number, or preset number 1-5");
                    }
                    else {
                        System.out.println("To recieve a call, enter a name, number, or preset number 1-5");
                    }
                    String makeACall = in.nextLine().trim();

                    //We know (assume) user has entered a preset number based on length, so we want to cast the string to int
                    if(makeACall.length() == 1) {

                        int presetNum = Integer.parseInt(makeACall);
                        //Make sure it's a number 1-5
                        if (presetNum > 0 && presetNum < 6) {
                            if (phoneBook.sizeOfFavorite() != 0) {
                                if (!(presetNum > phoneBook.sizeOfFavorite())){
                                    int indexOfFavorite = presetNum - 1;
                                    String favoriteName = phoneBook.searchFavoriteName(indexOfFavorite);
                                    String favoriteNumber = phoneBook.searchFavoriteNumber(indexOfFavorite);
                                    // if user chose "make a call" you will make a call, and vice versa from recieving a call if the user enters 4
                                    if(selection.equals("2")) {
                                        System.out.println("You called: " + '"' + favoriteName + '"');
                                    }
                                    else {
                                        System.out.println("Call from: " + '"' + favoriteName + '"');
                                    }
                                    callHistoryInfo.setName(favoriteName);
                                    callHistoryInfo.setPhoneNum(favoriteNumber);
                                    callHistoryInfo.setTime(time);
                                    callHistoryInfo.setDate(date);
                                    // if user chose "make a call" set it as an outgoing call and vice versa if the user chose "recieve a call"
                                    if(selection.equals("2")) {
                                        callHistoryInfo.setType("(OUTGOING)");
                                    }
                                    else {
                                        callHistoryInfo.setType("(INCOMING)");
                                    }
                                    callLog.addCall(callHistoryInfo);
                                    //callLog.searchCall(callHistoryInfo.getNumber());
                                    runningCall = false;
                                }
                                else{
                                    System.out.println("Favorite does not exist.");
                                    runningCall = false;
                                }
                            }
                            else {
                                System.out.println("You do not have any favorites.");
                                runningCall = false;
                            }
                        }
                    }
                    //We know the user has entered a number
                    else if (Character.isDigit(makeACall.charAt(0))) {
                        enteredNumber.setPhoneNum(makeACall);
                        String number = enteredNumber.getPhoneNum();
                        String foundSomething = phoneBook.searchContactPhoneNum(number);
                        //If we find no name, we find a number
                        if (Character.isDigit(foundSomething.charAt(1))){
                            // if user chose "make a call" you will make a call, and vice versa from recieving a call if the user enters 4
                            if(selection.equals("2")) {
                                System.out.println("You called: " + '"' + foundSomething + '"');
                            }
                            else {
                                System.out.println("Call from: " + '"' + foundSomething + '"');
                            }
                            callHistoryInfo.setPhoneNum(foundSomething);
                            callHistoryInfo.setTime(time);
                            callHistoryInfo.setDate(date);
                            // if user chose "make a call" set it as an outgoing call and vice versa if the user chose "recieve a call"
                            if(selection.equals("2")) {
                                callHistoryInfo.setType("(OUTGOING)");
                            }
                            else {
                                callHistoryInfo.setType("(INCOMING)");
                            }
                            callLog.addCall(callHistoryInfo);
                            runningCall = false;
                        }
                        //Found a name
                        else {
                            // if user chose "make a call" you will make a call, and vice versa from recieving a call if the user enters 4
                            if(selection.equals("2")) {
                                System.out.println("You called: " + '"' + foundSomething + '"');
                            }
                            else {
                                System.out.println("Call from: " + '"' + foundSomething + '"');
                            }
                            callHistoryInfo.setPhoneNum(number);
                            callHistoryInfo.setName(foundSomething);
                            callHistoryInfo.setTime(time);
                            callHistoryInfo.setDate(date);
                            // if user chose "make a call" set it as an outgoing call and vice versa if the user chose "recieve a call"
                            if(selection.equals("2")) {
                                callHistoryInfo.setType("(OUTGOING)");
                            }
                            else {
                                callHistoryInfo.setType("(INCOMING)");
                            }
                            callLog.addCall(callHistoryInfo);
                            runningCall = false;
                        }
                    }
                    else {
                        //We know the user has entered a name
                        try {
                            int index = phoneBook.searchContact(makeACall);
                            String callName = phoneBook.searchContactName(makeACall);
                            String numberCheck = phoneBook.searchContactPhoneNum(makeACall);
                            if (!(callName.equals("Not found"))){
                                callHistoryInfo.setName(callName);
                                callHistoryInfo.setTime(time);
                                callHistoryInfo.setDate(date);
                                // if user chose "make a call" set it as an outgoing call and vice versa if the user chose "recieve a call"
                                if(selection.equals("2")) {
                                    callHistoryInfo.setType("(OUTGOING)");
                                }
                                else {
                                    callHistoryInfo.setType("(INCOMING)");
                                }
                                callLog.addCall(callHistoryInfo);
                                runningCall = false;
                            }

                            //If the name is not found, throw an exception
                            if (phoneBook.searchContactName(makeACall).equals("Not found") || numberCheck.equals("Not found")) {
                                throw new IOException();
                            }
                            else {
                                // if user chose "make a call" you will make a call, and vice versa from recieving a call if the user enters 4
                                if(selection.equals("2")) {
                                    System.out.println("You called: " + '"' + callName + '"');
                                }
                                else {
                                    System.out.println("Call from: " + '"' + callName + '"');
                                }
                                System.out.println("");
                                String number = phoneBook.getPhoneNumberUsingIndex(index);
                                callHistoryInfo.setPhoneNum(number);
                            }
                        }
                        catch (IOException e) {
                            System.out.println("Contact does not exist");
                            System.out.println("Do you want to re-enter a new contact?\nEnter \"y\" or \"n\"");
                            runningCall = true;

                            selection = in.nextLine();

                            if (selection.equals("y")) {
                            }

                            else if (selection.equals("n")) {
                                System.out.println("Do you want to return to the main menu?\nEnter \"y\" or \"n\"");

                                selection = in.nextLine();

                                if (selection.equals("y")) {
                                    runningCall = false;
                                }
                                else if(selection.equals("n")) {
                                }
                            }
                        }

                    }

                }

            }
            //Access call log
            else if (selection.equals("4")){
                CallInfo numberFormatter = new CallInfo();
                //Call log sub-menu
                System.out.println("Call Log Sub-Menu");
                System.out.println("1. Find Call History Of");
                System.out.println("2. Find All Call History");
                selection = in.nextLine().trim();

                //Display call history of name or number
                if (selection.equals("1")){
                    System.out.println("Enter the name or number of the contact you want to display the call history of: ");
                    String nameOrNumber = in.nextLine().trim();
                    //If they enter a number
                    if (Character.isDigit(nameOrNumber.charAt(1))){
                        numberFormatter.setPhoneNum(nameOrNumber);
                        callLog.findCalls(numberFormatter.getNumber());
                    }
                    else{
                        //They entered a name
                        int index = phoneBook.searchContact(nameOrNumber);
                        String number = phoneBook.getPhoneNumberUsingIndex(index);
                        callLog.findCalls(number);
                    }
                }
                //Display all call history
                else if (selection.equals("2")){
                    callLog.allHistory();
                }
            }
            //Close program
            else if (selection.equals("5")) {
                System.out.println("Goodbye");
                running = false;
            }
        }
    }
}
