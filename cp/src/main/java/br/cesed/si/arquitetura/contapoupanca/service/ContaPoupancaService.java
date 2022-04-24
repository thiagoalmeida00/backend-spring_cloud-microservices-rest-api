package br.cesed.si.arquitetura.contapoupanca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.arquitetura.contapoupanca.entidade.ContaPoupanca;
import br.cesed.si.arquitetura.contapoupanca.repository.ContaPoupancaRepository;

@Service
@Validated
public class ContaPoupancaService {
	
	@Autowired
	private ContaPoupancaRepository contaPoupancaRepository;
	
//	service: buscar todas, buscar por id, inserir, atualizar e deletar;

	
	public List<ContaPoupanca> listarTodasContas() {
		return contaPoupancaRepository.findAll();
	}
	
	public ContaPoupanca listarPorId(Long id) {
		return contaPoupancaRepository.getById(id);
	}
	
	
	public ContaPoupanca criaConta(ContaPoupanca novaConta) {
		return contaPoupancaRepository.save(novaConta);
	}  
	
	public ContaPoupanca atualizarConta(Long id, ContaPoupanca novosDados) {
		ContaPoupanca contaPoupanca = contaPoupancaRepository.getById(id);
		atualiza(contaPoupanca, novosDados);	
		return contaPoupancaRepository.save(contaPoupanca);
	}
	
	private void atualiza(ContaPoupanca contaPoupanca, ContaPoupanca novosDados) {
		contaPoupanca.setVariacao(novosDados.getVariacao());
		contaPoupanca.setSaldo(novosDados.getSaldo());
		contaPoupanca.setJuros(novosDados.getJuros());
	}
	
	public void deletarConta(Long Id) {
		contaPoupancaRepository.deleteById(Id);
	}

	public ContaPoupancaRepository getContaPoupancaRepository() {
		return contaPoupancaRepository;
	}

	public void setContaPoupancaRepository(ContaPoupancaRepository contaPoupancaRepository) {
		this.contaPoupancaRepository = contaPoupancaRepository;
	}
	
}
