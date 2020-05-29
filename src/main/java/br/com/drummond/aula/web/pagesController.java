package br.com.drummond.aula.web;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.drummond.aula.services.Util;


@RestController
public class pagesController {
	@RequestMapping(value = {"/index","index.html"}, method = RequestMethod.GET)
    public ResponseEntity<?> getIndex() throws IOException {
    	
    	HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("drummond", "index");
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		responseHeaders.add("Cache-Control", "public, max-age=0");
	
		String page = Util.readPageHTML("/templates/index.html");
		
    	
		return ResponseEntity.status(HttpStatus.OK).body(page);
    }
	
}
