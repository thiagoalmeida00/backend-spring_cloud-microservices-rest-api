package br.cesed.si.arquitetura.contacorrente.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ContaCorrente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long conta;
	
	private String agencia;
	private Double saldo;
	private Double taxaManutencao;
	private Double limiteSaque;
	private Double limiteChEsp;
	
	
	public ContaCorrente() {
	}
	
	public ContaCorrente(String agencia, Long conta, Double saldo, Double taxaManutencao, Double limiteSaque, Double limiteChEsp) {
		this.agencia = agencia;
		this.conta = conta;
		this.saldo = saldo;
		this.taxaManutencao = taxaManutencao;
		this.limiteSaque = limiteSaque;
		this.limiteChEsp = limiteChEsp;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Long getConta() {
		return conta;
	}

	public void setConta(Long conta) {
		this.conta = conta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getTaxaManutencao() {
		return taxaManutencao;
	}

	public void setTaxaManutencao(Double taxaManutencao) {
		this.taxaManutencao = taxaManutencao;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public Double getLimiteChEsp() {
		return limiteChEsp;
	}

	public void setLimiteChEsp(Double limiteChEsp) {
		this.limiteChEsp = limiteChEsp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((limiteChEsp == null) ? 0 : limiteChEsp.hashCode());
		result = prime * result + ((limiteSaque == null) ? 0 : limiteSaque.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		result = prime * result + ((taxaManutencao == null) ? 0 : taxaManutencao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrente other = (ContaCorrente) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (limiteChEsp == null) {
			if (other.limiteChEsp != null)
				return false;
		} else if (!limiteChEsp.equals(other.limiteChEsp))
			return false;
		if (limiteSaque == null) {
			if (other.limiteSaque != null)
				return false;
		} else if (!limiteSaque.equals(other.limiteSaque))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		if (taxaManutencao == null) {
			if (other.taxaManutencao != null)
				return false;
		} else if (!taxaManutencao.equals(other.taxaManutencao))
			return false;
		return true;
	}
	
}
