/**
	* Problem Set Unit 3: Email Validator and Parser
	* Author: Joe Yang
	* Date Created: March 27, 2026
	* Date Last Modified: April 2, 2026
	*/


import java.util.Scanner;
public class ProblemSet {

	public static void main(String args[]) {
	Scanner input = new Scanner(System.in);
	System.out.print("Input a gmail: ");
	String mail = input.nextLine();
		String beforeAtSymbol = "";
		String afterAtSymbol = "";
		String afterPeriod = "";
	
		int atSymbol = mail.indexOf("@");
		int anotherAtSymbol = mail.lastIndexOf("@");	

			if (atSymbol == -1){	
				System.out.println("Invalid: Missing @"); //looks within the input if it contains a @ synbol
				return;			
			}
				if (atSymbol != anotherAtSymbol){	
					System.out.println("Invalid: Multiple @"); // looks within the input if it contains multiple @ symbols
					return;
				}

			if (mail.startsWith(".") || (mail.endsWith("."))){
				System.out.println("Invalid: Starts or endswith dot "); //looks within the input if it begins or ends with a period
				return;
				}

		if (mail.contains(" ")){
			System.out.println("Invalid: Contains spaces"); // looks within the input if it contains any spaces
			return;
		}

	beforeAtSymbol = mail.substring(0, atSymbol); 	// all characters before the @ symbol
	afterAtSymbol = mail.substring(atSymbol + 1); 	// all character after the @ symbol

	if (beforeAtSymbol.length() < 1 || beforeAtSymbol.length() > 64){
		System.out.println("Invalid: Local part is either too short or too long" ); // looks if the input before the @ symbol contains 1-64 characters.
		return;
	}

	int periodSymbol = afterAtSymbol.lastIndexOf(".");
		if (periodSymbol == -1){
		System.out.println("Invalid: Not dot in domain"); // looks within the input if it contains a period
		return;
	}
	String anotherPeriodSymbol = ".";
		if(anotherPeriodSymbol != afterAtSymbol){
			System.out.println("Invalid: Contains multiple dots in domain extension");
			return;
		}

	afterPeriod = afterAtSymbol.substring(periodSymbol + 1);
	int domainExtension = afterPeriod.length();
		if (domainExtension < 2 || (domainExtension > 6)){
		System.out.println("Invalid: domain extension length"); // looks if the input after the @ synbol contains 2-6 characters
		return;
		}
	
	System.out.println("Valid"); // output
	}
}

			
	

