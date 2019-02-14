
public class Character {
	private int health = 30;
	private int attack = 5;
	private int initiative = 0;
	private int potions = 3;
	
	public Character(int r, int t){
		if (r ==1)
			attack += 5;
		else if (r == 2)
			initiative += 5;
		else if (r == 3)
			health += 5;
		if (t ==1)
			health += 5;
		else if (t == 2)
			initiative += 5;
		else if (t == 3)
			attack += 5;
	}
	
	public void strategize(){
		initiative += 1;
	}
	
	public void wounded(int d){
		health -= d;
	}
	
	public  int sword(){
		int damage = attack;
		return damage;
	}
	
	public  boolean block(){
		//health += 2;
		return true;
	}
	
	public  int init(){
		int i = initiative;
		return i;
	}
	
	public  int currentHealth(){
		int h = health;
		return h;
	}
	
	public  int potions(){
		int p = potions;
		return p;
	}
	
	public void addPotions(){
		potions += 1;
	}
	
	public void heal(){
		if(potions>0){
			health += 10;
			potions -= 1;
		}else
			System.out.println("You have no more potions!");
	}
}
