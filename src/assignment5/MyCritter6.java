package assignment5;

import assignment5.Critter.TestCritter;

/**
 * Runner, always run when encounter other critters.
 */
public class MyCritter6 extends TestCritter {

    @Override
    public void doTimeStep() {
    }

    @Override
    public boolean fight(String opponent) {
        run(getRandomInt(8));
        return false;
    }

    @Override
    public String toString() {
        return "6";
    }

    @Override
    public CritterShape viewShape() {
        // TODO Auto-generated method stub
        return null;
    }
}