package br.com.drummond.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.drummond.aula.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>  {
	
	List<Aluno> findByEmail(String email);
	List<Aluno> findByEmailLike(String email);
	List<Aluno> findByEmailIgnoreCaseLikeOrNomeIgnoreCaseLikeOrderByNome(String email, String nome);
}
