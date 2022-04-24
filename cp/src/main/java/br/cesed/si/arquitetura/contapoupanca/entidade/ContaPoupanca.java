package br.cesed.si.arquitetura.contapoupanca.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContaPoupanca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long conta;
	
	private Integer variacao;
	private Double saldo;
	private Double juros;
//	private Cliente cliente;

	public ContaPoupanca() {
	}

	public ContaPoupanca(Long conta, Integer variacao, Double saldo, Double juros) {
		super();
		this.conta = conta;
		this.variacao = variacao;
		this.saldo = saldo;
		this.juros = juros;
	}

	public Long getConta() {
		return conta;
	}

	public void setConta(Long conta) {
		this.conta = conta;
	}

	public Integer getVariacao() {
		return variacao;
	}

	public void setVariacao(Integer variacao) {
		this.variacao = variacao;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getJuros() {
		return juros;
	}

	public void setJuros(Double juros) {
		this.juros = juros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((juros == null) ? 0 : juros.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		result = prime * result + ((variacao == null) ? 0 : variacao.hashCode());
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
		ContaPoupanca other = (ContaPoupanca) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (juros == null) {
			if (other.juros != null)
				return false;
		} else if (!juros.equals(other.juros))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		if (variacao == null) {
			if (other.variacao != null)
				return false;
		} else if (!variacao.equals(other.variacao))
			return false;
		return true;
	}
}