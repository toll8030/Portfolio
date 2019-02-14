
public class Enemy {
	private int health;
	private int attack;
	private int initiative;
	private int CR;
	private String name;
	
	public Enemy(int i){
		if (i ==1){   
			name = "beetle";
			health = 5;
			attack = 1;
			initiative = 3; 
			CR = 1;
		}else if (i == 2){  
			name = "mole";
			health = 10;
			attack = 3;
			initiative = 1; 
			CR = 2;
		}else if (i == 3){  
			name = "badger";
			health = 20;
			attack = 5;
			initiative = 2; 
			CR = 3;
		}
		
	}
	
	public void bleeds(int d){
		health -= d;
	}
	
	public  int CR(){
		return CR;
	}
	
	public  int claw(){
		return attack;
	}
	
	public  int init(){
		return initiative;
	}
	
	public  int currentHealth(){
		return health;
	}
	
	public String name(){
		return name;
		
	}
}
