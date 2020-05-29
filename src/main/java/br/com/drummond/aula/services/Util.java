package br.com.drummond.aula.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import br.com.drummond.aula.web.pagesController;

public class Util {

	/**
     * Leitura template HTML - projeto Spring Boot
     * @param resource
     * @return
     * @throws IOException
     */
	
	public static String readPageHTML(String resource) throws IOException {
    	InputStream is = pagesController.class.getResourceAsStream(resource);
    	
    	ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8.name());
    }
}
