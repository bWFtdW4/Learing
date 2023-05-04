package monsterTest;

public class Player {

	private String playerName;
	private int playerLevel;
	private int playerExp;


	Player () {
		this.playerExp = 0;
		this.playerLevel = 1;
	}


	public String getPlayerName () {
		System.out.println("getPlayerName " + playerName);
		return playerName;
	}


	public void setPlayerName (String playerName) {
		System.out.println("setplayname " + playerName);
		this.playerName = playerName;
	}


	public int getPlayerLevel () {
		return playerLevel;
	}


	public void setPlayerLevel (int playerLevel) {
		this.playerLevel = playerLevel;
	}


	public int getPlayerExp () {
		return playerExp;
	}


	public void setPlayerExp (int playerExp) {
		this.playerExp = playerExp;
	}

}
