import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BelowGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GroundBelow extends Decoration
{
    /**
     * Constructor
     * 
     * Called once when object is created.
     */
    int speed = 3;

    
    GroundBelow(int scrollableWorldX, int scrollableWorldY)
    {
        super(scrollableWorldX, scrollableWorldY);
        // the actor turns to the right 
        turn(90);
        
    }    

    /**
     * Act - do whatever the GroundBelow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //this is only when the actor is at the edge
        if(isAtEdge()){
            //makes the speed negative for the actor to move in the opposite direction when it hits the edfe
            speed = speed * -1;

        }
        //what makes the actor move
        move(speed);
        //if the actor touches the Hero class then
        if(isTouching(Hero.class)){
            //stops the game
            Greenfoot.stop();
        }

    }

}