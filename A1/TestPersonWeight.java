import java.util.Scanner;

public class TestPersonWeight{
	public static void main(String[] args) {
		PersonWeight person1 = new PersonWeight();
		person1.setFullName("Kate Williams");
		person1.setYearOfBirth(2000);
		person1.setHeight(1.68);
		person1.setWeight(56.8);
	  //System.out.printf("%s%n%d%n%.2f%n%.2f%n%n", person1.getFullName(), person1.getYearOfBirth(), person1.getHeight(), person1.getWeight());
		Scanner input = new Scanner(System.in);
		System.out.printf("%s", "Enter person's name: ");
		String fullName = input.nextLine();
		System.out.printf("%s", "Enter person's year of birth: ");
		int yearOfBirth = input.nextInt();
		System.out.printf("%s", "Enter person's height in meters: ");
		double height = input.nextDouble();
		System.out.printf("%s", "Enter person's weight in kilograms: ");
		double weight = input.nextDouble();		
		PersonWeight person2 = new PersonWeight(fullName, yearOfBirth, height, weight);
		System.out.printf("%16s%s%n", "Full Name: ", person2.getFullName());
		System.out.printf("%16s%d%n", "Age: ",person2.computeAge());
		System.out.printf("%16s%.2f%n", "Height: ", person2.getHeight());
		System.out.printf("%16s%.2f%n", "Weight: ", person2.getWeight());
		System.out.printf("%16s%s%n", "Classification: ", classifyBMI(person2.computeBMI()));
		input.close();
	}
	
	public static String classifyBMI(double BMI) {
		if(BMI < 18.5) {
			return "Underweight";
		} else if(BMI >= 18.5 && BMI < 25.0) {
			return "Normal Weight";
		} else if(BMI >= 25.0 && BMI < 30.0) {
			return "Overweight";
		} else {
			return "Obese";
		}
	}
}
	
		
		
	
