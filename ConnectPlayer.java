
public abstract class ConnectPlayer {
	private int playerID;
	private boolean isTurn;
	private boolean hasWon = false;
	
	void setPlayerID(int id) {
		playerID = id;
	}
	int getPlayerID() {
		return playerID;
	}
	
	void setHasWon(boolean in) {
		hasWon = in;
	}
	boolean getHasWon() {
		return hasWon;
	}
	
	void setIsTurn(boolean in) {
		isTurn = in;
	}
	boolean getIsTurn() {
		return isTurn;
	}
}
