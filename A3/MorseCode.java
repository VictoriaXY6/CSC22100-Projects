public class MorseCode{
	//store the character values
	private char character;
	//store the encoding values which represent as the morse code of the character
	private String encoding;
	
	//non-default constructor
	public MorseCode(char character,String encoding) throws Exception{
		int ascii = character;
		//check if character of ascii is within the range of [32,90] and encoding value isn't null and of length at least one
		if((ascii >= 32 && ascii <= 90) && (encoding != null && encoding.length() >= 1)) {
			this.character = character;
			this.encoding = encoding;
		}
		//throw an exception to indicate the character can't to convert to morse code.
		else{
			throw new Exception("The character " + character + " is not a supported Morse character");
		}
	}

	//getter method for character
	public char getCharacter() {
		return character;
	}

	//setter method for character
	public void setCharacter(char character) {
		this.character = character;
	}

	//getter method for encoding
	public String getEncoding() {
		return encoding;
	}

	//setter method for encoding
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
}
