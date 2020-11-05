package br.ufc.web.afweb.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.afweb.model.Apartamento;
import br.ufc.web.afweb.repository.ApartamentoRepository;

@Service
public class ApartamentoService {
	@Autowired
    ApartamentoRepository aptRepo;
    
    public Apartamento addApartamento(String endereco, int qtdquartos, int qtdvagasgaragem, double valoraluguel,
			double valorcondominio, String datapostagem) {
        Apartamento apt = new Apartamento(endereco, qtdquartos, qtdvagasgaragem, valoraluguel, valorcondominio, datapostagem);
        return aptRepo.save(apt);
    }
    
    public boolean removeApartamento(Integer id) {
        if(aptRepo.existsById(id)) {
            aptRepo.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Apartamento> getApartamento() {
        return aptRepo.findAll();
    }
    
    public Apartamento getApartamentoById(Integer id) {
        return aptRepo.findById(id).get();
    }
    
    public List<Apartamento> getApartamentoByEndereco(String endereco) {
        return aptRepo.findByEndereco(endereco);
    }
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Apartamento> getApartamentoByAluguel(double valoraluguel){
    	List<Apartamento> consultaAluguel = entityManager.createQuery("SELECT apartamento from apartamentos apartamento WHERE apartamento.valoraluguel < ?1", Apartamento.class).setParameter(1, valoraluguel).getResultList();
    	
    	return consultaAluguel;
    }
    
    public List<Apartamento> getApartamentoByMNAluguel(double menor, double maior){
    	List<Apartamento> consultaMNAluguel = entityManager.createQuery("SELECT apartamento from apartamentos apartamento WHERE apartamento.valoraluguel > ?1 AND apartamento.valoraluguel < ?2", Apartamento.class).setParameter(1, menor).setParameter(2, maior).getResultList();
    	
    	return consultaMNAluguel;
    }
    
    public List<Apartamento> getApartamentoByAluguelCond(double menoraluguel, double maioraluguel, double menorcond,double maiorcond){
    	List<Apartamento> consultaAluguelCond = entityManager.createQuery("SELECT apartamento from apartamentos apartamento WHERE apartamento.valoraluguel > ?1 AND apartamento.valoraluguel < ?2 AND apartamento.valorcondominio > ?3 AND apartamento.valorcondominio < ?4 ORDER BY apartamento.id DESC", Apartamento.class).setParameter(1, menoraluguel).setParameter(2, maioraluguel).setParameter(3, menorcond).setParameter(4, maiorcond).getResultList();
    	
    	return consultaAluguelCond;
    }
    
    public List<Apartamento> getApartamentoByQuantidade(int quantidade){
    	List<Apartamento> consulta = entityManager.createQuery("SELECT apartamento from apartamentos apartamento ORDER BY apartamento.id", Apartamento.class).setMaxResults(quantidade).getResultList();
    	
    	return consulta;
    }
    
    
    public Apartamento updateApartamento(Integer id, String endereco, int qtdquartos, int qtdvagasgaragem, double valoraluguel,
			double valorcondominio, String datapostagem){
        Apartamento aptAux = aptRepo.findById(id).get();
        if(aptAux != null) {
            aptAux.setId(id);
            aptAux.setEndereco(endereco);
            aptAux.setQtdquartos(qtdquartos);
            aptAux.setQtdvagasgaragem(qtdvagasgaragem);
            aptAux.setValoraluguel(valoraluguel);
            aptAux.setValorcondominio(valorcondominio);
            aptAux.setDatapostagem(datapostagem);
            aptRepo.save(aptAux);         
        }
        
        return aptAux;
    }

}
