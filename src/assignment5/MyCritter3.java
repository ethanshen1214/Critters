/* CRITTERS Critter.java
 * EE422C Project 5 submission by
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

public class MyCritter3 extends TestCritter{
	
	
	/**
	*	Tiered Runner Critter, runs above a certain threshold, walks above another, always fights 
	*/
	
	@Override
    public void doTimeStep() {
		if(getEnergy() > 13)
			run(getRandomInt(8));
		else if(getEnergy() > 7)
			walk(getRandomInt(8));
    }

    @Override
    public boolean fight(String opponent) {
        return true;
    }

    @Override
    public String toString() {
        return "3";
    }

    @Override
    public CritterShape viewShape() {
        // TODO Auto-generated method stub
        return CritterShape.DIAMOND;
    }

    @Override
    public javafx.scene.paint.Color viewOutlineColor() {
		return javafx.scene.paint.Color.BLACK;
    }
    
    @Override
	public javafx.scene.paint.Color viewFillColor() {
		return javafx.scene.paint.Color.BLACK;
	}
}
