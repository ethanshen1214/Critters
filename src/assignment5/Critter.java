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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.lang.model.util.ElementScanner6;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;

/*
 * See the PDF for descriptions of the methods and fields in this
 * class.
 * You may add fields, methods or inner classes to Critter ONLY
 * if you make your additions private; no new public, protected or
 * default-package code or data can be added to Critter.
 */

public abstract class Critter {

	/* START --- NEW FOR PROJECT 5 */
	public enum CritterShape {
		CIRCLE, SQUARE, TRIANGLE, DIAMOND, STAR
	}

	/*
	 * the default color is white, which I hope makes critters invisible by default
	 * If you change the background color of your View component, then update the
	 * default color to be the same as you background
	 *
	 * critters must override at least one of the following three methods, it is not
	 * proper for critters to remain invisible in the view
	 *
	 * If a critter only overrides the outline color, then it will look like a
	 * non-filled shape, at least, that's the intent. You can edit these default
	 * methods however you need to, but please preserve that intent as you implement
	 * them.
	 */
	public javafx.scene.paint.Color viewColor() {
		return javafx.scene.paint.Color.WHITE;
	}

	public javafx.scene.paint.Color viewOutlineColor() {
		return viewColor();
	}

	public javafx.scene.paint.Color viewFillColor() {
		return viewColor();
	}

	public abstract CritterShape viewShape();

	protected final String look(int direction, boolean steps) {
		this.energy -= Params.WALK_ENERGY_COST;
		int numSteps = 0;
		if (steps)
			numSteps = 2;
		else
			numSteps = 1;
		if (direction == 0) // right
		{

		} 
		else if (direction == 1) // up right
		{

		} 
		else if (direction == 2) // up
		{

		} 
		else if (direction == 3) // up left
		{

		} 
		else if (direction == 4) // left
		{

		} 
		else if (direction == 5) // down left
		{

		} 
		else if (direction == 6) // down
		{

		} 
		else if (direction == 7) // down right
		{

		}
		return "";
	}

	public static String runStats(List<Critter> critters) {
		// TODO Implement this method
		return null;
	}

	public static void displayWorld(Object pane) {
		// TODO Implement this method

		double cellHeight = (800/Params.WORLD_HEIGHT);
		double cellWidth = (800/Params.WORLD_WIDTH);
		double height = (800/ Params.WORLD_HEIGHT)/1.3;		//for resizing
		double width = (800/ Params.WORLD_WIDTH)/1.3;
		
		GridPane world = (GridPane)pane;

		for(Critter c : population)
		{

			if(c.viewShape() == CritterShape.CIRCLE)
			{
				Circle circle = new Circle((width/2)-(width/10), c.viewFillColor());
				circle.setStroke(c.viewOutlineColor());
				world.add(circle, c.x_coord,c.y_coord);
				world.setHalignment(circle, HPos.CENTER);
				world.setValignment(circle, VPos.CENTER);
			}
			else if(c.viewShape() == CritterShape.SQUARE)
			{
				Rectangle rectangle = new Rectangle(width-(width/6),height-(height/6), c.viewFillColor());
				rectangle.setStroke(c.viewOutlineColor());
				world.add(rectangle, c.x_coord, c.y_coord);
				world.setHalignment(rectangle, HPos.CENTER);
				world.setValignment(rectangle, VPos.CENTER);
			}
			else if(c.viewShape() == CritterShape.TRIANGLE)
			{
				Polygon triangle = new Polygon();
				// triangle.getPoints().addAll(new Double[]{
				// 	10.0, 0.0,
				// 	0.0, 20.0,
				// 	20.0, 20.0
				// });
				triangle.getPoints().addAll(new Double[]{
					cellWidth/2, cellHeight-height,
					cellWidth-width, height,
					width, height
				});
				triangle.setFill(c.viewFillColor());
				triangle.setStroke(c.viewOutlineColor());
				world.add(triangle, c.x_coord, c.y_coord);
				world.setHalignment(triangle, HPos.CENTER);
				world.setValignment(triangle, VPos.CENTER);
			}
			else if(c.viewShape() == CritterShape.DIAMOND)
			{
				Polygon diamond = new Polygon();
				// diamond.getPoints().addAll(new Double[]{
				// 	10.0, 0.0,
				// 	5.0, 10.0,
				// 	10.0, 20.0,
				// 	15.0, 10.0
				// });
				diamond.getPoints().addAll(new Double[]{
					cellWidth/2, cellHeight-height,
					cellWidth-width, cellHeight/2,
					cellWidth/2, height,
					width, cellHeight/2
				});
				diamond.setFill(c.viewFillColor());
				diamond.setStroke(c.viewOutlineColor());
				world.add(diamond, c.x_coord, c.y_coord);
				world.setHalignment(diamond, HPos.CENTER);
				world.setValignment(diamond, VPos.CENTER);
			}
			else if(c.viewShape() == CritterShape.STAR)
			{
				Polygon star = new Polygon();
				star.getPoints().addAll(new Double[] {
					cellWidth/2, cellHeight-height,
					cellWidth-width+(width/7), height,
					width, cellHeight-height+(height/4),
					cellWidth-width, cellHeight-height+(height/4),
					width-(width/7), height
				});
				star.setFill(c.viewFillColor());
				star.setStroke(c.viewOutlineColor());
				world.add(star, c.x_coord, c.y_coord);
				world.setHalignment(star, HPos.CENTER);
				world.setValignment(star, VPos.CENTER);
			}
		}
    }

