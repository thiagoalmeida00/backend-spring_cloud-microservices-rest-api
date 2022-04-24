package br.cesed.si.arquitetura.contacorrente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.arquitetura.contacorrente.entidade.ContaCorrente;
import br.cesed.si.arquitetura.contacorrente.repository.ContaCorrenteRepository;

@Service
@Validated
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	public ContaCorrente buscarContaPorId(Long conta) {
		return contaCorrenteRepository.getById(conta);
	}

	public List<ContaCorrente> listarContas() {
		return contaCorrenteRepository.findAll();
	}

	@Transactional
	public ContaCorrente inserirConta(ContaCorrente contaCorrente) {
		return contaCorrenteRepository.save(contaCorrente);
	}

	@Transactional
	public ContaCorrente atualizarConta(Long conta, ContaCorrente novosDados) {
		ContaCorrente contaCorrente = contaCorrenteRepository.getById(conta);
		atualiza(contaCorrente, novosDados);
		return contaCorrenteRepository.save(contaCorrente);
	}
	
	private void atualiza(ContaCorrente contaCorrente, ContaCorrente novosDados) {
		contaCorrente.setAgencia(novosDados.getAgencia());
		contaCorrente.setSaldo(novosDados.getSaldo());
		contaCorrente.setTaxaManutencao(novosDados.getTaxaManutencao());
		contaCorrente.setLimiteSaque(novosDados.getLimiteSaque());
		contaCorrente.setLimiteChEsp(novosDados.getLimiteChEsp());
	}
	
	@Transactional
	public void excluirConta(Long id) {
		contaCorrenteRepository.deleteById(id);
	}

	public ContaCorrenteRepository getContaCorrenteRepository() {
		return contaCorrenteRepository;
	}

	public void setContaCorrenteRepository(ContaCorrenteRepository contaCorrenteRepository) {
		this.contaCorrenteRepository = contaCorrenteRepository;
	}
	
}
