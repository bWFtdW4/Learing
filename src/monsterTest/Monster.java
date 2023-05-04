package monsterTest;

public class Monster {

	private String monsterName;
	private int monsterHp;
	private int monsterMaxHp;
	private int monsterLevel;
	private int monsterExp;


	Monster (String name, int hp, int maxHp, int level, int exp) {
		setMonsterName(name);
		setMonsterExp(exp);
		setMonsterHp(hp);
		setMonsterMaxHp(maxHp);
		setMonsterLevel(level);
	}


	public String getMonsterName () {
		return monsterName;
	}


	public void setMonsterName (String monsterName) {
		this.monsterName = monsterName;
	}


	public int getMonsterHp () {
		return monsterHp;
	}


	public void setMonsterHp (int monsterHp) {
		this.monsterHp = monsterHp;
	}


	public int getMonsterLevel () {
		return monsterLevel;
	}


	public void setMonsterLevel (int monsterLevel) {
		this.monsterLevel = monsterLevel;
	}


	public int getMonsterExp () {
		return monsterExp;
	}


	public void setMonsterExp (int monsterExp) {
		this.monsterExp = monsterExp;
	}


	public int getMonsterMaxHp () {
		return monsterMaxHp;
	}


	public void setMonsterMaxHp (int monsterMaxHp) {
		this.monsterMaxHp = monsterMaxHp;
	}


	public int attack () {
		int power = ((int) Math.random() * getMonsterLevel() + 1) + 1;

		return power;
	}
	
	public String aMonsterApearrs() {
		return "		" + monsterName + "			" + monsterLevel;
	}
	
	@Override
	public String toString () {
		return "\t\t" + monsterName + "\t\t" + monsterLevel + "\t\t" + monsterHp + "\t\t" + monsterExp;
	}

}