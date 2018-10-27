package edu.project3;

/**
 * The Contact class contains setters and getters to obtain and format the necessary contact information of a contact
 */

public class Contact {

    //Instance variables used in Contact class
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String notes;

    /**
     * Constructor initializes instance variables
     * Name, email, notes are set to "N/A" and phone number is set to all zeros
     */
    public Contact(){
        this.name = "N/A";
        this.phoneNumber = "(000) 000-0000";
        this.emailAddress = "N/A";
        this.notes = "N/A";
    }

    /**
     * Sets the name of a contact
     * @param name - the user inputted name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Gets the name of the contact
     * @return name - the name of a contact
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the phone number of a contact and formats numbers
     * If the phone number is 10 digits long, the format is (XXX) XXX-XXXX
     * If the phone number is 7 digits long, the format is XXX-XXXX
     * Otherwise, the phone number is returned as inputted
     * @param thisNum
     */
    public void setPhoneNum(String thisNum){
        int count = 0;
        String allNumber = "";
        String formattedNumber = "";
        for (int i=0; i<thisNum.length(); i++){
            char c = thisNum.charAt(i);
            if (Character.isDigit(c)){
                count ++;
                allNumber += c;
            }
        }
        if (count == 10){
            formattedNumber += "(";
            formattedNumber += allNumber.substring(0,3);
            formattedNumber += ") ";
            formattedNumber += allNumber.substring(3,6);
            formattedNumber += "-";
            formattedNumber += allNumber.substring(6,10);
        }
        else if (count == 7){
            formattedNumber += allNumber.substring(0,3);
            formattedNumber += "-";
            formattedNumber += allNumber.substring(3,7);
        }
        else {
            formattedNumber = allNumber;
        }
        phoneNumber = formattedNumber;
    }

    /**
     * Gets the phone number of the contact
     * @return phoneNumber - the phone number of the contact
     */
    public String getPhoneNum(){
        return phoneNumber;
    }

    /**
     * Sets the email of the contact
     * @param email - the user inputted email
     */
    public void setEmail(String email){
        this.emailAddress = email;
    }

    /**
     * Gets the email of the contact
     * @return emailAddress - the email of the contact
     */
    public String getEmail(){
        return emailAddress;
    }

    /**
     * Sets the notes of the contact
     * @param n - the user inputted notes
     */
    public void setNotes(String n){
        this.notes = n;
    }

    /**
     * Gets the notes of the contact
     * @return notes - the user inputted notes
     */
    public String getNotes(){
        return notes;
    }

    /**
     * Formats the contact information in one line
     * Formats the info nicely in columns so contacts are printed with clarity
     * @return formattedContact - the contact info formatted nicely
     */
    public String toString() {

        String formattedContact;
        formattedContact = String.format("%-20s%-20s%-30s Notes: %-20s", name, phoneNumber, emailAddress, notes);
        return formattedContact;
    }
}