/* Code for COMP102
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/** Lets the user draw "stars" - lots of lines from a center - using the mouse.
 * The program has two "modes":
 *   setting the center of the star,
 *   setting the points on the star.
 * When the user clicks the mouse:
 *   If the mode is setting the center, it draws a little circle of size 4 at the
 *     position the mouse was released, and stores the position  as the current center
 *   If the mode is setting the points, it draws a line from the
 *    the current center to the position where the mouse was released 
 *  
 * When the user clicks the "Set Center" button, the program changes the mode to setting center
 *  (Note: clicking the button does not draw anything!)
 * When the user clicks the "Set Points" button, the program changes the mode to setting points
 *  (Note: clicking the button does not draw anything!)
 * The user can click the "Clear" button to clear the graphics window
 */
public class StarExercise{

    //three fields to record current state:
    //  position of current center, and
    //  whether the user is currently choosing the center or a point
    /*# YOUR CODE HERE */
    private double centerX = 0;
    private double centerY = 0;
    private boolean choosingCenter = true;
    /*# END OF YOUR CODE */

    /** Set up the user interface: set mouse listener and buttons.
     *  "Clear" should clearing the graphics window.
     *  "Set Center" and "Set Points" do not draw anything. They only record what mode
     *  the user is now in - choosing a center point or not.
     */
    public StarExercise(){
	/*# YOUR CODE HERE */
        UI.setMouseListener( this::doMouse );
        UI.addButton("Clear", UI::clearGraphics);
        UI.addButton("Set Center", this::doSetCenter );
        UI.addButton("Set Points", this::doSetPoints );

	/*# END OF YOUR CODE */
        UI.addButton("Quit", UI::quit);
    }

    public void doSetCenter(){
	/*# YOUR CODE HERE */
        this.choosingCenter = true;
	/*# END OF YOUR CODE */
    }

    public void doSetPoints(){
	/*# YOUR CODE HERE */
        this.choosingCenter = false;
	/*# END OF YOUR CODE */
    }


    // DRAFT CODE HERE
    /* Alternative buttons for the constructor, which doesn't need the helper methods.
    UI.addButton("Set Center", () -> { this.choosingCenter = true; } );
    UI.addButton("Set Points", () -> { this.choosingCenter = false; } );
    UI.addButton("Set Color", () -> {UI.setColor(JColorChooser.showDialog(null, "Choose Color", null)); } );
     */
    // END OF DRAFT CODE

    /** Respond to mouse released events.
     * If mode is setting the center, then remember the position and draw a small
     * circle at the point.
     * Othewise, draw a line from the current center to this point
     */
    public void doMouse(String action, double x, double y){
        if (action.equals("released")){
            /*# YOUR CODE HERE */
            if (this.choosingCenter){
                this.centerX = x;
                this.centerY = y;
                UI.fillOval(x-2, y-2, 4, 4);
            }
            else{
                UI.drawLine(centerX, centerY, x, y);
            }
            /*# END OF YOUR CODE */
        }
    }

    public static void main(String[] args){
        new StarExercise();
    }	

}
