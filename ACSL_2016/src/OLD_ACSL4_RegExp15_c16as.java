import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class OLD_ACSL4_RegExp15_c16as {

	public static void dot(String[] firstLine, String input)
	{
		for (int i = 0; i < firstLine.length; i++) {
			System.out.println(firstLine[i]);
		}
		System.out.println(input);
		
		
		ArrayList<String> matchesArray = new ArrayList<String>();
		char[] inputChars = input.toCharArray();
		char letterPre = ' ';
		char letterPost = ' ';
		for (int i = 0; i < inputChars.length; i++) 
		{
			if(inputChars[i] == '.')
			{
				letterPre = inputChars[i-1];
				letterPost = inputChars[i+1];
			}
		}
		
		//System.out.println("letterPre= " + letterPre);
		//System.out.println("letterPost= " + letterPost);

		for (int i = 0; i < firstLine.length; i++) 
		{
			char[] givenStr = firstLine[i].toCharArray();
			if(givenStr.length >= input.length())
			{
				System.out.println(firstLine[i]);
				
				for (int j = 0; j < givenStr.length; j++) 
				{
					if(givenStr[j] == letterPre && givenStr[j+2] == letterPost)
					{
						matchesArray.add(firstLine[i]);
						break;
					}
				}
			}
		}
		
		System.out.println(matchesArray);
		
	}//close dot method 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] firstLine = new String[10];
		String input = "";

		for (int i = 0; i < 15; i++) {
			//take in the input
			if(i == 0 || i == 6){
				firstLine = scan.nextLine().split(", ");
			}
			else{
				input = scan.nextLine();
				dot(firstLine, input);
			}
			
			
		}//big for
		
		
	}//main
}//class
