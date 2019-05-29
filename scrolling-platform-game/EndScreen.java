import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends Actor
{
    /**
     * Act - do whatever the EndScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //get's a reference to the world
        SideScrollingWorld world = (SideScrollingWorld)getWorld();
        //if the player collected only 1 coin then
        if(world.score == 1){
            world.addObject(new Cloud(100,100), 300,265);

        }
        //if the player collected only 2 coin then

        if(world.score == 2){
            world.addObject(new Cloud(100,100), 300,265);
            world.addObject(new Cloud(100,100), 340,265);

        }
        //if the player collected only 3 coin then

        if(world.score == 3){
            world.addObject(new Cloud(100,100), 300,265);
            world.addObject(new Cloud(100,100), 340,265);
            world.addObject(new Cloud(100,100), 380,265);

        }
    }    
}
