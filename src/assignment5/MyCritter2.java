/*
 * MyCritter2.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Ethan Shen
 * es38348
 * 16295
 * Osama Iqbal
 * oi723
 * 16295
 * Slip days used: <0>
 * Spring 2020
 */

package assignment5;
import assignment5.Critter.TestCritter;

public class MyCritter2 extends TestCritter{

	/**
	 * Backwards Critter always tries to run, walks away from fights
	 */
	
	@Override
    public void doTimeStep() {
		run(5);
    }

    @Override
    public boolean fight(String opponent) {
        walk(getRandomInt(8));
        return false;
    }

    @Override
    public String toString() {
        return "2";
    }

    @Override
    public CritterShape viewShape() {
        // TODO Auto-generated method stub
        return CritterShape.SQUARE;
    }
}
