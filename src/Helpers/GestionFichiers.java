package Helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

public class GestionFichiers {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub


		// dans une méthode main
		 // on simplifie le code en retirant la gestion des exceptions
		File fichier =  new File("C:/Users/Léa/Desktop/marin.txt") ;

		 // ouverture d'un flux sur un fichier
		ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
				
		Hashtable ht = new Hashtable();
	    ht.put(1, "printemps");
	    ht.put(10, "été");
	    ht.put(12, "automne");
	    ht.put(45, "hiver");

		 // sérialization de l'objet
		oos.writeObject(ht);

		 // fermeture du flux dans le bloc finally



		// dans une méthode main
		 // on simplifie le code en retirant la gestion des exceptions
		File fichier1 =  new File("C:/Users/Léa/Desktop/marin.txt") ;

		 // ouverture d'un flux sur un fichier
		ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier1)) ;
				
		 // désérialization de l'objet
		Hashtable tableauCaractere1 = (Hashtable) ois.readObject() ;

		Enumeration e = tableauCaractere1.elements();
	    while(e.hasMoreElements())
	      System.out.println(e.nextElement());

		 // fermeture du flux dans le bloc finally



	}

}