	/* END --- NEW FOR PROJECT 5
			rest is unchanged from Project 4 */

    private int energy = 0;

    private int x_coord;
    private int y_coord;

    private static List<Critter> population = new ArrayList<Critter>();
	private static List<Critter> babies = new ArrayList<Critter>();
	
	public static List<Critter> getPop(){			//for testing
		return population;
	}

    /* Gets the package name.  This assumes that Critter and its
     * subclasses are all in the same package. */
    private static String myPackage;

    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    private static Random rand = new Random();

    public static int getRandomInt(int max) {
        return rand.nextInt(max);
    }

    public static void setSeed(long new_seed) {
        rand = new Random(new_seed);
    }

    /**
     * create and initialize a Critter subclass.
     * critter_class_name must be the qualified name of a concrete
     * subclass of Critter, if not, an InvalidCritterException must be
     * thrown.
     *
     * @param critter_class_name
     * @throws InvalidCritterException
     */
    public static void createCritter(String critter_class_name)
            throws InvalidCritterException {
        // TODO: Complete this method
        // if(critter_class_name.length() < 12) {
    	// 	critter_class_name = myPackage + "." + critter_class_name;
    	// }
    	//System.out.println(critter_class_name);
    	Object mycritter = null;
    	try
    	{
    		Class c = Class.forName(critter_class_name);
    		Critter crit = (Critter)c.newInstance();
    		mycritter = crit;
    		
    	}
    	catch(ClassNotFoundException e)
    	{
    		//e.printStackTrace();
    		throw new InvalidCritterException(critter_class_name);
    	} 
    	catch (InstantiationException e) {
			throw new InvalidCritterException(critter_class_name);
		} 
    	catch (IllegalAccessException e) {
			throw new InvalidCritterException(critter_class_name);
		}
    	Critter me = (Critter) mycritter;		// Cast to Critter
    	me.x_coord = Critter.getRandomInt(Params.WORLD_WIDTH);
    	me.y_coord = Critter.getRandomInt(Params.WORLD_HEIGHT);
    	me.energy = Params.START_ENERGY;
    	
    	if(critter_class_name.equals("assignment5.Clover"))
    	{
    		Clover clover = (Clover) me;
    		population.add(clover);
    	}
    	else if(critter_class_name.equals("assignment5.MyCritter1"))
    	{
    		MyCritter1 c = (MyCritter1) me;
       		population.add(c);
    	}
    	else if(critter_class_name.equals("assignment5.MyCritter2"))
    	{
    		MyCritter2 c = (MyCritter2) me;
    		population.add(c);
    	}
    	else if(critter_class_name.equals("assignment5.MyCritter3"))
    	{
    		MyCritter3 c = (MyCritter3) me;
    		population.add(c);
    	}
    	else if(critter_class_name.equals("assignment5.MyCritter4"))
    	{
    		MyCritter4 c = (MyCritter4) me;
    		population.add(c);
    	}
       	else if(critter_class_name.equals("assignment5.MyCritter5"))
    	{
    		MyCritter5 c = (MyCritter5) me;
    		population.add(c);
    	}
    	else if(critter_class_name.equals("assignment5.MyCritter6"))
    	{
    		MyCritter6 c = (MyCritter6) me;
    		population.add(c);
    	}
    	else if(critter_class_name.equals("assignment5.MyCritter7"))
    	{
    		MyCritter7 c =  (MyCritter7) me;
    		population.add(c);
    	}
    	else if(critter_class_name.equals("assignment5.Goblin"))
    	{
    		Goblin c = (Goblin) me;
    		population.add(c);
    	}
    }

