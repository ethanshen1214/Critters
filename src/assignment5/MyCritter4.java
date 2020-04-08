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

import java.util.List;

	/**
	 * Fighting Mother critter, does not move, either reproduces or fights
	 */
	public class MyCritter4 extends TestCritter {

	    @Override
	    public void doTimeStep() {
	        Critter off = new MyCritter4();
	        this.reproduce(off, Critter.getRandomInt(8));
	    }

	    @Override
	    public boolean fight(String opponent) {
	        return true;
	    }

	    public String toString() {
	        return "4";
	    }

	    public void test(List<Critter> l) {
		}
		

		@Override
		public CritterShape viewShape() {
			// TODO Auto-generated method stub
			return CritterShape.SQUARE;
		}
	
		@Override
		public javafx.scene.paint.Color viewOutlineColor() {
			return javafx.scene.paint.Color.RED;
		}
		
		@Override
		public javafx.scene.paint.Color viewFillColor() {
			return javafx.scene.paint.Color.RED;
		}
}

