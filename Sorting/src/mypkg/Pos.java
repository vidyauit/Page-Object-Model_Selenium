package mypkg;
import java.util.*;
public class Pos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	       int arr[] = new int[10];
	       int i, num, n, c=0, pos=0;
	       Scanner scan = new Scanner(System.in);
		   
	       System.out.print("Enter Array Size : ");
	       n = scan.nextInt();
		   
	       System.out.print("Enter Array Elements : ");
	       for(i=0; i<n; i++)
	       {
	           arr[i] = scan.nextInt();
	       }
		   
	       System.out.print("Enter the Number to be Search...");
	       num = scan.nextInt();
		   
	       for(i=0; i<n; i++)
	       {
	           if(arr[i] == num)
	           {
	             //  c = 1;
	               pos = i+1;
	              // break;
	               System.out.print(num+ " found at position " + pos);
	           }
	         //  break;
	      // if(c == 0)
	      // {
	          
	      // }
	       else
	       {
	    	   System.out.print("Number Not Found..!!"); 
	       }
	   
	}

	}
}
