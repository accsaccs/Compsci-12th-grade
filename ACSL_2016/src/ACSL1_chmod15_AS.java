import java.util.Scanner;

/*
 * 1. take in input
 * 2. separate 1st digit and last digits 
 * 3. convert the octal number to binary 
 */
public class ACSL1_chmod15_AS {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int special = 0;
		int octal1 = 0;
		int octal2 = 0;
		int octal3 = 0;
		
		for (int i = 0; i < 12; i++) {
			
			//take in the input
			String[] input = scan.nextLine().split(", ");
			special = Integer.parseInt(input[0]);
			octal1 = Integer.parseInt(input[1]);
			octal2 = Integer.parseInt(input[2]);
			octal3 = Integer.parseInt(input[3]);
			
			//convert to binary list 
			String binary1 = String.format("%3s", Integer.toBinaryString(octal1)).replace(" ", "0");
			String binary2 = String.format("%3s", Integer.toBinaryString(octal2)).replace(" ", "0");
			String binary3 = String.format("%3s", Integer.toBinaryString(octal3)).replace(" ", "0");
			String binarylist = binary1 + " " + binary2 + " " + binary3;
			
			//convert to permissions 
			String[] nums = new String[3];
			nums[0] = input[1];
			nums[1] = input[2];
			nums[2] = input[3];
			StringBuilder sb = new StringBuilder();
		    for (String s : nums) {
		        if (sb.length() > 0) sb.append(" ");
		        int num = Integer.parseInt(s);
		        sb.append((num & 4) == 0 ? '-' : 'r');
		        sb.append((num & 2) == 0 ? '-' : 'w');
		        sb.append((num & 1) == 0 ? '-' : 'x');
		    }
		    String permissions = sb.toString();
		    char[] perm_array = permissions.toCharArray();
		    
		    //System.out.println(binarylist + " and " + permissions);
		    
			//special permission thing
		    if(special == 1 && perm_array[2] == 'x')
		    {
		    	perm_array[2] = 's';
		    }
		    else if(special == 2 && perm_array[6] == 'x')
		    {
		    	perm_array[6] = 's';
		    }
		    else if(special == 4 && perm_array[10] == 'x')
		    {
		    	perm_array[10] = 't';
		    }
		    String permissions_final = String.valueOf(perm_array);
		    System.out.println(binarylist + " and " + permissions_final);
		    

		}//close for i
	}//close main 
	
	
	
	
}
