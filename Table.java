import java.util.ArrayList;
import java.util.Collections;

public class Table{
    //asnsi reset color code
    static  final String ANSI_RESET = "\u001B[0m";
    //ansi green color code
    static final String ANSI_GREEN = "\u001B[32m";


    public Table(){
        
    }

    

    public void printStartScreen() {
        
        System.out.println(ANSI_GREEN);

        System.out.println("      ___           ___                         ___                       ___     ");
        System.out.println("     /  /\\         /__/\\         _____         /  /\\        ___          /  /\\    ");
        System.out.println("    /  /:/         \\  \\:\\       /  /::\\       /  /:/_      /  /\\        /  /::\\   ");
        System.out.println("   /  /:/           \\  \\:\\     /  /:/\\:\\     /  /:/ /\\    /  /:/       /  /:/\\:\\  ");
        System.out.println("  /  /:/  ___   ___  \\  \\:\\   /  /:/~/::\\   /  /:/ /:/_  /__/::\\      /  /:/  \\:\\");
        System.out.println(" /__/:/  /  /\\ /__/\\  \\__\\:\\ /__/:/ /:/\\:| /__/:/ /:/ /\\ \\__\\/\\:\\__  /__/:/ \\__\\:\\");
        System.out.println(" \\  \\:\\ /  /:/ \\  \\:\\ /  /:/ \\  \\:\\/:/~/:/ \\  \\:\\/:/ /:/    \\  \\:\\/\\ \\  \\:\\ /  /:/");
        System.out.println("  \\  \\:\\  /:/   \\  \\:\\  /:/   \\  \\::/ /:/   \\  \\::/ /:/      \\__\\::/  \\  \\:\\  /:/ ");
        System.out.println("   \\  \\:\\/:/     \\  \\:\\/:/     \\  \\:\\/:/     \\  \\:\\/:/       /__/:/    \\  \\:\\/:/  ");
        System.out.println("    \\  \\::/       \\  \\::/       \\  \\::/       \\  \\::/        \\__\\/      \\  \\::/   ");
        System.out.println("     \\__\\/         \\__\\/         \\__\\/         \\__\\/                     \\__\\/    ");

        System.out.println(ANSI_RESET);
         
    }


    public static void main(String[] args) {
        
         Table table = new Table();
         table.printStartScreen();

        CubeManager cubeManager = new CubeManager();
        cubeManager.requestCubeMatrix();
        cubeManager.printCubeMatrix();

        Botaki20 botakiForAStar = new Botaki20();
        botakiForAStar.setCubeMatrix(cubeManager.getCubeMatrix());
        Node root = new Node(cubeManager.getCubeMatrix());
        System.out.println("A* : ");
        botakiForAStar.AStar(root);
        System.out.println("UCS : ");
        botakiForAStar.UCS(root);
  
    }

}