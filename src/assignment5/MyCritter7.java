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

/**
 * Fighter, always fight when encounter other critters.
 */
public class MyCritter7 extends TestCritter {

    @Override
    public void doTimeStep() {
    }

    @Override
    public boolean fight(String opponent) {
        return true;
    }

    @Override
    public String toString() {
        return "7";
    }
    
    @Override
    public CritterShape viewShape() {
        // TODO Auto-generated method stub
        return CritterShape.SQUARE;
    }

    @Override
    public javafx.scene.paint.Color viewOutlineColor() {
        return javafx.scene.paint.Color.BROWN;
    }
    
    @Override
    public javafx.scene.paint.Color viewFillColor() {
        return javafx.scene.paint.Color.BROWN;
    }
}
