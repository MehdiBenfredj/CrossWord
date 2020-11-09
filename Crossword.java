import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
import java.io.*;

/**
 * Class Crossword : Creates a 2D array of characters read from the input file
 */

public class Crossword
{
   private char array[][]; 	// Tableaux 2D contenant les caractères
   private int rows;      	// Nombres de lignes de array 
   private int columns;		// Nombres de colonnes de array
   
   private int WordCount;   // Nombre d'occurences d'un mot
   private int PositionX;	// Colonne de début du mot
   private int PositionY;	// Ligne de début du mot
   private int EndX;		// Colonne de fin du mot 
   private int EndY;		// Ligne de fin du mot


    /*** Constructor: Reads each line from File <file> and writes to a new row in the array.
    ** Updates <rows> and <columns> to height and width of the array. */
   public Crossword(File file) throws IOException {

	   // Code pour calculer la taille du tableau et initialiser les variables d'instance "rows" et "columns"
       file = new File("/Users/benfredjmehdi/Desktop/tp2/src/WORDS.txt");
       Scanner scannerrows = new Scanner(file);
       Scanner scannercolumns = new Scanner(file);
       Scanner newscanner = new Scanner(file);

       while (scannerrows.hasNextLine()){
           String lines = scannerrows.nextLine();
           rows++;
       }

       columns = scannercolumns.nextLine().length();

	   // Code pour créer le tableau "array"
       array = new char[rows][columns];


	   // Code pour remplir "array" avec les caractères du Fichier "file"

       for(int i = 0; i<rows ; i++){
           String line = newscanner.nextLine();
           for ( int j = 0; j<columns ; j++){
               array[i][j] = line.charAt(j);
           }
       }

	   
	   }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    /*** Methode Search(String) : Trouver le premier occurence du mot <word> dans le Tableau
    *** Si touver, mettre à jour les valeurs (PositionY, PositionX, EndY, EndX)*/
   
   public boolean search(String word) {



       // Verifier que le taile du mot "word" est supérieure à zero. Sinon rien à faire.
       if (word.length() == 0) {
           return false;
       } else {
           // Chercher le premier caractère du mot "word" dans le tableau array.
           for(int i=0; i<rows; i++){
               for(int j=0; j<columns ; j++){
                   if(array[i][j] == word.charAt(0)){
                       if(searchRow(i,j,word)){
                           PositionY= i;
                           EndY = i;
                           PositionX= j;
                           EndX= j+word.length()-1;
                           return true;
                       }
                       else if (searchColumn(i,j,word)){
                           PositionY= i;
                           EndY = i+word.length()-1;
                           PositionX=j ;
                           EndX=j ;
                           return true;
                       }
                   }
               }
           }

           // Si array[i][j] contient ce caractère, alors le mot peut apparaître dans le même ligne,
           // ou dans le même colonne. Utiliser les methodes SearchRow() ou searchColumn() selon le cas.

           return false; // mot pas trouvé
       }

   }

   
   /* Methode Interne SearchRow(int,int, String) : Cherche une ligne du tableaux pour le mot <word> à partir de array[y][x] */
   
   private boolean searchRow(int y, int x, String word) {

	   // Ecrire code ici  ...
       int occurencenum = 0;
       for(int i = x ; i < word.length()+x ; i++){
           if  (array[y][i] == word.charAt(i-x)){
               occurencenum++;
           }
       }
       if (occurencenum == word.length()){return true;}
	   else {return false;}
   }
   
   /* Methode Interne SearchRow(int,int, String) : Cherche une colonne du tableaux pour le mot <word> à partir de array[y][x] */
   
   private boolean searchColumn(int y, int x, String word) {
	   // Ecrire code ici ...
       int occurencenum = 0;
       for(int i = y ; i < word.length()+y ; i++){
           if  (array[i][x] == word.charAt(i-y)){
               occurencenum++;
           }
       }
       if (occurencenum == word.length()){return true;}
       else {return false;}
   }



    /*** Methode pour visualiser le tableau. (Déjà fourni) */
   public void display() {
	   if (rows>0 && columns>0)
		   CrosswordGUI.display(array);  
	   else 
		   System.out.println("Error: Array is Empty.");
   }

   /*** Methode pour visualiser le tableau avec le mot en surbrillance. (Déjà fourni) */
   public void displayWord() {
		if ((PositionX<0) || (PositionX>EndX) || (EndX>=columns)) {
			System.out.println("Error: Incorrect x-coordinates for Word");
			return;
		}
		if ((PositionY<0) || (PositionY>EndY) || (EndY>=rows)) {
			System.out.println("Error: Incorrect y-coordinates for Word");
			return;		
		}
		CrosswordGUI.display(array, PositionY, PositionX, EndY, EndX);  
   }
   
}
