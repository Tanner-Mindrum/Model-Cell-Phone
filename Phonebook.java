package edu.project3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 * The phonebook class sets up our list of contacts
 * It has all the methods of adding, modifying, deleting,
 * displaying, and sorting all of the contacts.
 * There is an ArrayList of Contact objects that will store
 * all the information of the contacts
 **/

public class Phonebook {

    private ArrayList <Contact> Contacts;
    private ArrayList <Contact> FavoriteContacts;


    /**
     * The constructor initializes both array lists of contact objects
     */

    public Phonebook() {
        this.Contacts = new ArrayList();
        this.FavoriteContacts = new ArrayList();
    }
    /**
     * This method is used to delete a contact that the user wants. It takes in an index
     * of where the element is within the Contacts array list and removes it. It also
     * removes it from the FavoriteContacts array list if it also in the favorites
     * @param deleteName - The name of the contact that the user wants to delete
     * @param index - The index at which the element is found within the contact object
     */
    public void deleteContact(String deleteName, int index) {
        Contacts.remove(index);
        if (searchFavorite(deleteName)>-1){
            FavoriteContacts.remove(searchFavorite(deleteName));
        }
    }
    /**
     * creates a new contact and sets all variables and adds to the Contacts array list
     * @param  - name of the contact we want to add
     * @param  - number of the contact we want to add
     * @param  - email of the contact we want to add
     * @param  - notes of the contact we want to add
     */
    public void addContact(Contact newContact) {
        Contacts.add(newContact);
        sort(Contacts);
    }
    /**
     * Displays a contact that the user inputs
     * @param contactDisplay - This parameter is the contact that the user wants to display
     * @param index - The index in the ArrayList of where the contact was found
     */
    public void displayContact(String contactDisplay, int index) {
        System.out.println(Contacts.get(index).toString());
    }
    /**
     * Uses the index entered by the user and is passed into the parameter \ to search
     * the favorite's array list
     * @param index - A parameter that is passed in by the user to search the favorites array list
     */
    public void displayFavorite(int index){
        System.out.println(FavoriteContacts.get(index).toString());
    }
    /**
     * The user enters a name they want to search within the array list of contacts.
     * The name is passed through a parameter and the method searches the array list
     * to match the user inputed name to what is in the array list. If the name is not
     * within the contact array list, it will return -1 to signify that the name
     * the user entered was not found in the Contacts array list
     *
     * @param contactName - This parameter is passed in when the user enters a contact they want to search for
     * @return i - The method returns an index if the method matches an element in the contact array list with what
     * the user entered. If the method does not find the contact within the array list, it will return -1
     */

