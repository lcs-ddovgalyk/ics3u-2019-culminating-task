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
    GroundBelow(int scrollableWorldX, int scrollableWorldY)
    {
        super(scrollableWorldX, scrollableWorldY);
    }    
    /**
     * Act - do whatever the GroundBelow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int z;
        z = 1;
        if(getY() == 380){
            z = -1;
        }
        
        setLocation(getX(), getY() + z);
        if(isTouching(Hero.class)){
            Greenfoot.stop();
            
        }
        
    }    
}
