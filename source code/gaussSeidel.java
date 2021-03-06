

/*
Author Name:  		Tony Josi
Email ID:       	tonyjosinew@gmail.com
GitHub:         	https://github.com/TonyJosi97 
Latest Update Date:	16 May 2017
*/


/*
*********************************************************************************************
#
#                   Copyright (c) 2017 Tony Josi --- 4 may 2017
#	
#	Permission is hereby granted, free of charge, to any person obtaining
#   a copy of this software and associated documentation files (the "Software"), 
#   to deal in the Software without restriction, including without limitation 
#   the rights to use, copy, modify, merge, publish, distribute, sublicense, 
#   and/or sell copies of the Software,and to permit persons to whom the Software
#   is furnished to do so, subject to the following conditions:
#	The above copyright notice and this permission notice shall be included in 
#   all copies or substantial portions of the Software.
#	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
#   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
#   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
#   THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
#   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
#   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE 
#   SOFTWARE.
#   
#   Massachusetts Institute of Technology, Cambridge, Massachusetts, United States of America.
***********************************************************************************************
*/



import java.text.*;
import java.util.Scanner;
public class gaussSeidel
{
	public static void main(String[] args) 
	{
		long firstStartTime = System.currentTimeMillis();
		double d, e;										// Data type declarations
		int c, count = 0;
		double[][] quin = new double[3][4];
		double[] inter = new double[3];
		int man = 0;
		double mval = 0;

		Scanner sin = new Scanner(System.in);			                               // New Scanner object 'sin'

		inter[0] = 0;
		inter[1] = 0;
		inter[2] = 0; 

		System.out.println("Enter the number of digits needed in Mantissa(1-5):");
		man = sin.nextInt();

		switch(man)
		{
			case 1: 
				mval = 100.0;
				break;
			case 2:
				mval = 1000.0;
				break;
			case 3:
				mval = 10000.0;
				break;
			case 4:
				mval = 100000.0;
				break;
			case 5:
				mval = 1000000.0;
				break;
			default:
				System.out.println("Given Mantissa out of Range...Exiting  :(");
				System.exit(0);
		}

		System.out.println("Enter the square Matrix [3*4] in diagonally dominant form:  ");

		for(int i = 0; i < 3; i++)						              // Input a [3*4] matrix
			for(int j = 0; j < 4; j++)
				quin[i][j] = sin.nextDouble();


		long secondStartTime = System.currentTimeMillis();
		System.out.println("\n\n\nInitialy: ");			                              // Initial [XYZ]
		System.out.println("\n[    x = "+inter[0]+",    y = "+inter[1]+",    z = "+inter[2]+"    ]");

		while(1 != 0)									      // Main Computation area
		{
			c = 0;

			d = ((quin[0][3] - ((quin[0][1] * inter[1]) + (quin[0][2] * inter[2]))) / quin[0][0]);
			e = (double)Math.round(d * mval) / mval;
			if (inter[0] == e)
				c++;
			inter[0] = e;

			d = ((quin[1][3] - ((quin[1][0] * inter[0]) + (quin[1][2] * inter[2]))) / quin[1][1]);
			e = (double)Math.round(d * mval) / mval;
			if (inter[1] == e)
				c++;
			inter[1] = e;

			d = ((quin[2][3] - ((quin[2][0] * inter[0]) + (quin[2][1] * inter[1]))) / quin[2][2]);
			e = (double)Math.round(d * mval) / mval;
			if (inter[2] == e)
				c++;
			inter[2] = e;

			if (c == 3)
				break;

			count++;

			System.out.println("\n\n\nStatus After "+count+" iteration:  ");            // Displays status after each Iteration.
			System.out.println("\n[    x = "+inter[0]+",    y = "+inter[1]+",    z = "+inter[2]+"    ]");

			if (count == 25)
				break;
			
		}
		
		
		System.out.println("\n\n\n\n**************************************************");	//Final Stats
		System.out.println("Final Stats: \n");
		System.out.println("Computation completed in "+count+" iterations");
		System.out.println("Numbers are rounded to "+man+" decimal places");
		if (count == 25)
			System.out.println("**NOTE**	->  Forced completion in 25th iteration.....");
		System.out.println("Final Answer: ");
		System.out.println("[    x = "+inter[0]+",    y = "+inter[1]+",    z = "+inter[2]+"    ]");
		long endTime   = System.currentTimeMillis();
		long totalExeTime = endTime - firstStartTime;
		long totalCompTime = endTime - secondStartTime;
		System.out.println("Total Execution time: "+totalExeTime+"ms");
		System.out.println("Total Computation time: "+totalCompTime+"ms");
		System.out.println("**************************************************");
	}
}
