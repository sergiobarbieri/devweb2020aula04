package br.com.drummond.aula.resources;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.drummond.aula.domain.Aluno;
import br.com.drummond.aula.repository.AlunoRepository;

@RestController
@CrossOrigin
public class SearchResources {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	
	@RequestMapping(value = {"/health", "/"}, method = RequestMethod.GET)
	public ResponseEntity<?> health() {
		
		LocalDateTime serverOK = LocalDateTime.now();
		
		return ResponseEntity.status(HttpStatus.OK).body(serverOK.toString());
		
	}
	
	@RequestMapping(value = {"/query1"}, method = RequestMethod.GET)
	public ResponseEntity<?> query1(@RequestParam String email) {
		
		List<Aluno> alunos;
		
		alunos = alunoRepository.findByEmail(email);
		
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
		
	}
	
	@RequestMapping(value = {"/query2"}, method = RequestMethod.GET)
	public ResponseEntity<?> query2(@RequestParam String email) {
		
		List<Aluno> alunos;
		
		alunos = alunoRepository.findByEmailLike("%" + email + "%");
		
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
		
	}
	
	@RequestMapping(value = {"/query3"}, method = RequestMethod.GET)
	public ResponseEntity<?> query3(@RequestParam String arg) {
		
		List<Aluno> alunos;
		
		alunos = alunoRepository.findByEmailIgnoreCaseLikeOrNomeIgnoreCaseLikeOrderByNome("%" + arg + "%", "%" + arg + "%");
		
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
		
	}
	

}
