import java.util.Scanner;
/*
 * Annabel Strauss
 * February 2016
 * String.format("%.2f", floatValue);
 */
public class ACSL2_string15_c16as {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String float_exp = "";
		float float_real = 0;
		int length = 0;
		int decimal = 0;
		int count = 0;
		String with_decimals = "";
		String sign = "";
		
		
		for (int i = 0; i < 12; i++) {
			
			//take in the input
			String[] input = scan.nextLine().split(", ");
			float_exp = input[0]; 
			sign = float_exp.substring(0,1); //get the sign 
			float_real = Float.parseFloat(input[0]);
			length = Integer.parseInt(input[1]);
			decimal = Integer.parseInt(input[2]);
			
			
			with_decimals = String.format("%." + decimal + "f", float_real);
			
			if(sign.equals("+"))
			{
				with_decimals = "+"+with_decimals;
			}
			
			if (with_decimals.length() == length)
			{
				System.out.println(with_decimals);
			}
			else if (with_decimals.length() > length)
			{
				String hash_string = "";
				int new_length = 0;
				new_length = length-1;
				for (int j = 0; j < new_length; j++) 
				{
					hash_string = hash_string += "#";
				}
				hash_string = hash_string.substring(0, (hash_string.length() - decimal)) + "." + hash_string.substring((hash_string.length() - decimal));
				System.out.println(hash_string);	
			}
			else if (with_decimals.length() < length)
			{
				String hash_string = "";
				int new_length = 0;
				new_length = length - with_decimals.length();
				for (int j = 0; j < new_length; j++) 
				{
					hash_string = hash_string += "#";
				}
				System.out.println(hash_string + with_decimals);
			}
			
		
			
			
		
		}//big for
		
	}//main
}//class 
