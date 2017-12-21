// This program is copyright VUW.
// You are granted permission to use it to construct your assignment answer,
// You may not distribute it in any other way without permission.
//
/* Code for COMP 102
 * Name:
 * ID:
 */

import ecs100.*;

import java.awt.Color;

public class CircuitDrawer {

    // fields to store data:
    //  - the tool that the user has selected (which control what component will be
    //    drawn by the mouse)
    //    The tools are "resistor", "wire", "capacitor", "source", "label", or "eraser"
    //  - the mode: whether the component should be horizontal or vertical
    //  - the contents of the label
    //  - the position the mouse was pressed,
    /*# YOUR CODE HERE */
    private double x, y;
    private String operation, labelText;
    private boolean horizontalMode = true;
    private boolean wireFirstTime = true;
    private double x1, x2, y1, y2;
    private int n = 0;
    private double eraserSize = 40;


    //Constructor

    /**
     * Sets up the user interface - mouselistener, buttons, and (completion only) textField
     */
    public CircuitDrawer() {
        UI.setMouseListener(this::doMouse);
        UI.addButton("Clear", UI::clearGraphics);
        /*# YOUR CODE HERE */
        UI.addButton("Wire", this::doSetWire);
        UI.addButton("Resistor", this::doSetResistor);
        UI.addButton("Capacitor", this::doSetCapacitor);
        UI.addButton("Source", this::doSetSource);
        UI.addTextField("Label", this::doSetLabel);
        UI.addButton("Eraser", this::doSetEraser);
        UI.addButton("Horiz/Vert", this::doSwitchDirection);


        UI.addButton("Quit", UI::quit);

        UI.setDivider(0.0);  // Hide the text area.
    }

    // Methods to change the tool that controls will be drawn next
    // These methods just save information to the fields.

    /* Respond to the resistor button */
    public void doSetResistor() {
        /*# YOUR CODE HERE */
        this.operation = "Resistor";
    }

    /* Respond to the wire button */
    public void doSetWire() {
        /*# YOUR CODE HERE */
        this.operation = "Wire";
    }

    /* Respond to the capacitor button */
    public void doSetCapacitor() {
        /*# YOUR CODE HERE */
        this.operation = "Capacitor";
    }

    /* Respond to the source button */
    public void doSetSource() {
        /*# YOUR CODE HERE */
        this.operation = "Source";
    }

    /* Respond to the eraser button */
    public void doSetEraser() {
        /*# YOUR CODE HERE */
        this.operation = "Eraser";
    }

    /**
     * Respond to the text field (completion only)
     */
/*    public Color randomColor() {
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        Color color = new Color(r, g, b);
        return color;
    }*/
    public void doSetLabel(String s) {
        /*# YOUR CODE HERE */
        this.operation = "Label";
        this.labelText = s;
    }

    /**
     * Respond to the horiz/vert button (completion only)
     * Switches the mode from horizontal to vertical, or back
     * Ideally, (Challenge) it should show the user what the current state is,
     * eg by drawing a horizonal/vertical bar in the top left corner,
     * or by calling setText on the button to change the label
     */
    public void doSwitchDirection() {
        /*# YOUR CODE HERE */
        if (this.horizontalMode) {
            this.horizontalMode = false;
        } else {
            this.horizontalMode = true;
        }
    }


    /**
     * Respond to mouse events
     * When pressed, remember the position.
     * When released, draw what is specified by current tool
     * Uses the value stored in the field to determine which kind of component to draw (or to erase)
     * It should call the drawWire, drawResistor, drawCapacitor, drawSource, drawLabel,
     * or doErase, methods passing the x and y where the mouse was released.
     */
    public void doMouse(String action, double x, double y) {
        /*# YOUR CODE HERE */
        if (action.equals("released")) {
            this.x = x;
            this.y = y;
        }
        if (this.operation.equals("Resistor")) {
            this.drawResistor(x, y);
        } else if (this.operation.equals("Wire")) {
            this.drawWire(x, y);
        } else if (this.operation.equals("Capacitor")) {
            this.drawCapacitor(x, y);
        } else if (this.operation.equals("Source")) {
            this.drawSource(x, y);
        } else if (this.operation.equals("Eraser")) {
            this.doErase(x, y);
        } else if (this.operation.equals("Label")) {
            this.drawLabel(x, y);

        }


    }


