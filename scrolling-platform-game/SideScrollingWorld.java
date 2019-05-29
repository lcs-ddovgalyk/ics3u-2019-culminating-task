import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Template for a side-scrolling platform game.
 * 
 * @author R. Gordon
 * @version May 8, 2019
 */
public class SideScrollingWorld extends World
{
    /**
     * Instance variables
     * 
     * These are available for use in any method below.
     */    
    // Tile size in pixels for world elements (blocks, clouds, etc)
    // TO STUDENTS: Modify if your game's tiles have different dimensions
    private static final int TILE_SIZE = 32;
    private static final int HALF_TILE_SIZE = TILE_SIZE / 2;

    // World size constants
    // TO STUDENTS: Modify only if you're sure
    //              Should be a resolution that's a multiple of TILE_SIZE
    private static final int VISIBLE_WIDTH = 640;
    private static final int VISIBLE_HEIGHT = 480;

    // Additional useful constants based on world size
    public static final int HALF_VISIBLE_WIDTH = VISIBLE_WIDTH / 2;
    private static final int HALF_VISIBLE_HEIGHT = VISIBLE_HEIGHT / 2;

    // Defining the boundaries of the scrollable world
    // TO STUDENTS: Modify SCROLLABLE_WIDTH if you wish to have a longer level
    public static final int SCROLLABLE_WIDTH = VISIBLE_WIDTH * 3;
    private static final int SCROLLABLE_HEIGHT = VISIBLE_HEIGHT;

    // Hero
    Hero theHero;

    // Track whether game is on
    private boolean isGameOver;

    //
    int score; 
    /**
     * Constructor for objects of class SideScrollingWorld.
     */
    public SideScrollingWorld()
    {    
        // Create a new world with 640x480 cells with a cell size of 1x1 pixels.
        // Final argument of 'false' means that actors in the world are not restricted to the world boundary.
        // See: https://www.greenfoot.org/files/javadoc/greenfoot/World.html#World-int-int-int-boolean-
        super(VISIBLE_WIDTH, VISIBLE_HEIGHT, 1, false);

        // Set up the starting scene
        setup();

        // Game on
        isGameOver = false;

    }

    /**
     * Set up the entire world.
     */
    private void setup()
    {
        // TO STUDENTS: Add, revise, or remove methods as needed to define your own game's world
        // addLeftGround();
        // addFences();
        // addMetalPlateSteps();
        // addClouds();
        // addRightGround();
        // Add some metal plates

        for (int i = 0; i <= 60; i+= 1){
            int x = HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 14 * TILE_SIZE + HALF_TILE_SIZE;
            Ground ground = new Ground(x,y);
            addObject(ground,x,y);

        }
        for (int i = 0; i <= 60; i+= 1){
            int x = HALF_TILE_SIZE + i * TILE_SIZE;
            int y = HALF_TILE_SIZE;
            Ground ground = new Ground(x,y);
            addObject(ground,x,y);

        }

        addHero();
        cCoin();
        cCoin2();
        cCoin3();
        dontTouch();
        dontTouch2();
        dontTouch3();
        dontTouch4();
        dontTouch5();
        dontTouch6();

        //addObject(new GroundBelow(100,100),1500,100);
    }
    /**
     * Add blocks to create the ground to walk on at bottom-left of scrollable world.
     */
    private void addLeftGround()
    {
        // How many tiles will cover the bottom of the initial visible area of screen?
        final int tilesToCreate = getWidth() / TILE_SIZE;

        // Loop to create and add the tile objects
        for (int i = 0; i < tilesToCreate; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }
    }

    private void evilClass(){
        int y = 1;
        y = y + 15;
        GroundBelow evil = new GroundBelow(5*TILE_SIZE,y);
        addObject(evil, 5*TILE_SIZE, y);
    }

