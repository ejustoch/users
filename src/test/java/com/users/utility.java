package com.users;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class utility {
    
    private static final ClassLoader CLASS_LOADER = utility.class.getClassLoader();
    
    /**
     * Lee el fichero indicado y devuelve su contenido. Este se debe encontrar 
     * dentro del dDirectorio resources.
     * 
     * @param fileName nombre del archivo a leer.
     * @return contenido del archivo.
     */
    public static String getContent(String fileName) {

        if (fileName == null || fileName.trim().isEmpty()) {

            return null;
        }

        String content = "";
        String path = CLASS_LOADER.getResource(fileName).getFile();

        try {
            content = new String(Files.readAllBytes(new File(path).toPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo {} desde la ruta {}. Error: {}"+
                    fileName + path+ e.getMessage());
        }

        return content;
    }

}
