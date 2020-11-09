import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public int x ;
    public int y;
    File filou = new File("/Users/benfredjmehdi/Desktop/tp2/src/WORDS.txt");
    Scanner scanx = new Scanner(filou);
    Scanner scany = new Scanner(filou);

    public Test() throws FileNotFoundException {
    }
    public String line;

    public int getX(){
        line = scanx.nextLine();
        x = line.length();
        return x;
    }



    public int getY(){
        while (scany.hasNextLine()){
            line = scany.nextLine();
            System.out.println(y);
            y++;
        }
        return y;
    }



}












