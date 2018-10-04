package recursion;

import java.util.Scanner;
/**
 * 
 * @author עימנואל
 *
 *
 *This problem has no "efficient" solution in terms of complexity;
 *In order to move n rings we shall notice that we can move n-1 rings to one place, 
 *than move the last ring to another place and finally move again (n-1) rings, thus 
 *we can conclude that NumOfSteps(n)=2*NumOfSteps(n-1)+1. 
 *By using the regression formula we observe that N(1)=1,N(2)=3,N(3)=7..- the so called
 *Mersenne primes of the form 2^n-1. 
 *Increasing the input by 1 multiply the solution by 2 and thus the complexity is O(2^n).
 *
 *
 */
public class TowersofHanoi {

	public static int moves=0;
	
	public static void hanoi(int   height, char  fromPole, char  toPole, char  withPole){

		if (height >= 1){

			hanoi(height-1, fromPole, withPole, toPole); 
			moveDisk(fromPole, toPole);
			hanoi(height-1, withPole, toPole, fromPole);
		}

	}
	static void moveDisk(char fromPole, char toPole){

		moves++;
		System.out.print(fromPole);
		System.out.print(toPole);
		System.out.print(((moves % 20)==0) ? '\n' : ' ');

	}

	public static void main(String[] args){

		long time1, time2;
		int TowerHeight;
		char FromPole='A', ToPole='C', WithPole='B';

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Tower height: ");
		TowerHeight =scanner.nextInt();
		time1 = System.currentTimeMillis();
		hanoi(TowerHeight, FromPole, ToPole, WithPole);
		time2 = System.currentTimeMillis();
		System.out.println();
		// print execution time in msec
		System.out.println(time2-time1+" msec execution time"); 
		System.out.println(moves+" moves"); 
		scanner.close();
	}
}



