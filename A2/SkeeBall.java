import java.util.Scanner;
import java.security.SecureRandom;

public class SkeeBall {
	//the constant maximum number of the times of play allowed
	private final static int MAX_PLAYS = 8; 
	
	public static void main(String[] args) {
		//create a Scanner to obtain input from the commend line
		Scanner input = new Scanner(System.in);
		//store the number of play
		int numOfPlay;
		//run the do while loop until the number of times of play is valid
		do {
			System.out.print("How many plays (1-8)? ");
			//enter number of play
			numOfPlay = input.nextInt();
			//show the invalid case when the input is out of range by printing 
			//out the error message
			if(numOfPlay < 1 || numOfPlay > MAX_PLAYS) {
				System.out.println("Invalid input. Please enter a number between 1 and 8.");
			}
		} while(numOfPlay < 1 || numOfPlay > MAX_PLAYS);
		//create an instance of class SkeeBall to invoke the method play and the method showStats
		SkeeBall game = new SkeeBall();
		//create a list to store the hall value in each play
		int list[] = new int[numOfPlay];
		//invoke the play method
		game.play(list);
		//invoke the showStats method
		game.showStats(list);
		//close the Scanner 
		input.close();
	} 
	
	//simulate the Skee-Ball game by using random generator
	public void play(int[] list) {
		//create an instance of class SecureRandom 
		SecureRandom random = new SecureRandom();
		//use this to store the random number
		int randNum;
		//simulate each play of the game
		for(int i = 0; i < list.length; i++) {
			//generate the random number between 1 to 100
			randNum = random.nextInt(100) + 1;
			//invoke hallValue method to convert random number into hall value
			//then, store the hall value in each play into the array
			list[i] = hallValue(randNum);
			//output the result
			System.out.printf("Rolling ball #%d. Landed in %d%n",i+1, list[i]);
		}
	}
	
	//convert the number from random generator to the corresponding hall value
	public int hallValue(int x) {
		int percentage;
		//test if the random number falls into the corresponding percentage
		if(x >= 1 && x <= 5) {
			percentage = 1;
		}else if(x >= 6 && x <= 15){
			percentage = 2;
		}else if(x >= 16 && x <= 30){
			percentage = 3;
	    }else if(x >= 31 && x <= 45){
			percentage = 4;
	    }else if(x >=46 && x <= 65){
			percentage = 5;
	    }else {
	    	percentage = 6;
		}
		//return the hall value corresponding to the percentage
		switch(percentage) {
			case 1:
				return 80;
			case 2:
				return 60;
			case 3:
				return 40;
			case 4:
				return 20;
			case 5:
				return 10;
			default:
				return 0;
		}
	}
	
	//show the summary of the game by showing the hall value of each play
	//and the total points
	public void showStats(int[] list) {
		//display the title
		System.out.println("");
		System.out.println("+-------+-------+");
		System.out.println("  Play #    Score");
		System.out.println("+-------+-------+");
		//store the sum of all hall value
		int total = 0;
		//display the hall value in each play
		for(int i = 0; i < list.length; i++){
			System.out.printf("%6d%7d%n", i+1, list[i]);
			total += list[i];
		}
		//display the total points
		System.out.println("");
		System.out.println("Total: " + total);
	}

}
