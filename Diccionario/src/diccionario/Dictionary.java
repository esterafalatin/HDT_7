/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diccionario;

/**
 *
 *  Esteban Rafael Barrera   - 13413
 * Jorge Daniel Mejia       - 13271
 * Diego Alejandro Juarez   - 13280
 * Jose Alejandro Sagastume - 13217
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Dictionary
{
	BinaryTree<Association<String,String>>root;
	ArrayList <String> enunciado = new ArrayList<String>();
	File file_words = null;
        FileReader fr = null;
	BufferedReader br = null;
	
	 public Dictionary()
        {
            root = new BinaryTree<Association<String,String>>(null, null, null, null);
            build_Dictionary();
            translate();
        }
	
	public void translate()
	{
            read();

            String cadena = " ";

            for(int i=0; i<enunciado.size(); i++)
            {
                cadena += translate_Word(root, enunciado.get(i).trim()) + " ";
            }
		
            System.out.println(cadena);
        }
	
	private String translate_Word(BinaryTree<Association<String,String>> parent, String word)
	{
            String word_translated = " ";
            Association<String,String> as = parent.value();
            String keyParent = as.getKey();
		
            int number =keyParent.compareToIgnoreCase(word);
		
             if(number == 0)
            {
                word_translated = parent.value().getValue();
            }
		
            if(number < 0)
            {
                if(parent.right()!=null)
                {
                    word_translated = translate_Word(parent.right(),word);
                }

                else
                {
                    return ("*"+ word +"*");
                }
            }

            if(number > 0)
            {
                if(parent.left()!=null)
                {
                    word_translated = translate_Word(parent.left(),word);
                }

                else
                {
                    return ("*"+ word +"*");
                }

            }

            return word_translated;
        }
	
	private void create_Node (BinaryTree<Association<String,String>> parent, Association<String,String> data)
        {
            Association<String,String> as = parent.value();
            String keyParent = as.getKey();
            String keyData = data.getKey();
            int number = keyParent.compareToIgnoreCase(keyData);
            
            // Proceso donde se implementa el recorrido o orden In-order en Binary Trees (Arboles Binarios)
            if (number > 0 && parent.left()==null)
            {
                parent.setLeft(new BinaryTree<Association<String,String>>(null, null, null,null));
                parent.left().setValue(data);
            }
		
            else if (parent.left()!=null)
            {
                create_Node(parent.left(),data);
            }
        
            if(number < 0 && parent.right()==null)
            {
                parent.setRight(new BinaryTree<Association<String,String>>(null, null, null,null));
                parent.right().setValue(data);
            }

            else if(parent.right()!=null)
            {
                create_Node(parent.right(),data);
            }
        }
	
	public void build_Dictionary()
	{
            ArrayList<Association<String,String>> association = new ArrayList<Association<String,String>>();
            ArrayList<String> words = new ArrayList<String>();

            //------------------------------------PARTE EXTRAIDA DE INTERNET PARA LEER EL ARCHIVO .TXT---------------------------------------------------------------
		
            try 
            {
               // Apertura del fichero y creacion de BufferedReader para poder
               // hacer una lectura comoda (disponer del metodo readLine()).
               //deben cambiarlo para el lugar en sus compus
               file_words = new File ("Diccionario.txt");
               fr = new FileReader (file_words);
               br = new BufferedReader(fr);

               // Lectura del fichero
               String linea;
               int ind=0;
               while((linea=br.readLine())!=null){
                  words.add(linea);
               }
            }
            catch(Exception e){
               e.printStackTrace();
            }finally{
               // En el finally cerramos el fichero, para asegurarnos
               // que se cierra tanto si todo va bien como si salta 
               // una excepcion.
               try{                    
                  if( null != fr ){   
                     fr.close();     
                  }                  
               }catch (Exception e2){ 
                  e2.printStackTrace();
               }
            }
 //--------------------------------------------------------------FIN DEL CODIGO TOMADO DE INTERNET------------------------------------------------------
        
            for(int i=0; i < words.size() - 1; i++)
            {
                int position = words.get(i).indexOf(',');
                String english_words = words.get(i).substring(0,position);
                String spanish_words = words.get(i).substring(position + 1, words.get(i).length());
                association.add(new Association(english_words, spanish_words));
            }
        
            root.setValue(association.get(0));
		
            for (int i = 1; i < association.size(); i++)
            {
                create_Node(root, association.get(i));
            }
        }
	
	private void read()
	{
            String words2 = " ";
            //----------------------------------------------PARTE DEL CODIGO QUE SE TOMO DE INTERNET PARA LEER UN ARCHIVO .TXT-------------------------------------
            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                //deben cambiarlo para el lugar en sus compus
                file_words = new File ("texto.txt");
                fr = new FileReader (file_words);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String linea;
                int ind=0;
                while((linea=br.readLine())!=null){
                     words2 = linea;
                }
            }
         catch(Exception e){
            e.printStackTrace();
         }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try{                    
               if( null != fr ){   
                  fr.close();     
               }                  
            }catch (Exception e2){ 
               e2.printStackTrace();
            }
         }
//--------------------------------------------------------------FIN DEL CODIGO TOMADO DE INTERNET------------------------------------------------------

            while(words2.compareTo("")!=0)
            {
                    int position = words2.indexOf(' ');

            if(position != -1)
            {
                enunciado.add(words2.substring(0,position));
                words2 = words2.substring(position+1);
            }
			
            else
            {
                enunciado.add(words2);
                words2 = " "; 
            }
        }
    }
	
}