    /**
     * Gets a list of critters of a specific type.
     *
     * @param critter_class_name What kind of Critter is to be listed.
     *                           Unqualified class name.
     * @return List of Critters.
     * @throws InvalidCritterException
     */
    public static List<Critter> getInstances(String critter_class_name)
            throws InvalidCritterException {
        // TODO: Complete this method
        List<Critter> list = new ArrayList<Critter>();
    	if(critter_class_name.length() < 12) {
    		critter_class_name = myPackage + "." + critter_class_name;
    	}
		try
		{
			Class temp = Class.forName(critter_class_name);
			for(Critter c : population)
			{
				if(c.getClass().equals(temp))
				{
					list.add(c);
				}
			}
		}
		catch(ClassNotFoundException e)
		{
			throw new InvalidCritterException(critter_class_name);
		}

        return list;
    }

    /**
     * Clear the world of all critters, dead and alive
     */
    public static void clearWorld() {
        // TODO: Complete this method
        population.clear();
    }

    public static void worldTimeStep() {
        // TODO: Complete this method
        for(Critter c : population)
    	{
    		c.doTimeStep();
    	}
    	
    	for(int i = 0; i < population.size(); i++) {
    		Critter c = population.get(i);
    		if(c.energy < 1) {
    			population.remove(c);
    		}
    	}
    	for(int i = 0; i < population.size()-1; i++)
    	{
    		for(int j = i+1; j < population.size(); j++) 
    		{
    			if(population.get(i).x_coord == population.get(j).x_coord && population.get(i).y_coord == population.get(j).y_coord)
    			{
    				//System.out.println(population.get(i).energy);
    				//System.out.println(population.get(j).energy);
    				doEncounters(population.get(i), population.get(j));
    			}
    		}
    	}
    	for(int i = 0; i < population.size(); i++) {
    		Critter c = population.get(i);
    		c.energy = c.energy - Params.REST_ENERGY_COST;
    		if(c.energy <= 0) {
    			population.remove(c);
    		}
    	}
    	// for(int i = 0; i < Params.REFRESH_CLOVER_COUNT; i++) {
    	// 	try {
		// 		createCritter("Clover");
		// 	} catch (InvalidCritterException e) {
		// 		e.printStackTrace();
		// 	}
    	// }
    	
    	for(Critter b: babies) {
    		population.add(b);
    	}
    	babies.clear();
		//resolve encounters if two critters occupy the same space
    }