    /**
     * Add some fences at left and right side.
     */
    private void addFences()
    {
        // Three fences on left side of world
        int x = HALF_TILE_SIZE + TILE_SIZE * 5;
        int y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Fence fence1 = new Fence(x, y);
        addObject(fence1, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 6;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;        
        Fence fence2 = new Fence(x, y);
        addObject(fence2, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 7;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Fence fence3 = new Fence(x, y);
        addObject(fence3, x, y);

        // Two fences on right side of world
        x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - TILE_SIZE * 3;
        y = VISIBLE_HEIGHT / 2;
        Fence fence4 = new Fence(x, y);
        addObject(fence4, x, y);

        x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - TILE_SIZE * 4;
        y = VISIBLE_HEIGHT / 2;
        Fence fence5 = new Fence(x, y);
        addObject(fence5, x, y);
    }

    /**
     * Add steps made out of metal plates leading to end of world.
     */
    private void addMetalPlateSteps()
    {
        // How many plates total?
        final int COUNT_OF_METAL_PLATES = 20;
        final int PLATES_PER_GROUP = 4;

        // Add groups of plates
        for (int i = 0; i < COUNT_OF_METAL_PLATES / PLATES_PER_GROUP; i += 1)
        {
            // Group of four metal plates all at same y position
            int y = VISIBLE_HEIGHT - HALF_TILE_SIZE * 3 - i * TILE_SIZE;

            // Add the individual plates in a given group
            for (int j = 0; j < PLATES_PER_GROUP; j += 1)
            {
                int x = VISIBLE_WIDTH + TILE_SIZE * 2 + TILE_SIZE * (i + j) + TILE_SIZE * 5 * i;
                MetalPlate plate = new MetalPlate(x, y);
                addObject(plate, x, y);
            }
        }
    }

    /**
     * Act
     * 
     * This method is called approximately 60 times per second.
     */
    public void act(){ 
        int x = 200;
        int y = 100;
        showText("Coins collected: ", 100, 100);

        Cloud scorecoin = new Cloud(x,y);
        if(score == 1){
            addObject(scorecoin,200,100);

        }
        if(score == 2){
            addObject(scorecoin,220,100);

        }
        if(score == 3){
            addObject(scorecoin,240,100);

        }
        //creates an end screen that shows up when you win the game.
        if(isGameOver == true){
            EndScreen end = new EndScreen();
            //
            addObject(end,320,240);
            x = 320;
            y = 300;
            //removes the text from the upper left corver
            showText("", 100, 100);
        }

    }

    /**
     * Add the hero to the world.
     */
    private void addHero()
    {
        // Initial horizontal position
        int initialX = TILE_SIZE;

        // Instantiate the hero object
        theHero = new Hero(initialX);

        // Add hero in bottom left corner of screen
        addObject(theHero, initialX, 2 * TILE_SIZE + HALF_TILE_SIZE);
    }

    /**
     * Add blocks to create the ground to walk on at top-right of scrollable world.
     */
    private void addRightGround()
    {
        // Constants to control dimensions of the ground at end of world
        final int COUNT_OF_GROUND = 8;
        final int GROUND_BELOW_COLUMNS = COUNT_OF_GROUND;
        final int GROUND_BELOW_ROWS = 6;
        final int COUNT_OF_GROUND_BELOW = GROUND_BELOW_COLUMNS * GROUND_BELOW_ROWS;

        // 1. Make ground at end of level (top layer)
        for (int i = 0; i < COUNT_OF_GROUND; i += 1)
        {
            // Position in wider scrollable world
            int x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - i * TILE_SIZE;
            int y = HALF_VISIBLE_HEIGHT + TILE_SIZE;

            // Create object and add it
            Ground ground = new Ground(x, y);
            addObject(ground, x, y);
        }

        // 2. Make sub-ground at end of level (below top layer)
        for (int i = 0; i < GROUND_BELOW_COLUMNS; i += 1)
        {
            for (int j = 0; j < GROUND_BELOW_ROWS; j += 1)
            {
                // Position in wider scrollable world
                int x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - i * TILE_SIZE;
                int y = HALF_VISIBLE_HEIGHT + TILE_SIZE + TILE_SIZE * (j + 1);

                // Create object and add it
                GroundBelow groundBelow = new GroundBelow(x, y);
                addObject(groundBelow, x, y);
            }
        }
    }

    /**
     * Return an object reference to the hero.
     */
    public Hero getHero()
    {
        return theHero;
    }

    private void deathPipes(){
        for (int i = 0; i <= 60; i+= 1){
            int x = HALF_TILE_SIZE + i * TILE_SIZE;
            int y = HALF_TILE_SIZE;
            Ground ground = new Ground(x,y);
            addObject(ground,x,y);

        }
    }

    private void cCoin(){

        int x = 4 * TILE_SIZE + HALF_TILE_SIZE;
        int y = 10 * TILE_SIZE;
        Fence cc = new Fence(x,y);
        addObject(cc,x,y);

    }

    private void cCoin2(){
        int x = 17 * TILE_SIZE + HALF_TILE_SIZE;
        int y = 9 * TILE_SIZE;
        Fence cc = new Fence(x,y);
        addObject(cc,x,y);

    }

    private void cCoin3(){
        int x = 35 * TILE_SIZE + HALF_TILE_SIZE;
        int y = 10 * TILE_SIZE;
        Fence cc = new Fence(x,y);
        addObject(cc,x,y);

    }

    private void dontTouch(){
        //creates the first pair of obstacles 
        //x position determines where the obstacles will be
        int x = 10 * TILE_SIZE + HALF_TILE_SIZE;
        //where the top part will be
        int y = 14 * TILE_SIZE;
        //where the bottom part will be
        int yb = 4 * TILE_SIZE;
        MetalPlate bad = new MetalPlate(x,y);
        addObject(bad,x,y);
        MetalPlateDown downBad = new MetalPlateDown(x,y);
        addObject(downBad,x,yb);
        //this is so the won't be any gaps between the obstacles and the top/bottom part
        JustTheBottom bottom = new JustTheBottom(x,y);
        addObject(bottom,x,TILE_SIZE + HALF_TILE_SIZE);
    }

    private void dontTouch2(){
        //creates the second pair of obstacles 
        //x position determines where the obstacles will be
        int x = 15 * TILE_SIZE + HALF_TILE_SIZE;
        //where the top part will be
        int y = 10 * TILE_SIZE;
        //where the bottom part will be
        int yb = TILE_SIZE;
        MetalPlate bad = new MetalPlate(x,y);
        addObject(bad,x,y);
        MetalPlateDown downBad = new MetalPlateDown(x,y);
        addObject(downBad,x,yb);
        //this is so the won't be any gaps between the obstacles and the top/bottom part
        JustTheBottom bottom = new JustTheBottom(x,y);
        addObject(bottom,x, 14 * TILE_SIZE + HALF_TILE_SIZE);
    }

    private void dontTouch3(){
        //creates the third pair of obstacles 
        //x position determines where the obstacles will be
        int x = 20 * TILE_SIZE + HALF_TILE_SIZE;
        //where the top part will be
        int y = 16 * TILE_SIZE;
        //where the bottom part will be
        int yb = 6 * TILE_SIZE;
        MetalPlate bad = new MetalPlate(x,y);
        addObject(bad,x,y);
        MetalPlateDown downBad = new MetalPlateDown(x,y);
        addObject(downBad,x,yb);
        //this is so the won't be any gaps between the obstacles and the top/bottom part
        JustTheBottom bottom = new JustTheBottom(x,y);
        addObject(bottom,x, 2 * TILE_SIZE);
    }

    private void dontTouch4(){
        //creates the forth pair of obstacles 
        //x position determines where the obstacles will be
        int x = 25 * TILE_SIZE + HALF_TILE_SIZE;
        //where the top part will be
        int y = 15 * TILE_SIZE;
        //where the bottom part will be
        int yb = 5 * TILE_SIZE;
        MetalPlate bad = new MetalPlate(x,y);
        addObject(bad,x,y);
        MetalPlateDown downBad = new MetalPlateDown(x,y);
        addObject(downBad,x,yb);
        //this is so the won't be any gaps between the obstacles and the top/bottom part
        JustTheBottom bottom = new JustTheBottom(x,y);
        addObject(bottom,x, TILE_SIZE + HALF_TILE_SIZE);
    }

    private void dontTouch5(){
        //creates the fifth pair of obstacles 
        //x position determines where the obstacles will be
        int x = 30 * TILE_SIZE + HALF_TILE_SIZE;
        //where the top part will be
        int y = 21 * HALF_TILE_SIZE;
        //where the bottom part will be
        int yb = 1 * HALF_TILE_SIZE;
        MetalPlate bad = new MetalPlate(x,y);
        addObject(bad,x,y);
        MetalPlateDown downBad = new MetalPlateDown(x,y);
        addObject(downBad,x,yb);
        //this is so the won't be any gaps between the obstacles and the top/bottom part
        JustTheBottom bottom = new JustTheBottom(x,y);
        addObject(bottom,x, 14 *TILE_SIZE + HALF_TILE_SIZE);
    }

    private void dontTouch6(){
        //creates the six pair of obstacles 
        //x position determines where the obstacles will be
        int x = 35 * TILE_SIZE + HALF_TILE_SIZE;
        //where the top part will be
        int y = 14 * TILE_SIZE;
        //where the bottom part will be
        int yb = 4 * TILE_SIZE;
        MetalPlate bad = new MetalPlate(x,y);
        addObject(bad,x,y);
        MetalPlateDown downBad = new MetalPlateDown(x,y);
        addObject(downBad,x,yb);
        //this is so the won't be any gaps between the obstacles and the top/bottom part
        JustTheBottom bottom = new JustTheBottom(x,y);
        addObject(bottom,x,TILE_SIZE + HALF_TILE_SIZE);
    }

    /**
     * Set game over
     */
    public void setGameOver()
    {
        isGameOver = true;
    }
}

