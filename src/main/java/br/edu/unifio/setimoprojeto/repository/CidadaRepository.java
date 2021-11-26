package br.edu.unifio.setimoprojeto.repository;

import br.edu.unifio.setimoprojeto.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadaRepository extends JpaRepository<Cidade,Integer> {
}
