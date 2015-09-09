
/*
 * Ryan Doherty
 * rdoherty@csumb.edu
 * CST338
 * 2015-09-08 
 * Description: Module 1 - String Manipulation
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 * @author Ryan Doherty
 *
 */
public class Module1 {
    static final int MIN_HOURS = 12;
    static final int MAX_HOURS = 20;
    /** 
     * 
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {  
        
        Scanner scan = new Scanner(System.in);
        
        String enterFirstNamePrompt = "Please enter your first name:";
        String enterLastNamePrompt = "Please enter your last name:";
        String firstLetterMustBeCapital = "(Please capitalize the first letter)";
        String enterHoursStudiedPrompt = "You should have studied between " + MIN_HOURS + " and " + MAX_HOURS + " hours this week.";
        String hoursStudiedFormat = "Please enter the number of hours you spent studying to three decimals (##.###).";
        String fullNameIs = "Your full name is: ";
        String fullNameLengthIs = "and it is %s characters long.";
        String fullNameUpperIs = "Your full name in upper case is: ";
        String fullNameLowerIs = "Your full name in lower case is: ";
        String hoursStudiedSuccess = "Well done! You studied for %s hours.";
        String threeDecimalRegEx = "^\\d\\d+\\.\\d{3}$";
        String oneDecimalFormat = "##.0";
        
        //prompt user for first name
        System.out.println(enterFirstNamePrompt); 
        System.out.println(firstLetterMustBeCapital); 
        String firstName = scan.next().trim();  
        
        //enforce capital first letter rule
        while (!Character.isUpperCase(firstName.charAt(0))){
            System.out.println(enterFirstNamePrompt); 
            System.out.println(firstLetterMustBeCapital); 
            firstName = scan.next().trim();  
        }

        //prompt user for last name
        System.out.println(enterLastNamePrompt);
        System.out.println(firstLetterMustBeCapital); 
        String lastName = scan.next().trim();  

        //enforce capital first letter rule
        while (!Character.isUpperCase(lastName.charAt(0))){
            System.out.println(enterLastNamePrompt); 
            System.out.println(firstLetterMustBeCapital); 
            lastName = scan.next().trim();  
        }

        //concatenate first name, a space, and last name.
        String fullName = firstName + " " + lastName;

        //Display the user's full name and length of it plus one space.
        System.out.println(fullNameIs + fullName);
        System.out.println(String.format(fullNameLengthIs, fullName.length()));

        //Display the user's full name in upper case.
        System.out.println(fullNameUpperIs + fullName.toUpperCase());
        //Display the user's full name in lower case.
        System.out.println(fullNameLowerIs + fullName.toLowerCase());
        
        //Prompt user for hours studied to three decimal places.
        System.out.println(enterHoursStudiedPrompt);
        System.out.println(hoursStudiedFormat);
        
        //get type-agnostic user input so it can be matched to a regex pattern.
        String hoursInput = scan.next().trim(); 
        Double hoursStudied = Double.parseDouble(hoursInput);

        //enforce three decimal places rule and restrict values between MIN_HOURS and MAX_HOURS
        while ((!hoursInput.matches(threeDecimalRegEx))  || (!(Double.compare(hoursStudied, MIN_HOURS) > 0)  || !(Double.compare(MAX_HOURS, hoursStudied) > 0) )) {
            System.out.println(enterHoursStudiedPrompt);
            System.out.println(hoursStudiedFormat);
            hoursInput = scan.next().trim();
            hoursStudied =  Double.parseDouble(hoursInput);
        }
        
        //Display user's input as rounded to one decimal place.
        DecimalFormat formatToOneDecimal= new DecimalFormat(oneDecimalFormat);
        System.out.println(String.format(hoursStudiedSuccess, formatToOneDecimal.format(hoursStudied)));
        
        scan.close();
        
    }
    
    
}

/* FIRST RUN

Please enter your first name:
(Please capitalize the first letter)
ryan
Please enter your first name:
(Please capitalize the first letter)
Ryan
Please enter your last name:
(Please capitalize the first letter)
doherty
Please enter your last name:
(Please capitalize the first letter)
Doherty
Your full name is: Ryan Doherty
and it is 12 characters long.
Your full name in upper case is: RYAN DOHERTY
Your full name in lower case is: ryan doherty
You should have studied between 12 and 20 hours this week.
Please enter the number of hours you spent studying to three decimals (##.###).
10
You should have studied between 12 and 20 hours this week.
Please enter the number of hours you spent studying to three decimals (##.###).
21
You should have studied between 12 and 20 hours this week.
Please enter the number of hours you spent studying to three decimals (##.###).
13
You should have studied between 12 and 20 hours this week.
Please enter the number of hours you spent studying to three decimals (##.###).
14.123
Well done! You studied for 14.1 hours.

*/
 
/* SECOND RUN

Please enter your first name:
(Please capitalize the first letter)
huck
Please enter your first name:
(Please capitalize the first letter)
Huck
Please enter your last name:
(Please capitalize the first letter)
finn
Please enter your last name:
(Please capitalize the first letter)
Finn
Your full name is: Huck Finn
and it is 9 characters long.
Your full name in upper case is: HUCK FINN
Your full name in lower case is: huck finn
You should have studied between 12 and 20 hours this week.
Please enter the number of hours you spent studying to three decimals (##.###).
22.123
You should have studied between 12 and 20 hours this week.
Please enter the number of hours you spent studying to three decimals (##.###).
8
You should have studied between 12 and 20 hours this week.
Please enter the number of hours you spent studying to three decimals (##.###).
16.543
Well done! You studied for 16.5 hours.


*/
