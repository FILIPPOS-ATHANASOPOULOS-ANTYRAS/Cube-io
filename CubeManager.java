import java.util.InputMismatchException;
import java.util.Scanner;

public class CubeManager {
    private CubeMatrix cubeMatrix;
    private double cost = 0;
    private Scanner input;
    //ansi red color code
    public static final String ANSI_RED = "\u001B[31m";
    //ansi reset color code
    public static final String ANSI_RESET = "\u001B[0m";


    public CubeManager() {
        
    }
    
    public void createCubeMatrix(int numOfCubesPerLine) {
        this.cubeMatrix = new CubeMatrix(numOfCubesPerLine);
    }

    public void requestCubeMatrix() {
        this.input = new Scanner(System.in);

        try {
            System.out.println("Enter the number of cubes : ");
            int numOfCubesPerLine = input.nextInt();
            createCubeMatrix(numOfCubesPerLine);
        } catch (NullPointerException | NumberFormatException | InputMismatchException e) {
            // TODO: handle exception
            System.out.println(ANSI_RED + "You typed an invalid character. Please try again." + ANSI_RESET);
            requestCubeMatrix();
        }
    }

    public void moveCube(Cube cube , int xNext , int yNext){
        if(cubeMatrix.isMoveable(cube) && cubeMatrix.positionIsFree(xNext, yNext)){
            cubeMatrix.moveCube(cube, xNext, yNext);
            cubeMatrix.setPositionsForAllCubes();
        }else{
            System.out.println(ANSI_RED + "You can't move the cube to that position. Please try again." + ANSI_RESET);
        }
    }

    public void increaseCost(float costToAdd){
        this.cost += costToAdd;
    }
    public void calculationOfMove(int curY, int nextY){
        
            if(nextY > curY) cost =  (nextY - curY);
            else if (nextY < curY) cost =  0.5*(curY - nextY);
            else cost = 0.75;

    }
    public boolean cubesAreInOrder(){
        for(CubeLine cubeLine : cubeMatrix.getCubeLines()){
            if(!cubeLine.isInOrder()){
                return false;
            }
        }
        return true;
    }

    public void printCubeMatrix(){
        this.cubeMatrix.printCubeMatrix();
    }
    
    public CubeMatrix getCubeMatrix() {
        return this.cubeMatrix;
    }

    public void setCubeMatrix(CubeMatrix cubeMatrix) {
        this.cubeMatrix = cubeMatrix;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Scanner getInput() {
        return this.input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public Cube getCube(int number) {
        for(CubeLine cubeLine : cubeMatrix.getCubeLines()){
            for(Cube cube : cubeLine.getCubes()){
                if(cube.getCubeNumber() == 0) continue;
                if(cube.getCubeNumber() == number) return cube;
            }
        }
        return null;
    }

    public void printCubeLinesWithInvisibleCubes(){
        this.cubeMatrix.printCubeLinesWithInvisibleCubes();
    }

    public static void main(String[] args) {
        CubeManager cubeManager = new CubeManager();
        cubeManager.createCubeMatrix(4);
        cubeManager.printCubeMatrix();
        cubeManager.moveCube(cubeManager.getCube(1), 4, 2);
        cubeManager.printCubeMatrix();


    }


}
