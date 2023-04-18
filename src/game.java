import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class game implements Runnable, KeyListener, MouseListener {

    // CREATE NEW INSTANCE OF THE GAME
    public static void main(String[] args) {
        game ex = new game();
        new Thread (ex).start();
    }

    // WINDOW SETTINGS
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public JButton fight;
    public BufferStrategy bufferStrategy;

    // ANIMATION GIFS
    public Image flamethrower_anim;
    public Image magmastorm_anim;
    public Image hydrocannon_anim;
    public Image volcanicgeyser_anim;

    public Image rockfall_anim;
    public Image earthquake_anim;
    public Image tectonicbarrier_anim;


    // POKEMON VARIABLES
    public faculty mrChun;
    public faculty msKilliam;


    // AUDIO
    public SoundFile titlescreen_music;
    public SoundFile intro_music;
    public SoundFile battle_music;
    public SoundFile megagarchomp_music;
    public SoundFile battle2_music;



    // IMAGES AND GIFS
    public Image titlescreen;
    public Image idleChun;
    public Image idleHales;
    public Image stars;
    public Image battle1Backdrop;
    public Image healthbar;

    // IMAGE BOOLEANS

    public int stageBackdrop = -1;
    public int animation_playing = 0;


    // VARIABLE DECLARATION SECTION
    public game(){

        setUpGraphics();

        mrChun = new faculty("Mr. Chun",500,true);
        msKilliam = new faculty("Mr. Killiam",500,true);

        // TITLE SCREEN

        // POKEMON & OBJECT IMAGES & GIFS + SOUND

        titlescreen = Toolkit.getDefaultToolkit().getImage("download.jpeg");


        idleChun = Toolkit.getDefaultToolkit().getImage("chun-character.png");
        idleHales = Toolkit.getDefaultToolkit().getImage("idleGarchomp.gif");

        stars = Toolkit.getDefaultToolkit().getImage("selectPokemon.png");
        battle1Backdrop = Toolkit.getDefaultToolkit().getImage("dayforest.jpeg");
        healthbar = Toolkit.getDefaultToolkit().getImage("healthbar.png");

        // ANIMATIONS

        titlescreen_music = new SoundFile("01 Game Freak Logo.wav");
        intro_music = new SoundFile("02 Opening Movie.wav");
        battle_music = new SoundFile("11 Battle! (Trainer Battle).wav");

        // SETTING POSITIONS

        mrChun.xpos = 100; mrChun.ypos = 150;
        mrChun.width = 300; mrChun.height = 255;


        msKilliam.xpos = 550; msKilliam.ypos = 160;
        msKilliam.width = 300; msKilliam.height = 300;
    }

    // GAME PROGRESSION (starts methods)
    public void run(){

        Thread renderEx = new Thread(){
            public void run(){
                while (true){
                    render();
                    pause(60);
                }
            }
        };
        Thread gameEx = new Thread(){
            public void run(){
                titleScreen();
                battle1();

            }
        };

        renderEx.start();
        gameEx.start();
    }

    Scanner input = new Scanner(System.in);

    public void titleScreen(){
        titlescreen_music.setVolume(0.1f);
        titlescreen_music.play(); // will not loop
        stageBackdrop = -1;
        System.out.println("╔══════════════════════════════════════════════╗");

        System.out.println("*** CONSOLE: titleScreen() Started");
        System.out.print("Type anything to begin your adventure.");
        String start = input.next();
        System.out.println("╚══════════════════════════════════════════════╝");
        titlescreen_music.stop();

    }


    // GARCHOMP BATTLE
    public void battle1(){
        stageBackdrop = 1;
        battle_music.setVolume(0.1f);
        battle_music.loop();

        // position user here

        System.out.println("╔══════════════════════════════════════════════╗");

        System.out.println("*** CONSOLE: battle1() Started");

        for (int turn = 1; msKilliam.health>0; turn++){
            if (msKilliam.health <= 0){
                System.out.println("You have WON!");
                break;
            }
            System.out.println("═════════════════════");
            System.out.println("Turn "+turn);
            moveSystemUser();
            if (msKilliam.health <= 0){
                System.out.println("You have WON!");
                break;
            }
            pause(1000);
            moveSystemEnemy();

        }
        System.out.println("╚══════════════════════════════════════════════╝");
        battle_music.stop();
        pause(4000);
    }


    public void battle2(){

    }


    // MOVE SYSTEMS FOR USER AND ENEMY
    public void moveSystemUser() {
        System.out.println("Select 1 MOVE:");

        System.out.println("[1] PRINT MOVE");
        System.out.println("[2] PRINT MOVE");

        System.out.println("══════════");
        String move = input.next();

        if (move.matches("(?i)1||2")) {
            if (move.equals("1")) {
                animation_playing = 1;
            }

            if (move.equals("2")) {
                animation_playing = 2;
                //chun.domove
            }

            animation_playing = 0;
        } else {
            moveSystemUser();
        }

    }
    public void moveSystemEnemy(){
        System.out.println("══════════");
        int chance = (int) (Math.random() * 10);

        if (chance<3){
            msKilliam.RedactleReveal(mrChun);

            // Faculty move 1

        }
        if (chance>=3 && chance<8){
            msKilliam.OutdoorProgramPummel(mrChun);

            // Faculty move 2 method
            // Set animation playing

        }
        if (chance>=8){
            msKilliam.RobbinsRush(mrChun);

            // FAculty move 3 method
            // Set animation playing
        }

        // Reset
        animation_playing = 0;
    }

    // BACK-END
    public void pause(int time ){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }
    private void setUpGraphics() {
        frame = new JFrame("Chun Boss Battle");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.addKeyListener(this);
        canvas.addMouseListener(this);
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        if (stageBackdrop==-1){
            g.drawImage(titlescreen, 0, 0, 1000, 700, null);
        }

        if (stageBackdrop==0){
            g.drawImage(stars,-5,-5,1050,750,null);
            g.drawImage(idleChun, mrChun.xpos, mrChun.ypos, mrChun.width, mrChun.height,null);

        }
        if (stageBackdrop==1){


                g.drawImage(battle1Backdrop,-5,-5,1050,750,null);
                g.drawImage(idleChun, mrChun.xpos, mrChun.ypos, mrChun.width, mrChun.height,null);
                g.drawImage(idleHales, msKilliam.xpos, msKilliam.ypos, msKilliam.width, msKilliam.width,null);
                g.setColor(Color.green);

                g.fillRect(660, 130, (int)(msKilliam.health/4.5), 10); // garchomp
                g.fillRect(305, 330, (int)(mrChun.health/4.5), 10); // charizarwd
                // 110
                g.drawImage(healthbar, 600,110,200,55,null); // garchomp
                g.drawImage(healthbar, 245,310,200,55,null); // charizard

        }

        if (stageBackdrop == 2){

        }



        g.dispose();
        bufferStrategy.show();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();


        if (key==87){ // key "W"
            System.out.println("W");
        }
        if (key==65){ // key "A"
            System.out.println("A");
        }
        if (key==83){ // key "S"
            System.out.println("S");
        }
        if (key==68){ // key "D"
            System.out.println("D");
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // CHECK USER ALIVE



}
