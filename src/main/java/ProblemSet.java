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
				System.out.println("Invalid: gmail does not contain a @ symbol");
				return;			
		}
				if (atSymbol != anotherAtSymbol){	
					System.out.println("Invalid: gmail contains multiple @ symbols");
					return;
				}

					if (mail.startsWith(".") || (mail.endsWith("."))){
						System.out.println("Invalid: gmail either starts with or ends with a period");
						return;
				}

					if (mail.contains(" ")){
						System.out.println("Invalid: gmail contains a space");
						return;
					}

					beforeAtSymbol = mail.substring(0, atSymbol); 	// all characters before the @ symbol
					afterAtSymbol = mail.substring(atSymbol + 1); 	// all character after the @ symbol

				if (beforeAtSymbol.length() < 1 || beforeAtSymbol.length() > 64){
					System.out.println("Invalid: gmail either contains less than 1 or contains more than 64 characters");
					return;
				}

			int periodSymbol = afterAtSymbol.lastIndexOf(".");
				if (periodSymbol == -1){
					System.out.println("Invalid: gmail does not contain a period in the domain");
					return;
			}

		afterPeriod = afterAtSymbol.substring(periodSymbol + 1);
			int domainExtension = afterPeriod.length();
				if (domainExtension < 2 || (domainExtension > 6)){
					System.out.println("gmail's domain extension does not contain less than 2 and more than 6 characters");
					return;
		}
	
	System.out.println("Valid");
	}
}

			
	

