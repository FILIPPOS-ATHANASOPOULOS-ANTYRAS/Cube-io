import java.util.ArrayList;
import java.util.Collections;

public class CubeLine {
    
    private ArrayList<Cube> cubes;

    public CubeLine(int numOfCubes) {
        this.cubes = new ArrayList<Cube>();
    }

    public CubeLine(int start  , int numOfCubesPerLine , int size) {


        this.cubes = new ArrayList<Cube>();

        for(int i = 0 ; i < numOfCubesPerLine ; i++){
            this.cubes.add(new Cube(i + start));
        }

        //shuffle the Cubes
        Collections.shuffle(this.cubes);

        //initialize the rest as invisible cubes
        for(int i = numOfCubesPerLine ; i < size ; i++){
            this.cubes.add(new Cube(0));
        }
    }

    public CubeLine(ArrayList<Integer> availableNumbers , int numOfCubesPerLine , int size) {


        this.cubes = new ArrayList<Cube>();
        
        for(int i = 0 ; i < numOfCubesPerLine ; i++){
            //pick the last number from the available numbers
            int number = availableNumbers.get(availableNumbers.size() - 1);
            this.cubes.add(new Cube(number));
            //remove number from available numbers
            availableNumbers.remove(availableNumbers.size() - 1);
        }

        //shuffle the Cubes
        Collections.shuffle(this.cubes);

        //initialize the rest as invisible cubes
        for(int i = numOfCubesPerLine ; i < size ; i++){
            this.cubes.add(new Cube(0));
        }
    }


    public CubeLine() {
    }

    public boolean isInOrder() {
        int lastCubeNumber = 0;
        for(Cube cube : cubes){
            if(cube.getCubeNumber() == 0) continue;
            if(cube.getCubeNumber() < lastCubeNumber) return false;
            lastCubeNumber = cube.getCubeNumber();
        }
        return true;
    }

   
    public void printCubeLineWithInvisibleCubes() {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BRIGHT_GREEN = "\u001B[92m";
        final String ANSI_BOLD = "\u001B[3m";

        

        //print top line
        for (Cube cube : cubes) {
            System.out.print("┌───┐");
        }
        System.out.println();
        //print middle parts
        for(Cube cube : cubes){
            int lengthOfNumber = String.valueOf(cube.getCubeNumber()).length();
             
            if(lengthOfNumber == 1)System.out.print("│ " + ANSI_BRIGHT_GREEN + ANSI_BOLD + cube.getCubeNumber() + ANSI_RESET + " │");
            else  if(lengthOfNumber == 2)System.out.print("│ " + ANSI_BRIGHT_GREEN + ANSI_BOLD + cube.getCubeNumber() + ANSI_RESET + "│");
        }
        System.out.println();



        //print bottom line
        for (Cube cube : cubes) {
             System.out.print("└───┘");
        }
        System.out.println();

    }


    public void printCubeLine(){
        //ansi yellow color
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BRIGHT_GREEN = "\u001B[92m";
        final String ANSI_BOLD = "\u001B[3m";
        
        
    

        //print top line
        for (Cube cube : cubes) {
            if(cube.getCubeNumber() == 0) System.out.print("     ");
            else System.out.print("┌───┐");
        }
        System.out.println();

        //print middle parts
        for(Cube cube : cubes){
            int lengthOfNumber = String.valueOf(cube.getCubeNumber()).length();
            
            
             if(cube.getCubeNumber() == 0) System.out.print("     ");

             else if(lengthOfNumber == 1)System.out.print("│ " + ANSI_BRIGHT_GREEN + ANSI_BOLD + cube.getCubeNumber() + ANSI_RESET + " │");
             else  if(lengthOfNumber == 2)System.out.print("│ " + ANSI_BRIGHT_GREEN + ANSI_BOLD + cube.getCubeNumber() + ANSI_RESET + "│");
        }
        System.out.println();



        //print bottom line
        for (Cube cube : cubes) {
            if(cube.getCubeNumber() == 0) System.out.print("     ");

             else System.out.print("└───┘");
        }
        System.out.println();

    }

    public void print3DCubeLine(){
        //ansi yellow color
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BRIGHT_GREEN = "\u001B[92m";
        final String ANSI_BOLD = "\u001B[3m";
        
        
        for (Cube cube : cubes) {
            if(cube.getCubeNumber() == 0) System.out.print("     ");
            else System.out.print(" .─── ");
        }

        //print top line
        for (Cube cube : cubes) {
            if(cube.getCubeNumber() == 0) System.out.print("     ");
            else System.out.print("┌───┐ ┐");
        }
        System.out.println();

        //print middle parts
        for(Cube cube : cubes){
             if(cube.getCubeNumber() == 0) System.out.print("     ");

             else System.out.print("│ " + ANSI_BRIGHT_GREEN + ANSI_BOLD + cube.getCubeNumber() + ANSI_RESET + " │|");
        }

        System.out.println();
        //print bottom line
        for (Cube cube : cubes) {
            if(cube.getCubeNumber() == 0) System.out.print("     ");

             else System.out.print("└───┘ ");
        }
        System.out.println();
    }

    public void moveCube(int i, int j) {
        Cube temp = this.cubes.get(i);
        this.cubes.set(i, this.cubes.get(j));
        this.cubes.set(j, temp);
    }
    
    public ArrayList<Cube> getCubes() {
        return this.cubes;
    }
    public static void main(String[] args) {
        CubeLine cubeLine = new CubeLine(1,3 ,5);
        cubeLine.print3DCubeLine();
        //print cubeline size
        System.out.println(cubeLine.getCubes().size());

    }

    public CubeLine copy() {
        CubeLine copy = new CubeLine();
        copy.cubes = new ArrayList<Cube>();
        for(Cube cube : this.cubes){
            copy.cubes.add(cube.copy());
        }
        return copy;
    }

    public void setCubes(ArrayList<Cube> cubes) {
        this.cubes = cubes;
    }


 
}
