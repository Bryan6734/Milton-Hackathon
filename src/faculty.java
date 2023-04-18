import java.lang.Math;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

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


    public void takeOffBelay(faculty enemy) {
        System.out.println(name + " used TAKE OFF BELAY on " + enemy.name + "!");
    }

    public void RedactleReveal(faculty enemy){
        System.out.println(name+" used REDACTLE REVEAL on "+enemy.name+"!");

        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }


    public void dadHumor(faculty enemy){
        System.out.println(name+" used DAD HUMOR on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        String[] dadJokes = {
                "Why did the rock climber bring extra chalk? In case he wanted to get a grip on things!",
                "What's a rock climber's favorite kind of tea? High tea!",
                "Why do rock climbers make bad comedians? Because they always bomb!",
                "What did the rock climber say when he reached the top? Nothing, he was boulder than words!",
                "Why do rock climbers love camping? Because they get to pitch a tent!"
        };

        int random = (int)(Math.random()*dadJokes.length);
        System.out.println(dadJokes[random]);
        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }

    public void bubbleTeaTsunami(faculty enemy){

        System.out.println(name+" used BUBBLE TEA TSUNAMI on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        // minus damage
        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");

    }

    public void boulderBash(faculty enemy){
        System.out.println(name+" used BOULDER BASH on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }


    public void IHaveTheHighGround(faculty enemy) {
        System.out.println(name + " used I HAVE THE HIGH GROUND on " + enemy.name + "!");
        damage = (int) (Math.random() * 100 + 50);

        enemy.health = enemy.health - (int) (damage);
        System.out.println(name + " inflicted " + damage + " damage on " + enemy.name + "!");
        System.out.println(enemy.name + "'s health is now " + enemy.health + "!");
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

    public void selfAppreciation(faculty enemy){
        System.out.println(name+" used SELF APPRECIATION on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        String[] appreciation = {
                "You're doing great!",
                "You're a rockstar!",
                "You're a superstar!",
                "You're a champion!",
                "You're a legend!"
        };

        int random = (int)(Math.random()*appreciation.length);
        System.out.println(appreciation[random]);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }

    public void matchStickMadness(faculty enemy){
        System.out.println(name+" used MATCH STICK MADNESS on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }

    public void terminalTornado(faculty enemy){

        System.out.println(name+" used TERMINAL TORNADO on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }

    public void wrestlingWipeout(faculty enemy){
        System.out.println(name+" used WRESTLING WIPEOUT on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }

    public void summonForbesBoys(faculty enemy){

        System.out.println(name+" summoned FORBES BOYS on " +enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }

    public void matrixMultiplication(faculty enemy){
        System.out.println(name+" used MATRIX MULTIPLICATION on "+enemy.name+"!");
        damage = (int)(Math.random()*100+50);

        enemy.health = enemy.health - (int)(damage);
        System.out.println(name+" inflicted "+damage+" damage on "+enemy.name+"!");
        System.out.println(enemy.name+"'s health is now "+enemy.health+"!");
    }
}
