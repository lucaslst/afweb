package br.ufc.web.afweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.afweb.model.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Integer> {

	List<Apartamento> findByEndereco(String endereco);

}
