package Helpers;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

public class GestionFichiers {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
	}
	
	public static void ecrireFichier(String nomFichier, Hashtable contenu){
		FileOutputStream fs = null;
        BufferedOutputStream bs = null;
        ObjectOutputStream oos = null;
		try {
			fs = new FileOutputStream(nomFichier);
			bs = new BufferedOutputStream(fs);
			oos = new ObjectOutputStream(bs);
             
            oos.writeObject(contenu);
             
            bs.flush(); // on vide le buffer
        }
         
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        finally {
            try {
                fs.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	}
	
	public static Hashtable lireFichier(String nomFichier){
		FileInputStream fs = null;
        ObjectInputStream ois = null;
        
        Hashtable myArrayList = new Hashtable();
        
        try {
            fs = new FileInputStream(nomFichier);
            ois = new ObjectInputStream(fs);
             
            myArrayList = (Hashtable)ois.readObject();
            
        }
         
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        finally {
            try {
                fs.close();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return myArrayList;
	}

}
