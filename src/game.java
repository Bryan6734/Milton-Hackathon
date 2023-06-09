import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.sql.SQLOutput;
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
    public Image dadhumour_anim;
    public Image tsunami_anim;
    public Image boulder_anim;
    public Image highground_anim;
    public Image geometricgyro_anim;
    public Image mathMagic_anim;
    public Image harvard_anim;
    public Image mustang_anim;
    public Image beard_anim;



    // POKEMON VARIABLES
    public faculty mrChun;
    public faculty msKilliam;
    public faculty mxBradford;
    public faculty msLockwood;
    public faculty mrHales;
    public faculty mrHussain;


    // AUDIO
    public SoundFile titlescreen_music;
    public SoundFile intro_music;
    public SoundFile battle_music;
    public SoundFile megagarchomp_music;
    public SoundFile battle2_music;



    // IMAGES AND GIFS
    public Image titlescreen;

    public Image stars;
    public Image battle1Backdrop;
    public Image battle5Backdrop;
    public Image healthbar;
    public Image idleChun;
    public Image idleHales;
    public Image idleKilliam;
    public Image idleLockwood;
    public Image idleHussain;
    public Image idleBradford;

    public Image forbesRush1;
    public Image forbesRush2;

    public Image matrix;
    public Image wrestling;

    // IMAGE BOOLEANS

    public int stageBackdrop = -1;

    public String anim = "";

    // VARIABLE DECLARATION SECTION
    public game(){

        setUpGraphics();

        mrChun = new faculty("Mr. Chun",500,true);
        msKilliam = new faculty("Mr. Killiam",500,true);
        mxBradford = new faculty("Mx. Bradford", 500, true);
        mrHales = new faculty("Mr. Hales", 500, true);
        mrHussain = new faculty("Mr. Hussain", 500, true);
        msLockwood = new faculty("Ms. Lockwood", 500, true);

        // TITLE SCREEN

        // POKEMON & OBJECT IMAGES & GIFS + SOUND

        titlescreen = Toolkit.getDefaultToolkit().getImage("download.jpeg");


        idleChun = Toolkit.getDefaultToolkit().getImage("mrchun.png");
        idleHales = Toolkit.getDefaultToolkit().getImage("mrhales.png");
        idleBradford = Toolkit.getDefaultToolkit().getImage("mxbradford.png");
        idleLockwood = Toolkit.getDefaultToolkit().getImage("mslockwood.png");
        idleKilliam = Toolkit.getDefaultToolkit().getImage("mrkilliam.png");
        idleHussain = Toolkit.getDefaultToolkit().getImage("mrhussain.png");

        forbesRush1 = Toolkit.getDefaultToolkit().getImage("qayson.png");
        forbesRush2 = Toolkit.getDefaultToolkit().getImage("liam.png");

        stars = Toolkit.getDefaultToolkit().getImage("selectPokemon.png");
        battle1Backdrop = Toolkit.getDefaultToolkit().getImage("dayforest.jpeg");
        battle5Backdrop = Toolkit.getDefaultToolkit().getImage("icebackground.jpeg");
        healthbar = Toolkit.getDefaultToolkit().getImage("healthbar.png");

        matrix = Toolkit.getDefaultToolkit().getImage("matrix.gif");
        wrestling = Toolkit.getDefaultToolkit().getImage("wrestling.gif");
        // ANIMATIONS

        titlescreen_music = new SoundFile("01 Game Freak Logo.wav");
        intro_music = new SoundFile("02 Opening Movie.wav");
        battle_music = new SoundFile("11 Battle! (Trainer Battle).wav");

        dadhumour_anim = Toolkit.getDefaultToolkit().getImage("dadhumour.gif");
        tsunami_anim = Toolkit.getDefaultToolkit().getImage("tsunami.gif");
        boulder_anim = Toolkit.getDefaultToolkit().getImage("boulder.gif");
        highground_anim = Toolkit.getDefaultToolkit().getImage("highground.gif");
        geometricgyro_anim = Toolkit.getDefaultToolkit().getImage("gyroscope.gif");
        mathMagic_anim = Toolkit.getDefaultToolkit().getImage("mathMagic.gif");
        harvard_anim = Toolkit.getDefaultToolkit().getImage("harvard.gif");
        mustang_anim = Toolkit.getDefaultToolkit().getImage("mustang.gif");
        beard_anim = Toolkit.getDefaultToolkit().getImage("beard.gif");


        // SETTING POSITIONS

        mrChun.xpos = 200; mrChun.ypos = 450;
        mrChun.width = 300; mrChun.height = 255;

        // put bradford right below health bar. it should be in a different place than mr chun
        mxBradford.xpos = 600; mxBradford.ypos = 150;
        mxBradford.width = 300; mxBradford.height = 300;

        mrHales.xpos = 600; mrHales.ypos = 150;
        mrHales.width = 300; mrHales.height = 300;

        mrHussain.xpos = 600; mrHussain.ypos = 150;
        mrHussain.width = 300; mrHussain.height = 300;

        msLockwood.xpos = 600; msLockwood.ypos = 150;
        msLockwood.width = 300; msLockwood.height = 300;

        msKilliam.xpos = 600; msKilliam.ypos = 150;
        msKilliam.width = 300; msKilliam.height = 300;





//
//
//        msKilliam.xpos = 550; msKilliam.ypos = 160;
//        msKilliam.width = 300; msKilliam.height = 300;
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


                bradfordBattle();
                mrChun.health = 500;
                hussainBattle();
                mrChun.health = 500;
                lockwoodBattle();
                mrChun.health = 500;
                killiamBattle();
                mrChun.health = 500;
                halesBattle();


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

    public void bradfordBattle(){

        battle_music.setVolume(0.1f);
        battle_music.play(); // will not loop
        stageBackdrop = 1;

        System.out.println("╔══════════════════════════════════════════════╗");

        System.out.println("*** CONSOLE: bradfordBattle() Started");

        for (int turn = 1; mxBradford.health>0; turn++) {
            if (mxBradford.health <= 0) {
                System.out.println("You have WON!");
                break;
            }
            System.out.println("═════════════════════");
            System.out.println("Turn " + turn);
            moveSystemUser(mxBradford);

            if (mxBradford.health <= 0) {
                System.out.println("You have WON!");
                break;
            }
            pause(1000);
            System.out.println("═════════════════════");
            moveBradfordEnemy();
        }


    }

    public void hussainBattle(){
        stageBackdrop = 2;
        battle_music.setVolume(0.1f);
        battle_music.loop();

        // position user here

        System.out.println("╔══════════════════════════════════════════════╗");

        System.out.println("*** CONSOLE: hussainBattle() Started");

        for (int turn = 1; mrHussain.health>0; turn++){
            if (mrHussain.health <= 0){
                System.out.println("You have WON!");
                break;
            }
            System.out.println("═════════════════════");
            System.out.println("Turn "+turn);
            moveSystemUser(mrHussain);

            if (mrHussain.health <= 0){

                System.out.println("You have WON!");
                break;
            }
            pause(1000);
            System.out.println("═════════════════════");
            moveHussainEnemy();
        }
        System.out.println("╚══════════════════════════════════════════════╝");
        battle_music.stop();
        pause(1000);
    }

    public void lockwoodBattle(){

        stageBackdrop = 3;
        battle_music.setVolume(0.1f);
        battle_music.loop();

        System.out.println("╔══════════════════════════════════════════════╗");

        System.out.println("*** CONSOLE: lockwoodBattle() Started");

        for (int turn = 1; msLockwood.health>0; turn++){
            if (msLockwood.health <= 0){
                System.out.println("You have WON!");
                break;
            }
            System.out.println("═════════════════════");
            System.out.println("Turn "+turn);
            moveSystemUser(msLockwood);

            if (msLockwood.health <= 0){

                System.out.println("You have WON!");
                break;
            }
            pause(1000);
            System.out.println("═════════════════════");
            moveLockwoodEnemy();
        }

        System.out.println("╚══════════════════════════════════════════════╝");
        battle_music.stop();
        pause(4000);

    }

    public void killiamBattle(){
        stageBackdrop = 4;
        battle_music.setVolume(0.1f);
        battle_music.loop();

        // position user here

        System.out.println("╔══════════════════════════════════════════════╗");

        System.out.println("*** CONSOLE: killiamBattle() Started");

        for (int turn = 1; msKilliam.health>0; turn++){
            if (msKilliam.health <= 0){
                System.out.println("You have WON!");
                break;
            }
            System.out.println("═════════════════════");
            System.out.println("Turn "+turn);
            moveSystemUser(msKilliam);



            if (msKilliam.health <= 0){

                System.out.println("You have WON!");
                break;
            }
            pause(1000);
            System.out.println("═════════════════════");
            moveKilliamEnemy();

        }
        System.out.println("╚══════════════════════════════════════════════╝");
        battle_music.stop();
        pause(4000);
    }

    public void halesBattle(){

        stageBackdrop = 5;
        battle_music.setVolume(0.1f);
        battle_music.loop();

        // position user here
        System.out.println("╔══════════════════════════════════════════════╗");

        System.out.println("*** CONSOLE: halesBattle() Started");

        for (int turn = 1; mrHales.health>0; turn++){
            if (mrHales.health <= 0){
                System.out.println("You have WON!");
                break;
            }
            System.out.println("═════════════════════");
            System.out.println("Turn "+turn);
            moveSystemUser(mrHales);

            if (mrHales.health <= 0){

                System.out.println("You have WON!");
                break;
            }
            pause(1000);
            System.out.println("═════════════════════");
            moveHalesEnemy();

        }
        System.out.println("╚══════════════════════════════════════════════╝");
        battle_music.stop();
        pause(4000);




    }


    // MOVE SYSTEMS FOR USER AND ENEMY
    public void moveSystemUser(faculty enemy) {
        System.out.println("Select 1 MOVE:");

        // list all chun moves
        System.out.println("══════════");
        System.out.println("1. Dad Humor");
        System.out.println("2. Bubble Tea Tsunami");
        System.out.println("3. Boulder Bash");
        System.out.println("4. I Have The High Ground");

        System.out.println("══════════");
        String move = input.next();

        if (move.matches("(?i)1||2||3||4")) {
            if (move.equals("1")) {
                anim="dadhumor";
                mrChun.dadHumor(enemy);
                pause(2800);
            }

            if (move.equals("2")) {
                anim="tsunami";
                mrChun.bubbleTeaTsunami(enemy);

            }

            if (move.equals("3")) {
                anim="boulderbash";
                mrChun.boulderBash(enemy);
            }

            if (move.equals("4")) {
                anim="highground";
                mrChun.IHaveTheHighGround(enemy);
            }

            pause(4000);

            anim = "";

        } else {
            moveSystemUser(enemy);
        }

    }

    public void moveLockwoodEnemy(){
        int chance = (int) (Math.random() * 10);

        if (chance<3){
            anim="geometricgyro";
            msLockwood.geometricGyro(mrChun);
        }
        if (chance>=3 && chance<11){
            anim="mathMagic";
            msLockwood.mathMagic(mrChun);
        }



    }

    public void moveBradfordEnemy(){
        int chance = (int) (Math.random() * 10);

        if (chance<3){
            mxBradford.matchStickMadness(mrChun);
            // Faculty move 1

        }
        if (chance>=3 && chance<8){
            mxBradford.terminalTornado(mrChun);
        }
        if (chance>=8){
            mxBradford.selfAppreciation(mrChun);
        }



    }

    public void moveHussainEnemy() {

        int chance = (int) (Math.random() * 10);

        if (chance < 3) {
            anim="harvard";
            mrHussain.harvardHammer(mrChun);
        }
        if (chance >= 3 && chance < 8) {
            anim="beard";
            mrHussain.beardBanish(mrChun);
        }
        if (chance >= 8) {
            anim="mustang";
            mrHussain.mustangMash(mrChun);
        }

    }

    public void moveKilliamEnemy(){

        int chance = (int) (Math.random() * 10);

        if (chance < 3){
            msKilliam.RobbinsRush(mrChun);
        }

        if (chance >= 3 && chance < 8){
            msKilliam.RedactleReveal(mrChun);
        }

        if (chance >= 8){
            msKilliam.OutdoorProgramPummel(mrChun);
        }


    }

    public void moveHalesEnemy(){

        int chance = (int) (Math.random() * 10);

        if (chance < 3){
            anim="wrestling";
            mrHales.wrestlingWipeout(mrChun);
            pause(4000);
        }
        if (chance >= 3 && chance < 8){
            anim = "summonforbes";
            mrHales.summonForbesBoys(mrChun);
            pause(4000);
        }
        if (chance >= 8){
            anim = "matrix";
            mrHales.matrixMultiplication(mrChun);
            pause(4000);
        }
        anim = "";
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
//                g.drawImage(idleHales, msKilliam.xpos, msKilliam.ypos, msKilliam.width, msKilliam.width,null);
            // draw mx bradford

                g.drawImage(idleBradford, mxBradford.xpos, mxBradford.ypos, mxBradford.width, mxBradford.height,null);
                g.setColor(Color.green);

                g.fillRect(660, 130, (int)(mxBradford.health/4.5), 10); // garchomp
                g.fillRect(305, 330, (int)(mrChun.health/4.5), 10); // charizarwd
                // 110
                g.drawImage(healthbar, 600,110,200,55,null); // garchomp
                g.drawImage(healthbar, 245,310,200,55,null); // charizard

        }

        if (stageBackdrop == 2){

            g.drawImage(battle1Backdrop,-5,-5,1050,750,null);
            g.drawImage(idleChun, mrChun.xpos, mrChun.ypos, mrChun.width, mrChun.height,null);
            g.drawImage(idleHussain, mrHussain.xpos, mrHussain.ypos, mrHussain.width, mrHussain.height,null);

            g.setColor(Color.green);
            g.fillRect(660, 130, (int)(mrHussain.health/4.5), 10); // garchomp
            g.fillRect(305, 330, (int)(mrChun.health/4.5), 10); // charizarwd
            g.drawImage(healthbar, 600,110,200,55,null); // garchomp
            g.drawImage(healthbar, 245,310,200,55,null); // charizard

        }

        if (stageBackdrop == 5) {
            g.drawImage(battle5Backdrop, -5, -5, 1050, 750, null);
            g.drawImage(idleChun, mrChun.xpos, mrChun.ypos, mrChun.width, mrChun.height, null);
            g.drawImage(idleHales, mrHales.xpos, mrHales.ypos, mrHales.width, mrHales.height, null);

            g.setColor(Color.green);
            g.fillRect(660, 130, (int)(mrHales.health/4.5), 10); // garchomp
            g.fillRect(305, 330, (int)(mrChun.health/4.5), 10); // charizarwd
            g.drawImage(healthbar, 600,110,200,55,null); // garchomp
            g.drawImage(healthbar, 245,310,200,55,null); // charizard

        }

        if (anim.equalsIgnoreCase("dadhumor")){
            g.drawImage(dadhumour_anim, mrChun.xpos, mrChun.ypos, mrChun.width, mrChun.height, null);
        }

        if (anim.equalsIgnoreCase("tsunami")) {
            g.drawImage(tsunami_anim, mrChun.xpos, mrChun.ypos, mrChun.width, mrChun.height, null);
        }

        if (anim.equalsIgnoreCase("boulderbash")) {
            g.drawImage(boulder_anim, mrChun.xpos, mrChun.ypos, mrChun.width, mrChun.height, null);
        }

        if (anim.equalsIgnoreCase("highground")) {
            g.drawImage(highground_anim, mrChun.xpos, mrChun.ypos, mrChun.width, mrChun.height, null);
        }

        if (anim.equalsIgnoreCase("geometricgyro")) {
            g.drawImage(geometricgyro_anim, msLockwood.xpos, msLockwood.ypos, msLockwood.width, msLockwood.height, null);
        }

        if (anim.equalsIgnoreCase("mathMagic")) {
            g.drawImage(mathMagic_anim, msLockwood.xpos, msLockwood.ypos, msLockwood.width, msLockwood.height, null);
        }

        if (anim.equalsIgnoreCase("harvard")) {
            g.drawImage(harvard_anim, mrHussain.xpos, mrHussain.ypos, mrHussain.width, mrHussain.height, null);
        }

        if (anim.equalsIgnoreCase("mustang")) {
            g.drawImage(mustang_anim, mrHussain.xpos, mrHussain.ypos, mrHussain.width, mrHussain.height, null);
        }

        if (anim.equalsIgnoreCase("beard")) {
            g.drawImage(beard_anim, mrHussain.xpos, mrHussain.ypos, mrHussain.width, mrHussain.height, null);
        }

        if (anim.equalsIgnoreCase("summonforbes")){
            g.drawImage(forbesRush1, 500, 300, 200, 200, null);
            g.drawImage(forbesRush2, 700, 300, 200, 200, null);
        }

        if (anim.equalsIgnoreCase("matrix")){
            g.drawImage(matrix, 0, 0, 1000, 800, null);
        }

        if (anim.equalsIgnoreCase("wrestling")){
            g.drawImage(wrestling, 200, 300, 700, 500, null);
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
