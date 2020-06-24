import java.util.GregorianCalendar;

public class PersonWeight {
		private String fullName;
		private int yearOfBirth;
		private double height;
		private double weight;
		
		public PersonWeight() {
			fullName = null;
			yearOfBirth = 0;
			height = 0.0;
			weight = 0.0;
		}
		
		public PersonWeight(String fullName, int yearOfBirth, double height, double weight) {
			this.fullName = fullName;
			this.yearOfBirth = yearOfBirth;
			this.height = height;
			this.weight = weight;
		}
			
		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public int getYearOfBirth() {
			return yearOfBirth;
		}

		public void setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public int computeAge() {
			return new GregorianCalendar().get(GregorianCalendar.YEAR) - yearOfBirth;
		}
		
		public double computeBMI() {
			return weight / (height * height);
		}
}
