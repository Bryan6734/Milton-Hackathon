import java.lang.Math;

public class faculty {

    public String name;
    public int health;
    public boolean isAlive;
    public int damage;

    public String ability;

    public int xpos;
    public int ypos;
    public int width;
    public int height;


    public faculty(String pName, int pHealth, boolean pisAlive){

        name = pName;
        health = pHealth;
        isAlive = pisAlive;
        xpos = 0;
        ypos = 0;
        width = 0;
        height = 0;

    }

    // Methods for Moves


    // TEMPLATE MOVE (FOLLOW THIS FORMULA BUT CHANGE THE TEXT
    public void exampleMove(faculty enemy){
        System.out.println(name+" used MOVE NAME on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }

    public void RedactleReveal(faculty enemy){
        System.out.println(name+" used REDACTLE REVEAL on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }

    public void OutdoorProgramPummel(faculty enemy){
        System.out.println(name+" used OUTDOOR PROGRAM PUMMEL on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }

    public void RobbinsRush(faculty enemy){
        System.out.println(name+" used Robbins RUSH on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }
}
