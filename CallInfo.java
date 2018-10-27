package edu.project3;

/**
 *The CallInfo class is similar to the contact class,
 *however the information that will be stored
 *in this class will be used for display purposes in the call log
 **/

public class CallInfo {

    //Instance variables used in the CallInfo class
    private String name;
    private String phoneNumber;
    private String date;
    private String time;
    private String callType;

    /**
     * Constructor for the CallInfo class
     * Sets the instance variables to empty strings
     */
    public CallInfo() {
        this.name = "";
        this.phoneNumber = "";
        this.date = "";
        this.callType = "";
    }

    /**
     * Sets the name of the call made
     * @param callerName - the name of the contact
     */
    public void setName(String callerName) {
        this.name = callerName;

    }

    /**
     * Gets the name of the call made
     * @return this.name - name of the contact
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the phone number of the call made and formats phone number
     * Formats the same the Contact class does
     * @param callerNumber - the number of the call made
     */
    public void setPhoneNum(String callerNumber){
        int count = 0;
        String allNumber = "";
        String formattedNumber = "";
        for (int i=0; i<callerNumber.length(); i++){
            char c = callerNumber.charAt(i);
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
        this.phoneNumber = formattedNumber;
    }

    /**
     * Gets the number of the contact called
     * @return phoneNumber - the number of the contact called
     */
    public String getNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the date at the time the call was made
     * @param todaysDate - the date of when the call was made
     */
    public void setDate(String todaysDate){
        this.date = todaysDate;
    }

    /**
     * Gets the date at the time the call was made
     * @return this.date - the date of when the call was made
     */
    public String getDate( ) {
        return this.date;
    }

    /**
     * Sets the time of when the call was made
     * @param currentTime - time when call was made
     */
    public void setTime(String currentTime) {
        this.time = currentTime;
    }

    /**
     * Gets the time of when the call was made
     * @return this.time - the time of when the call was made
     */
    public String getTime() {
        return this.time;
    }

    /**
     * Sets the type of call
     * Calls will be incoming or outgoing
     * @param typeOfCall - the type of call that was made
     */
    public void setType(String typeOfCall) {
        this.callType = typeOfCall;
    }

    /**
     * Gets the type of call that was made
     * @return this.callType - the type of call that was made
     */
    public String getType() {
        return this.callType;
    }

    /**
     * Formats the calls made for the call log nicely in one line
     * Has to ways of formatting the string
     * 1st way - if the name of the call was found, prints the name with date, time, type of call
     * 2nd way - if the name of the call was not found, prints the phone number with date, time, type of call
     * @return
     */
    public String toString() {

        String formattedList;

        if (!name.equals("")) {
            formattedList = String.format("%-20s%-10s%-10s%-10s", name, date, time, callType);
        }
        else {
            formattedList = String.format("%-20s%-10s%-10s%-10s", phoneNumber, date, time, callType);
        }

        return formattedList;
    }
}

