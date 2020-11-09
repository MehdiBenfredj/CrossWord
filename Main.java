import java.io.*;
import java.util.Scanner;

/*** Methode Main : Lire le fichier donné et créer un tableau 2D qui contint le characters du fichier. 
 *** Demander un mot d'utilisateur et le chercher dans le tableau 
 *** Visualiser the tableau avec le mot trouver ou informer l'utilisatuer si le mot n'est pas present */ 

public class Main {

    public static void main(String args[]) throws IOException {


	String filename;
	File file1 = new File("/Users/benfredjmehdi/Desktop/tp2/src/WORDS.txt");




	// Demander le nom de Fichier à l'utisateur
	// Constriure une instance de la classe "Crossword"
		Crossword crossword = new Crossword(file1);

		System.out.println(crossword.getColumns());
		System.out.println(crossword.getRows());
		crossword.display();
		System.out.println(crossword.search("MARSEILLE"));
		crossword.displayWord();


	// Crossword tableau = ...
	
	//tableau.display();


	// Demander un mot à chercher ...
	// Utiliser la méthode Crossword.search() pour chercher le mot
	// Ecrire un message sur le terminal pour informer l'utilisateur du resultat. 
	
    }
}
