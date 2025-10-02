package org.example;

public class ShapeChecker {
    private int side1;
    private int side2;
    private int side3;
    private int side4;
    private int side5;
    public ShapeChecker() {
        // Initialize sides to 0 by default
        this.side1 = 0;
        this.side2 = 0;
        this.side3 = 0;
        this.side4 = 0;
        this.side5 = 0;
    }

    public void setSides(int side1, int side2, int side3, int side4, int side5){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
        this.side5 = side5;
    }

    public boolean isTriangle() {
        // Triangle inequality theorem check
        return (side1 + side2 > side3) &&
                (side1 + side3 > side2) &&
                (side2 + side3 > side1);
    }
    public String Detect(){
        String result = "";
        if(side1 != 0 && side2 == 0 && side3 == 0 && side4 == 0 && side5 == 0){
            result = new Circle().Circle();

        }
        if( side1 !=0 && side2 != 0 && side3 == 0 && side1 < side2 && side4 == 0 && side5 == 0) {
            result = new Quad().Quad();
        }
        if( side3 == 0 && side1 == side2 && side4 == 0 && side5 == 0){
            result = new Square().Square();
        }
        if(isTriangle()){
            result = new Triangle().toString();
        } else if(side1 !=0 && side5 != 0 && side2 != 0 && side3 != 0 && side4 != 0){
        result = new Pentagon().Pentagon();;     }
        return result;
}
}