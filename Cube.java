public class Cube {
    private int cubeNumber;
    private int xPos;
    private int yPos;

    public Cube(int cubeNumber) {
        this.cubeNumber = cubeNumber;
    }

    public int getCubeNumber() {
        return this.cubeNumber;
    }

    public void setCubeNumber(int cubeNumber) {
        this.cubeNumber = cubeNumber;
    }

    
    public void printCube() {
        System.out.println("┌───┐");
        System.out.println("│ " + this.cubeNumber + " │");
        System.out.println("└───┘");
    }


    public int getXPos() {
        return this.xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public Cube copy() {
        Cube newCube  = new Cube(this.cubeNumber);
        newCube.setXPos(this.xPos);
        newCube.setYPos(this.yPos);
        return newCube;
    }

    
}