     /**
     * resolves encounters based on critter data
     * @param a one of the two critters in the encounters
     * @param b one of the two critters in the encounters
     */
    public static void doEncounters(Critter a, Critter b) {
    	boolean aFight = a.fight(b.toString());
    	boolean bFight = b.fight(a.toString());
    	int aRoll = 0;
    	int bRoll = 0;
    	

    	if(a.x_coord == b.x_coord && a.y_coord == b.y_coord)
    	{
	    	if(aFight) {
	        	if(a.getEnergy()<=0) {
	        		//System.out.println(a.getEnergy() + "is 0");
	        		aRoll = 0;
	        	}
	        	else {
	        		//System.out.println(a.getEnergy());
	        		aRoll = Critter.getRandomInt(a.getEnergy());	
	        	}
	        }
	    	else
	    		aRoll = 0;
	    	
	    	if(bFight) { 
	        	if(b.getEnergy()<=0) {
	        		//System.out.println(b.getEnergy() + "is 0");
	        		bRoll = 0;
	        	}
	        	else {
	        		//System.out.println(b.getEnergy());
	    		bRoll = Critter.getRandomInt(b.getEnergy());
	        	}
	        }
	    	else
	    		bRoll = 0;
	    	
	    	if(aRoll >= bRoll)
	    	{
	    		//a wins
	    		a.energy += b.getEnergy()/2;
	    		//world.removeCritter(b);
	    		population.remove(b);
	    	}
	    	else
	    	{
	    		//b wins
	    		b.energy += a.getEnergy()/2;
	    		//world.removeCritter(a);
	    		population.remove(a);
	    	}
    	}
    	
    }

    

    public abstract void doTimeStep();

    public abstract boolean fight(String oponent);

    /* a one-character long string that visually depicts your critter
     * in the ASCII interface */
    public String toString() {
        return "";
    }

    protected int getEnergy() {
        return energy;
    }

    protected final void walk(int direction) {
        // TODO: Complete this method
        this.energy -= Params.WALK_ENERGY_COST;
    	if(direction == 0)			//right
    	{
    		this.x_coord = (this.x_coord + 1)%(Params.WORLD_WIDTH);
    	}    	
    	else if(direction == 1)		//up right
    	{
    		this.x_coord = (this.x_coord + 1)%(Params.WORLD_WIDTH);
    		if(this.y_coord == 0)
    			this.y_coord = Params.WORLD_HEIGHT-1;
    		else
    			this.y_coord--;
    	}    	
    	else if(direction == 2)		//up
    	{
    		if(this.y_coord == 0)
    			this.y_coord = Params.WORLD_HEIGHT-1;
    		else
    			this.y_coord--;
    	}
    	else if(direction == 3)		//up left
    	{
    		if(this.x_coord == 0)
    			this.x_coord = Params.WORLD_WIDTH-1;
    		else
    			this.x_coord--;
    		if(this.y_coord == 0)
    			this.y_coord = Params.WORLD_HEIGHT-1;
    		else
    			this.y_coord--;
    	}
    	else if(direction == 4)		//left
    	{
    		if(this.x_coord == 0)
    			this.x_coord = Params.WORLD_WIDTH-1;
    		else
    			this.x_coord--;
    	}
    	else if(direction == 5)		//down left
    	{
    		if(this.x_coord == 0)
    			this.x_coord = Params.WORLD_WIDTH-1;
    		else
    			this.x_coord--;
    		this.y_coord = (this.y_coord + 1)%(Params.WORLD_HEIGHT);
    	}
    	else if(direction == 6)		//down
    	{
    		this.y_coord = (this.y_coord + 1)%(Params.WORLD_HEIGHT);
    	}
    	else if(direction == 7)		//down right
    	{
    		this.x_coord = (this.x_coord + 1)%(Params.WORLD_WIDTH);
    		this.y_coord = (this.y_coord + 1)%(Params.WORLD_HEIGHT);
    	}
    }