    public int searchContact(String contactName) {
        int index = 0;
        String currentName = "";
        for (int i = 0; i < Contacts.size(); i++) {
            Contact currentContact = Contacts.get(i);
            currentName = currentContact.getName();
            if (currentName.equals(contactName)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * The user enters a name of the contact they want to display.
     * The parameter is passed in and the method searches the contacts array list
     * to match what the user inputed. If the method finds a match, it will
     * immediately return the name of the contact they want displayed
     * @param contactName - The parameter is the contact name the user wants displayed
     * @return - Returns the contact name they want displayed if it is in the array list,
     * however if the contact is not in the array list the method will return the string
     * "Not found."
     */

    public String searchContactName(String contactName) {
        int index = 0;
        String currentName = "";
        for (int i = 0; i < Contacts.size(); i++) {
            Contact currentContact = Contacts.get(i);
            currentName = currentContact.getName();
            if (currentName.equals(contactName)) {
                return currentContact.getName();
            }
        }

        return "Not found";
    }

    /**
     * This method is used when the user wants to modify a contact in the Contacts
     * array list. It will take in the name that they want to modify, a contact object
     * called modifiedContact that contains all the information they want to change
     * and an index of where the contact is within the Contacts array list. If the user wants
     * to modify a contact that is in the FavoriteContacts array list, then it will also modify
     * the contact in the favorites array list. Also, this method automatically sorts the Contacts
     * array list.
     *
     * @param name - The name passed through that they want to modify
     * @param modifiedContact - A contact object that is created in the main and passed as a parameter
     * that contains all the information of the specific contact they want to change such as their name,
     * phone number, email, and notes.
     * @param index - The index that is passed in to show where the element is within the Contacts array list
     */
    public void modifyContact(String name, Contact modifiedContact, int index) {
        Contacts.set(index, modifiedContact);
        if(searchFavorite(name)>-1) {
            FavoriteContacts.set(searchFavorite(name), modifiedContact);
        }
        sort(Contacts);
    }
    /**
     * The to string method calls the to string method from the Contact class
     * It runs the to String from the contact class into a for loop, therefore we can print
     * multiple elements of the Contacts array list
     */

    public String toString() {
        String str = "";
        for (Contact c : Contacts) {
            str += c.toString() + "\n";
        }
        return str;
    }


    /**
     * This method takes all the contacts within the Contacts array list,
     * and sorts the array list in alphabetical order
     * @param allContacts - The Contacts array list is passed in as a parameter whenever
     * it is modified
     */
    public static void sort(ArrayList<Contact>allContacts) {

        Collections.sort(allContacts, Comparator.comparing(Contact::getName));

    }
    /**
     * This method adds a favorite the FavoriteContacts array list when the user wants
     * to add a contact to favorite. The method checks the size of the Favorite Contacts array list
     * to see whether or not it is greater than 5. If the Favorite Contacts has five contacts already in it,
     * it deletes the last element of the favorite contacts and adds in the new favorite
     * @param newFavorite - The parameter is a contact object that is passed in by the user in the main
     */
    public void addFavorite (Contact newFavorite) {
        if (FavoriteContacts.size() < 5) {
            FavoriteContacts.add(0, newFavorite);
        }
        else {
            FavoriteContacts.remove(4);
            FavoriteContacts.add(0,newFavorite);
        }
    }

    /**
     * This method is called when the user wants to rearrange their favorite contacts
     * to different slots. The user will pass in two indexes, which will move the favorite
     * to the corresponding index
     * @param indexOfMove - The user passes in the index of where they want to move their favorite to
     * @param indexOfFavorite - The user passes in the index of which favorite they want to move
     */

    public void moveFavorite(int indexOfMove, int indexOfFavorite){
        Contact contactBeingMoved = FavoriteContacts.get(indexOfFavorite);
        FavoriteContacts.remove(indexOfFavorite);
        FavoriteContacts.add(indexOfMove, contactBeingMoved);
    }
    /**
     * The search favorite is used when the user wants to display a favorite within the
     * FavoriteContacts array list. The method returns an index of where the contact is found.
     * @param name - The parameter is a name that the user enters when they want to find a favorite
     * @return i - It returns the index of where the favorite is if it is found within the FavoriteContacts
     * array list, it will return -1 if the favorite contact is not found
     */
    public int searchFavorite (String name) {
        for (int i=0; i<FavoriteContacts.size(); i++) {
            if(FavoriteContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * This method takes in an integer parameter that is used to return
     * the element at that specific index
     * @param index - An integer that is used to tell which element the method is returning
     * @return FavoriteContacts.get(index) - This returns the contact object
     */
    public Contact findDisplayContact(int index){
        return FavoriteContacts.get(index);
    }

    /**
     * Searches for the name of a favorite contact
     * @param index - the preset number provided by the user
     * @return - the name of the contact at the position of the preset number provided by the user
     */
    public String searchFavoriteName(int index){
        return FavoriteContacts.get(index).getName();
    }

    /**
     * Searches for the phone number of a favorite contact
     * @param index - the preset number provided by the user
     * @return - the phone number of the contact at the position of the preset number provided by the user
     */
    public String searchFavoriteNumber(int index){
        return FavoriteContacts.get(index).getPhoneNum();
    }

    /**
     * Removes a favorite at the index of the user inputted preset number
     * @param index - the preset number the user provides
     */
    public void removeFavorite (int index) {
        FavoriteContacts.remove(index);
    }

    /**
     * Formats the favorite contacts the same way regular contacts are formatted. Uses toString from the Contact class.
     * @return - nicely formatted string with contact information
     */
    public String toStringFavorites() {
        String str = "";
        for (Contact c : FavoriteContacts) {
            str += c.toString() + "\n";
        }
        return str;
    }

    /**
     * Finds the size of the list of favorites
     * @return - the size of the FavoriteContacts arraylist
     */
    public int sizeOfFavorite() {

        return FavoriteContacts.size();
    }

    /**
     * Searches for the phone number of a contact
     * @param contactNumber - the number of the contact that was made a call to
     * @return - if a name is found in the Contacts array list, it returns a name. otherwise, the number is returned
     * because that means the contact that a call was made to does not exist
     */
    public String searchContactPhoneNum(String contactNumber) {
        int index = 0;
        String currentNumber = "";
        for (int i = 0; i < Contacts.size(); i++) {
            Contact currentContact = Contacts.get(i);
            currentNumber = currentContact.getPhoneNum();
            if (currentNumber.equals(contactNumber)) {
                return currentContact.getName();
            }
        }

        return contactNumber;
    }

    /**
     * Gets the phone number of a contact using an index
     * @param index - the position of the contact in the Contacts array list
     * @return - the phone number of the contact found at the given index parameter
     */
    public String getPhoneNumberUsingIndex(int index){
        return Contacts.get(index).getPhoneNum();
    }


}
