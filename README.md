# Model-Cell-Phone
Java program that models the features and functionality of a cell phone. Store contacts in a phone book, make and receive calls, and display call history. Made in university object-oriented programming class.
## Table of Contents
1. Getting started
2. Running the program
## Getting started
The instructions listed below will get you a working copy of the project on your local machine for testing purposes.
### Prerequisites
There are two optional prerequisites prior to obtaining this program on your local machine. The first optional prerequisite is to have access to any IDE (Integrated Development Environment) that can run Java code. The second optional prerequisite is to download Git to use Git Bash for cloning the repository to your local machine.
### Installing
There are two methods of installing this program on your local machine.
1. Copy + Paste the Java code into your IDE.
2. Cloning the GitHub repository to your local machine.
#### Method 1
This method will go through the setup process using the copy and paste method.
```
Create a new Java project. Within this Java project, create a package called "edu.project3".

In this package, create 6 java classes and title them, "Cellphone", "Phonebook", "Contact", "CallLog", "CallInfo", and "FavoriteContactFrame".
```
This creates blank Java classes which will later be used to run the program after copy and pasting the code.
```
Click or copy and paste the following links in any web browser to find the code used for each Java class.

Once open, highlight and copy the code found in the links below

Finally, paste in the code to each class and run the program.
```
Cellphone.java (main) link: https://github.com/Tanner-Mindrum/Model-Cell-Phone/blob/master/Cellphone.java

Phonebook.java link: https://github.com/Tanner-Mindrum/Model-Cell-Phone/blob/master/Phonebook.java    

Contact.java link: https://github.com/Tanner-Mindrum/Model-Cell-Phone/blob/master/Contact.java   

CallLog.java link: https://github.com/Tanner-Mindrum/Model-Cell-Phone/blob/master/CallLog.java   

CallInfo.java link: https://github.com/Tanner-Mindrum/Model-Cell-Phone/blob/master/CallInfo.java    

FavoriteContactFrame.java link: https://github.com/Tanner-Mindrum/Model-Cell-Phone/blob/master/FavoriteContactFrame.java
#### Method 2
This method will go over cloning the repository to your local machine. In this example, I will be cloning the repository to the desktop; however, you can select whichever directory you'd like when cloning the repository to your local machine. Input these commands using the Git Bash program.
```
cd ~/Desktop/
```
This command will change your directory to your desired directory.
```
git clone https://github.com/Tanner-Mindrum/Model-Cell-Phone.git
```
This command clones the repository to your computer in a sub-directory in the directory you started working in.
```
cd Model-Cell-Phone

ls
```
These commands will display the files that should be stored in your local machine. These files should be "Cellphone.java", "Phonebook.java", "Contact.java", "CallLog.java", "CallInfo.java", "FavoriteContactFrame.java", and "README.md".

Navigate to the repository in a Java compiler and find the class. You can run the program at this point.
## Running the program
To run this program, open the Cellphone Java class and run the program in a IDE that can run Java. Follow the prompts that console provides you.

Here is an example of adding a contact to the phone book, saving it as a favorite, and displaying all favorites:
```
Cellphone Menu
1. Access Phonebook
2. Make a Call
3. Receive a Call
4. Access Call Log
5. Quit
Enter a number to select a function: 
1

Phonebook Sub-Menu
1. Add Contact/Add Favorite
2. Modify Contact
3. Delete Contact
4. Display Contact
5. Display All Contacts
6. Remove Favorite
7. Display Favorite
8. Rearrange Favorites
9. Display All Favorites
10. Exit phone book

Enter a number to select an option: 
1

Enter name: 
Student
Enter Phone Number: 
7777777777
Enter Email Address: 
student@gmail.com
Enter Notes: 
I love Java!
Do you want to make this contact a favorite?
To add as favorite, enter "y", otherwise enter any other key: 
y
Phonebook Sub-Menu
1. Add Contact/Add Favorite
2. Modify Contact
3. Delete Contact
4. Display Contact
5. Display All Contacts
6. Remove Favorite
7. Display Favorite
8. Rearrange Favorites
9. Display All Favorites
10. Exit phone book

Enter a number to select an option: 
9
Favorites: 
Student             (777) 777-7777      student@gmail.com              Notes: I love Java! 
```
Here is an example of calling "Student" by their name and phone number:
```
Cellphone Menu
1. Access Phonebook
2. Make a Call
3. Receive a Call
4. Access Call Log
5. Quit
Enter a number to select a function: 
2
To make a call, enter a name, number, or preset number 1-5
Student
You called: "Student"

Cellphone Menu
1. Access Phonebook
2. Make a Call
3. Receive a Call
4. Access Call Log
5. Quit
Enter a number to select a function: 
2
To make a call, enter a name, number, or preset number 1-5
7777777777
You called: "Student"
```
Here is an example of displaying all the call history, then displaying Student's call history individually. When a contact is interacted with more than once, it displays how many times they were called/called next to their name or phone number. To find that contact's full call history, select the "Find call history of" function:
```
Cellphone Menu
1. Access Phonebook
2. Make a Call
3. Receive a Call
4. Access Call Log
5. Quit
Enter a number to select a function: 
4
Call Log Sub-Menu
1. Find Call History Of
2. Find All Call History
2
Student              (2)
123-4567            10/27/18  04:38 PM  (INCOMING)
Mom                 10/27/18  04:38 PM  (OUTGOING)
Cellphone Menu
1. Access Phonebook
2. Make a Call
3. Receive a Call
4. Access Call Log
5. Quit
Enter a number to select a function: 
4
Call Log Sub-Menu
1. Find Call History Of
2. Find All Call History
1
Enter the name or number of the contact you want to display the call history of: 
Student
Student             10/27/18  04:35 PM  (OUTGOING)
Student             10/27/18  04:35 PM  (OUTGOING)
```
