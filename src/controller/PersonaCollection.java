package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dto.PersonaDTO;

public class PersonaCollection {
	private ArrayList<PersonaDTO> datos;
	
	public PersonaCollection()
	{
		datos = leer();
		
	}
	
	public ArrayList<PersonaDTO> getPersonasList()
	{
		return datos;
	}
	
	public PersonaDTO getPersona(int index)
	{
		return datos.get(index);
	}
	
	public void addDemoData()
	{
		for (int i=0; i<100; i++)
			datos.add(new PersonaDTO(String.valueOf(i),
									"Apellido " + String.valueOf(i),
									"Nombre " + String.valueOf(i),
									i % 2 == 0,
									"01/01/1900",
									(double) (i*1000)));
	}
	
	public void grabar() {
		File archivo = new File("./src/txt/personas.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(datos);
		//grabo el String
		try{
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	
    private ArrayList<PersonaDTO> leer() {
    	ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
        String cadena;
        File archivo = new File("./src/txt/personas.txt");
        if (archivo.exists())
        {
            FileReader f;
    		try {
    			f = new FileReader(archivo);
    	        BufferedReader b = new BufferedReader(f);
    	        cadena = b.readLine();
    	        System.out.println(cadena);
    	        JsonParser parser = new JsonParser();
    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
    	        Gson g = new Gson();
    	        for(JsonElement js : gsonArr) //System.out.println(js.toString());
    	        	personas.add(g.fromJson(js, PersonaDTO.class));
    	        
    	        b.close();
    	        
    	        //for(Object o : aux)
    	        //	scores.add((Score) o);
    	        return personas;
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		return personas;
		
    }

}
