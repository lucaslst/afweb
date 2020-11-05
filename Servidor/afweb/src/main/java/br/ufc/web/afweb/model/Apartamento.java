package br.ufc.web.afweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="apartamentos")

public class Apartamento {

	@Id
    @GeneratedValue

     int id;
	
	 //@Size(min = 5, max= 100, message = "Endereco deve ser maior que 0!")	
	 
	 String endereco;
	 int qtdquartos;
	 int qtdvagasgaragem;
	 double valoraluguel;
	 double valorcondominio;
	 String datapostagem;
	 
	 public Apartamento(int id, String endereco, int qtdquartos, int qtdvagasgaragem, double valoraluguel,
				double valorcondominio, String datapostagem) {
			super();
			this.id = id;
			this.endereco = endereco;
			this.qtdquartos = qtdquartos;
			this.qtdvagasgaragem = qtdvagasgaragem;
			this.valoraluguel = valoraluguel;
			this.valorcondominio = valorcondominio;
			this.datapostagem = datapostagem;
		}
	
	 public Apartamento(String endereco, int qtdquartos, int qtdvagasgaragem, double valoraluguel,
				double valorcondominio, String datapostagem) {
			super();
			this.endereco = endereco;
			this.qtdquartos = qtdquartos;
			this.qtdvagasgaragem = qtdvagasgaragem;
			this.valoraluguel = valoraluguel;
			this.valorcondominio = valorcondominio;
			this.datapostagem = datapostagem;
		}
	 
	 public Apartamento() {
	
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getQtdquartos() {
		return qtdquartos;
	}

	public void setQtdquartos(int qtdquartos) {
		this.qtdquartos = qtdquartos;
	}

	public int getQtdvagasgaragem() {
		return qtdvagasgaragem;
	}

	public void setQtdvagasgaragem(int qtdvagasgaragem) {
		this.qtdvagasgaragem = qtdvagasgaragem;
	}

	public double getValoraluguel() {
		return valoraluguel;
	}

	public void setValoraluguel(double valoraluguel) {
		this.valoraluguel = valoraluguel;
	}

	public double getValorcondominio() {
		return valorcondominio;
	}

	public void setValorcondominio(double valorcondominio) {
		this.valorcondominio = valorcondominio;
	}

	public String getDatapostagem() {
		return datapostagem;
	}

	public void setDatapostagem(String datapostagem) {
		this.datapostagem = datapostagem;
	}

	@Override
	public String toString() {
		return "Apartamento [id=" + id + ", endereco=" + endereco + ", qtdquartos=" + qtdquartos + ", qtdvagasgaragem="
				+ qtdvagasgaragem + ", valoraluguel=" + valoraluguel + ", valorcondominio=" + valorcondominio
				+ ", datapostagem=" + datapostagem + "]";
	}
	 
	 
	
}
