package br.com.SeguroBanco.repository;

import br.com.SeguroBanco.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long> {
    List<Seguro> findByCategoriaIn(List<String> categorias);

}