    /**
     * Draw a resistor centered at the point x, y.
     * HINT: Draw a line, then fill a white rectangle, then draw a black rectangle
     * Core: only horizontal required
     * Completion: horizontal or vertical depending on the mode.
     */
    public void drawResistor(double x, double y) {
        double length = 31;    // size in the longer  dimension
        double width = 11;     // size in the shorter dimension 
        double stub = 10;      // the length of the wires on each end
        /*# YOUR CODE HERE */
        if (horizontalMode) {//TODO:Horiz/Vert mode
            UI.eraseRect(x - length / 2, y - width / 2, length, width);
            UI.drawRect(x - length / 2, y - width / 2, length, width);
            UI.drawLine(x - length / 2, y, x - length / 2 - stub, y);
            UI.drawLine(x + length / 2, y, x + length / 2 + stub, y);
        } else {
            UI.eraseRect(x - width / 2, y - width / 2, width, length);
            UI.drawRect(x - width / 2, y - width / 2, width, length);
            UI.drawLine(x, y + (length / 2) + stub, x, y + (length / 2) + stub * 2);
            UI.drawLine(x, y - length / 4, x, y - length / 4 - stub);//uppper line
        }

    }

    /**
     * Draw a wire from the point where the user pressed the mouse to the point x,y.
     * Core: may be a straight line.
     * Completion: The wire should have a horizontal part followed by a vertical part
     * If the distance between the two points is very small, it just puts a circle at (x y)
     */
    public void drawWire(double x, double y) {
        /*# YOUR CODE HERE */
        if (this.wireFirstTime) {
            x1 = x;
            y1 = y;
            this.wireFirstTime = false;
        } else {
            x2 = x;
            y2 = y;
            UI.drawLine(x1, y1, x2, y2);
            this.wireFirstTime = true;//reset to default value
        }

    }


    /**
     * Draw a capacitor centered at the point x, y.
     * (Two parallel lines with wires on each side)
     * HINT: draw a line for the wires, then draw a black rectangle, then
     * fill a white rectangle that is narrower but longer.
     * Core: only horizontal required
     * Completion: horizontal or a vertical, depending on the mode.
     */
    public void drawCapacitor(double x, double y) {
        /*# YOUR CODE HERE */
        if (horizontalMode) {
            UI.eraseRect(x - 5, y - 10, 5, 10);
            UI.drawLine(x - 30, y, x - 5, y);//left wire
            UI.drawLine(x + 30, y, x + 5, y);//right wire
            UI.drawLine(x - 5, y - 10, x - 5, y + 10);//left vert line
            UI.drawLine(x + 5, y - 10, x + 5, y + 10);//right vert line
        } else {
//TODO:Erase before drawing lines
            UI.drawLine(x, y - 30, x, y - 5);//upper wire
            UI.drawLine(x, y + 30, x, y + 5);//lower wire
            UI.drawLine(x - 10, y - 5, x + 10, y - 5);//lower horiz line
            UI.drawLine(x - 10, y + 5, x + 10, y + 5);//upper line
        }
    }

    /**
     * Draw a source centered at the point x, y.
     * (Circle with wires on each side)
     * Core: only horizontal required
     * Completion: horizontal or vertical, depending on the mode.
     */
    public void drawSource(double x, double y) {
        /*# YOUR CODE HERE */
        //TODO:Draw Source
        double size = 20;//for test
        double wireLength = 10;

        if (horizontalMode) {
            UI.eraseOval(x - size / 2, y - size / 2, size, size);
            UI.drawOval(x - size / 2, y - size / 2, size, size);
            UI.drawLine(x - size / 2, y, x - size / 2 - wireLength, y);
            UI.drawLine(x + size / 2, y, x + size / 2 + wireLength, y);


        } else {

        }


    }


    /**
     * Erase a circular region around the position x, y
     * Should be big enough to erase a single component.
     */
    public void doErase(double x, double y) {
        /*# YOUR CODE HERE */
        UI.eraseRect(x - 25, y - 25, eraserSize, eraserSize);
    }


    /**
     * Draw a label at position x, y.  Always horizontal.
     * Uses the label that was stored in a field.
     * Completion only.
     */
    public void drawLabel(double x, double y) {
        /*# YOUR CODE HERE */
        UI.drawString(labelText, x, y);


    }


    // Main:  constructs a new CircuitDrawer object
    public static void main(String[] arguments) {
        new CircuitDrawer();
    }

}
