import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer{
	public static int takeTurn() {
		Random rng = new Random();
		int compChoice = rng.nextInt(7);
		if(compChoice == 6) {
			compChoice -= 1;
		}
		if(compChoice == 0) {
			compChoice += 1;
		}
		return compChoice;
	}
}