    protected final void run(int direction) {
        // TODO: Complete this method
        this.energy -= Params.RUN_ENERGY_COST;
    	if(direction == 0 || direction == 7)			//right
    	{
    		this.x_coord = (this.x_coord + 2)%(Params.WORLD_WIDTH);
    	}    	
    	else if(direction == 11)		//up right
    	{
    		this.x_coord = (this.x_coord + 2)%(Params.WORLD_WIDTH);
    		if(this.y_coord == 0)
    			this.y_coord = Params.WORLD_HEIGHT-2;
    		else if(this.y_coord == 1)
    			this.y_coord = Params.WORLD_HEIGHT-1;
    		else
    			this.y_coord -= 2;
    	}    	
    	else if(direction == 1 || direction == 2)		//up
    	{
    		if(this.y_coord == 0)
    			this.y_coord = Params.WORLD_HEIGHT-2;
    		else if(this.y_coord == 1)
    			this.y_coord = Params.WORLD_HEIGHT-1;
    		else
    			this.y_coord -= 2;
    	}
    	else if(direction == 10)		//up left
    	{
    		if(this.x_coord == 0)
    			this.x_coord = Params.WORLD_WIDTH-2;
    		else if(this.x_coord == 1)
    			this.x_coord = Params.WORLD_WIDTH-1;
    		else
    			this.x_coord--;
    		
    		if(this.y_coord == 0)
    			this.y_coord = Params.WORLD_HEIGHT-2;
    		else if(this.y_coord == 1)
    			this.y_coord = Params.WORLD_HEIGHT-1;
    		else
    			this.y_coord -= 2;
    	}
    	else if(direction == 4 || direction == 3)		//left
    	{
    		if(this.x_coord == 0)
    			this.x_coord = Params.WORLD_WIDTH-2;
    		else if(this.x_coord == 1)
    			this.x_coord = Params.WORLD_WIDTH-1;
    		else
    			this.x_coord-= 2;
    	}
    	else if(direction == 9)		//down left
    	{
    		if(this.x_coord == 0)
    			this.x_coord = Params.WORLD_WIDTH-2;
    		else if(this.x_coord == 1)
    			this.x_coord = Params.WORLD_WIDTH-1;
    		else
    			this.x_coord--;
    		
    		this.y_coord = (this.y_coord + 2)%(Params.WORLD_HEIGHT);
    	}
    	else if(direction == 5 || direction == 6)		//down
    	{
    		this.y_coord = (this.y_coord + 2)%(Params.WORLD_HEIGHT);
    	}
    	else if(direction == 8)		//down right
    	{
    		this.x_coord = (this.x_coord + 2)%(Params.WORLD_WIDTH);
    		this.y_coord = (this.y_coord + 2)%(Params.WORLD_HEIGHT);
    	}
    }

    protected final void reproduce(Critter offspring, int direction) {
        // TODO: Complete this method
        if(this.energy < Params.MIN_REPRODUCE_ENERGY) {
    		return;
    	}
    	else {
    		babies.add(offspring);
    		offspring.energy = Math.floorDiv(this.energy, 2);
    		double en = (double)this.energy;
    		en = en/2;
    		this.energy = (int)Math.ceil(en); 
    	}
    	offspring.x_coord = this.x_coord;
    	offspring.y_coord = this.y_coord;
    	offspring.walk(direction);
    }

    /**
     * The TestCritter class allows some critters to "cheat". If you
     * want to create tests of your Critter model, you can create
     * subclasses of this class and then use the setter functions
     * contained here.
     * <p>
     * NOTE: you must make sure that the setter functions work with
     * your implementation of Critter. That means, if you're recording
     * the positions of your critters using some sort of external grid
     * or some other data structure in addition to the x_coord and
     * y_coord functions, then you MUST update these setter functions
     * so that they correctly update your grid/data structure.
     */
    static abstract class TestCritter extends Critter {

        protected void setEnergy(int new_energy_value) {
            super.energy = new_energy_value;
        }

        protected void setX_coord(int new_x_coord) {
            super.x_coord = new_x_coord;
        }

        protected void setY_coord(int new_y_coord) {
            super.y_coord = new_y_coord;
        }

        protected int getX_coord() {
            return super.x_coord;
        }

        protected int getY_coord() {
            return super.y_coord;
        }

        /**
         * This method getPopulation has to be modified by you if you
         * are not using the population ArrayList that has been
         * provided in the starter code.  In any case, it has to be
         * implemented for grading tests to work.
         */
        protected static List<Critter> getPopulation() {
            return population;
        }

        /**
         * This method getBabies has to be modified by you if you are
         * not using the babies ArrayList that has been provided in
         * the starter code.  In any case, it has to be implemented
         * for grading tests to work.  Babies should be added to the
         * general population at either the beginning OR the end of
         * every timestep.
         */
        protected static List<Critter> getBabies() {
            return babies;
        }
    }
}
