// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.

/* Code for ${course} - 2017T2
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;
import java.util.*;

/** The program contains several methods for analysing the readings of the temperature levels over the course of a day.
 *  There are several things about the temperature levels that a user may be interested in: 
 *    The average temperature level.
 *    How the temperatures rose and fell over the day.
 *    The maximum and the minimum temperature levels during the day.
 */
public class TemperatureAnalyser{

    /** Constructor: set up user interface */
    public TemperatureAnalyser(){
           UI.initialise();
           UI.addButton("Analyse", this::doAnalyse );
           UI.addButton("Quit", UI::quit );
    }

    /* doAnalyse reads a sequence of temperature levels from the user and prints out
        *    average, maximum, and minimum level and plots all the levels
        *    by calling appropriate methods
        */
    public void doAnalyse(){
           UI.clearPanes();
           ArrayList<Double> listOfNumbers = UI.askNumbers("Enter levels, end with 'done': ");
           if (listOfNumbers.size() > 0) {
                  this.printAverage(listOfNumbers);
                  this.plotLevels(listOfNumbers);

	    double max = this.maximumOfList(listOfNumbers);
	    double min = this.minimumOfList(listOfNumbers);
	    
                  UI.println("Maximum level was: " + max);
                  UI.println("Minimum level was: " + min);
           }
           else {
                  UI.println("No readings");
           }
    }

    /** Print the average level
        *   - There is guaranteed to be at least one level,
        *   - The method will need a variable to keep track of the sum, which 
        *        needs to be initialised to an appropriate value.
        *  CORE
        */
    public void printAverage(ArrayList<Double> listOfNumbers) {
           UI.println("method printAverage() is not implemented yet");  // remove when you have implemented your method
           /*# YOUR CODE HERE */

    }

    /**
        * Plot a bar graph of the sequence of levels,
        * using narrow rectangles whose heights are equal to the level.
        * [Core]
        *   - Plot the bars.
        * [Completion]
        *   - Draws a horizontal line for the x-axis (or baseline) without any labels.
        *   - Any level greater than 400 should be plotted as if it were just 400, putting an
        *            asterisk ("*") above it to show that it has been cut off.
        * [Challenge:] 
        *   - The graph should also have labels on the axes, roughly every 50 pixels.
        *   - The graph should also draw negative temperature levels correctly.
        *   - Scale the y-axis and the bars so that the largest numbers and the smallest just fit on the graph.
        *        The numbers on the y axis should reflect the scaling.
        *   - Scale the x-axis so that all the bars fit in the window.
        */
    public void plotLevels(ArrayList<Double> listOfNumbers) {
           UI.println("method plotLevels() is not implemented yet");  // remove when you have implemented your method
           int base = 420;                    //base of the graph
           int left = 50;                        //left of the graph
           int step = 25;                        //distance between plotted points

           /*# YOUR CODE HERE */

           UI.println("Finished plotting");
    }

    /** Find and return the maximum level in the list
        *   - There is guaranteed to be at least one level,
        *   - The method will need a variable to keep track of the maximum, which
        *        needs to be initialised to an appropriate value.
        *  COMPLETION
        */
    public double maximumOfList(ArrayList<Double> listOfNumbers) {
           UI.println("method maximumOfList() is not implemented yet");  // remove when you have implemented your method
           /*# YOUR CODE HERE */

	return -10000;  // You need to replace this line - it is just here to make the template compile.
    }

    /** Find and return the minimum level in the list
        *   - There is guaranteed to be at least one level,
        *   - The method will need a variable to keep track of the minimum, which
        *        needs to be initialised to an appropriate value.
        *  COMPLETION
        */
    public double minimumOfList(ArrayList<Double> listOfNumbers) {
           UI.println("method minimumOfList() is not implemented yet");  // remove when you have implemented your method
           /*# YOUR CODE HERE */

	return -10000;  // You need to replace this line - it is just here to make the template compile.
    }



}