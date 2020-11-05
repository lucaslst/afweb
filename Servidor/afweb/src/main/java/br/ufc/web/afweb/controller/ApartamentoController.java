package br.ufc.web.afweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.afweb.model.Apartamento;
import br.ufc.web.afweb.service.ApartamentoService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/apartamentos")

public class ApartamentoController {

	@Autowired
    ApartamentoService aptService;
 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Apartamento>> getApartamento() {
        return new ResponseEntity<List<Apartamento>>(aptService.getApartamento(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Apartamento> getApartamentoById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Apartamento>(aptService.getApartamentoById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Apartamento> addApartamento(@RequestBody Apartamento apt) {
        return new ResponseEntity<Apartamento>(aptService.addApartamento(apt.getEndereco(), apt.getQtdquartos(), apt.getQtdvagasgaragem(), apt.getValoraluguel(), apt.getValorcondominio(), apt.getDatapostagem()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Apartamento> updateApartamento(@PathVariable("id") Integer id, @RequestBody Apartamento apt) {
        return new ResponseEntity<Apartamento>(aptService.updateApartamento(id, apt.getEndereco(), apt.getQtdquartos(), apt.getQtdvagasgaragem(), apt.getValoraluguel(), apt.getValorcondominio(), apt.getDatapostagem()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteApartamento(@PathVariable("id") Integer id) {
        if (aptService.removeApartamento(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/search", params = "endereco")
    public ResponseEntity<List<Apartamento>> getApartamentoByEndereco(@RequestParam("endereco") String endereco){
    	return new ResponseEntity<List<Apartamento>>(aptService.getApartamentoByEndereco(endereco), HttpStatus.OK);
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/page", params = "valoraluguel")
    public ResponseEntity<List<Apartamento>> getApartamentoByAluguel(@RequestParam("valoraluguel") double valoraluguel){
    	return new ResponseEntity<List<Apartamento>>(aptService.getApartamentoByAluguel(valoraluguel), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/page2")
    public ResponseEntity<List<Apartamento>> getApartamentoByMNAluguel(@RequestParam("menoraluguel") double menor, @RequestParam("maioraluguel") double maior){
    	return new ResponseEntity<List<Apartamento>>(aptService.getApartamentoByMNAluguel(menor, maior), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/page3")
    public ResponseEntity<List<Apartamento>> getApartamentoByAluguelCond(@RequestParam("menoraluguel") double menoraluguel, @RequestParam("maioraluguel") double maioraluguel, @RequestParam("menorcond") double menorcond, @RequestParam("maiorcond") double maiorcond){
    	return new ResponseEntity<List<Apartamento>>(aptService.getApartamentoByAluguelCond(menoraluguel, maioraluguel, menorcond, maiorcond), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/page", params = "quantidade")
    public ResponseEntity<List<Apartamento>> getApartamentoByQuantidade(@RequestParam("quantidade") Integer quantidade){
    	return new ResponseEntity<List<Apartamento>>(aptService.getApartamentoByQuantidade(quantidade), HttpStatus.OK);
    }
    
}
