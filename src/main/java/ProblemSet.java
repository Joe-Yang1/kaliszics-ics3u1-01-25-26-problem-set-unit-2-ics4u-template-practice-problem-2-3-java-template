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
		String status = "Invalid";
		String issue = "";
	
		int atSymbol = mail.indexOf("@");
		int anotherAtSymbol = mail.lastIndexOf("@");

			if (atSymbol == -1){							
			status = "Invalid"; 			// checks if there is a @ symbl present
		}
			else if (atSymbol != anotherAtSymbol){
				status = "Invalid";
				issue = "gmail contains multiple @ symbols";		//  checks if there is multiple @ symbols contained in the input
		}
			else {
				status = "Valid";
			}

				if (status.equals("Valid") && (mail.startsWith(".")) || (mail.endsWith("."))){
					status = "Invalid";
					issue =  "gmail either started with or ended with a period";
				}

				if (status.equals("Valid") && (mail.contains(" "))){
					status = "Invalid";
					issue = "gmail contains a space";
				}

		String beforeAtSymbol = "";
		String afterAtSymbol = "";

			if (status.equals("Valid")){
				beforeAtSymbol = mail.substring(0, atSymbol); 	// all characters before the @ symbol
				afterAtSymbol = mail.substring(atSymbol, + 1); 	// all character after the @ symbol
			}

			if (beforeAtSymbol.length() < 1){
				status = "Invalid";
				issue = "gmail contains less than 1-64 characters";
			}

			else if (beforeAtSymbol.length() > 64){
				status =  "Invalid";
				issue = "gmail contains more than 1-64 characters";
			}

			int periodSymbol = afterAtSymbol.indexOf(".");
				if (status.equals("Valid") && periodSymbol == -1){
					status = "Invalid";
					issue = "gmail does not contain a period in the domain";
			}

			if (status.equals("Valid")){
				String afterPeriod = afterAtSymbol.substring(periodSymbol + 1);
				int domainExpansion = afterPeriod.length();
					if (domainExpansion < 2){
						status = "Invalid";
						issue = "gmail's domain expansion after the period includes less than 2 characters";
					}

					else if (domainExpansion > 6){
							status = "Invalid";
							issue = "gmail's domain expansion after the period includes more than 6 characters";
					}

					else {
						status = "Valid";
					}
						
			}
			
		if (status.equals("Valid")){
			System.out.println(issue);
		}

		else {
			System.out.println("Valid");
		}
	}
}

			
	

