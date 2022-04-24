package br.cesed.si.arquitetura.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.arquitetura.cliente.entidade.Cliente;
import br.cesed.si.arquitetura.cliente.repository.ClienteRepository;

@Service
@Validated
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.getById(id);
	}

	public List<Cliente> listarTodosClientes() {
		return clienteRepository.findAll();
	}

	@Transactional
	public Cliente inserirCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Transactional
	public Cliente atualizarCliente(Long id, Cliente novosDados) {
		Cliente cliente = clienteRepository.getById(id);
		atualiza(cliente, novosDados);
		return clienteRepository.save(cliente);
	}
	
	private void atualiza(Cliente cliente, Cliente novosDados) {
		cliente.setCpf(novosDados.getCpf());
		cliente.setPrimeiroNome(novosDados.getPrimeiroNome());
		cliente.setSobrenome(novosDados.getSobrenome());
		cliente.setSexo(novosDados.getSexo());
		cliente.setDtNasc(novosDados.getDtNasc());
	}
	
	@Transactional
	public void excluirCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	public ClienteRepository getRepository() {
		return clienteRepository;
	}

	public void setRepository(ClienteRepository repository) {
		this.clienteRepository = repository;
	}

}
