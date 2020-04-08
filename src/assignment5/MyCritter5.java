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
	 * Oblivious critter, only walks 
	 */
	public class MyCritter5 extends TestCritter {

	    @Override
	    public void doTimeStep() {
	        walk(Critter.getRandomInt(8));
	    }

	    @Override
	    public boolean fight(String opponent) {
	        walk(Critter.getRandomInt(8));
	        return false;
	    }

	    public String toString() {
	        return "5";
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
			return javafx.scene.paint.Color.PURPLE;
		}
		
		@Override
		public javafx.scene.paint.Color viewFillColor() {
			return javafx.scene.paint.Color.PURPLE;
		}
}
