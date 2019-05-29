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
        turn(90);
        
    }    

    /**
     * Act - do whatever the GroundBelow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
        if(isAtEdge()){
            speed = speed * -1;

        }
        move(speed);
        if(isTouching(Hero.class)){
            Greenfoot.stop();
        }

    }

}