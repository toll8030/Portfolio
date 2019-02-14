import java.util.Random;
import java.util.Scanner;

public class Stage {
	private static Random gen = new Random();
	private boolean onward = true;
	private boolean alive = true;
	private boolean block = false;
	private int loot = 0;
	private int totalLoot = 0;
	private Scanner kb = new Scanner(System.in);
	
	public Stage(Character p){
		while(onward){
			int i = gen.nextInt(3)+1;
			Enemy monster = new Enemy(i);
			System.out.println("\nThere is a "+monster.name()+" blocking your path!"); 
			combat(p,monster);
			loot = (gen.nextInt(5)+1)*monster.CR();
			totalLoot += loot;
			int bonus = gen.nextInt(4)+1;
			if(bonus == 1)
				p.addPotions();
			if(alive){
				System.out.println("You gained "+loot+" shiny objects!");
//				System.out.println("Do you want to continue? (y/n) ");
//				String c = kb.next();
//				if(c.contains("n"))
//					onward = false;
			}
		}
		if(alive)
			System.out.print("YOU SURVIVED! And you gained "+totalLoot+" shiny objects!");
	}
	
	public void combat(Character p, Enemy m){
		do{
			int playerInitiative = (gen.nextInt(10)+1)+p.init();
			int monsterInitiative = (gen.nextInt(10)+1)+m.init();
			
			if (playerInitiative >= monsterInitiative){
				if(p.currentHealth()>0)
					playerTurn(p, m);
				if(m.currentHealth()>0)
					monsterTurn(p, m);
			}
			
			else if (playerInitiative < monsterInitiative){
				if(m.currentHealth()>0)
					monsterTurn(p, m);
				if(p.currentHealth()>0)	
					playerTurn(p, m);
			}
			
			System.out.println("---------------------------NEXT-ROUND--------------------------------");
		}while(m.currentHealth() > 0 && p.currentHealth() > 0 && onward);
		
		if (m.currentHealth() <= 0){
			System.out.println("YOU KILLED IT!\n");
		}else if (p.currentHealth() <= 0){
			System.out.print("You died :(\n");
			onward = false;
			alive = false;
		}
	}
	
	public void playerTurn(Character p, Enemy m){
		int playerMiss = (gen.nextInt(10)+1);
		
		System.out.println("\nYour current health is: "+p.currentHealth()+". You have "+ p.potions()+" potions left.");
		System.out.println("***ACTIONS***");
		System.out.println("(W) Block?");
		System.out.println("(A) Attack?");
		System.out.println("(S) Use healing potion?");
		System.out.println("(D) Turn back (end game)?");
		System.out.println("********");
		System.out.print("What would you like to do?: ");
		String response = kb.next();
		switch(response.toUpperCase()){
		case "W": System.out.println("You block.\n"); block = p.block(); break;
		case "A": System.out.println("You attack."); if(playerMiss>2){System.out.println("HIT!\n"); m.bleeds(p.sword());}else System.out.println("MISS.\n"); break;
		case "S": System.out.println("You use a healing potion.\n"); p.heal(); break;
		case "D": System.out.println("You turn back.\n"); onward = false; break;
		default: System.out.println("You forgot what to do.");
		}
	}
	public void monsterTurn(Character p, Enemy m){
		int monsterMiss = (gen.nextInt(10)+1);
		
		System.out.println("The "+m.name()+" attacks!");
		if(monsterMiss>4){
			if(block)
				p.wounded(m.claw()-2);
			else
				p.wounded(m.claw());
			System.out.println("IT HITS.\n");
		}else{
			System.out.println("IT MISSES.\n");
		}
	}
}
