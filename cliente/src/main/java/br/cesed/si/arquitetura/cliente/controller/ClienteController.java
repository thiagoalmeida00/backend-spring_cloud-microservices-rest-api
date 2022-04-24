package br.cesed.si.arquitetura.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.arquitetura.cliente.entidade.Cliente;
import br.cesed.si.arquitetura.cliente.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/listarClientes", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listarClientes() {

		List<Cliente> listaClientes = clienteService.listarTodosClientes();

		return new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
	}

	@RequestMapping(value = "/obterCliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> obterCliente(@PathVariable Long id) {

		Cliente cliente = clienteService.buscarClientePorId(id);

		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/criarCliente", method = RequestMethod.POST)
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {

		try {
			Cliente clienteInserido = clienteService.inserirCliente(cliente);
			return new ResponseEntity<Cliente>(clienteInserido, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/atualizarCliente/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {

		try {
			Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
			return new ResponseEntity<Cliente>(clienteAtualizado, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/excluirCliente/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {

		clienteService.excluirCliente(id);

		return ResponseEntity.noContent().build();
	}
	
	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

}
