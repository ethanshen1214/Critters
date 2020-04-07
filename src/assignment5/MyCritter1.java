package assignment5;

import assignment5.Critter.TestCritter;

import java.util.List;

/**
 * Wise critter, fight only when it has energy
 */
public class MyCritter1 extends TestCritter {

    @Override
    public void doTimeStep() {
        walk(0);
    }

    @Override
    public boolean fight(String opponent) {
        if (getEnergy() > 10) return true;
        return false;
    }

    public String toString() {
        return "1";
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
		return javafx.scene.paint.Color.GREEN;
    }
    
    @Override
	public javafx.scene.paint.Color viewFillColor() {
		return javafx.scene.paint.Color.GREEN;
	}

}
