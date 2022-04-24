package br.cesed.si.arquitetura.contacorrente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.arquitetura.contacorrente.entidade.ContaCorrente;
import br.cesed.si.arquitetura.contacorrente.service.ContaCorrenteService;

@RestController
@RequestMapping(value = "/contaCorrente")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService contaCorrenteService;

	@RequestMapping(value = "/listarContas", method = RequestMethod.GET)
	public ResponseEntity<List<ContaCorrente>> listarContas() {

		List<ContaCorrente> listaContas = contaCorrenteService.listarContas();

		return new ResponseEntity<List<ContaCorrente>>(listaContas, HttpStatus.OK);
	}

	@RequestMapping(value = "/obterConta/{conta}", method = RequestMethod.GET)
	public ResponseEntity<ContaCorrente> obterConta(@PathVariable Long conta) {

		ContaCorrente contaCorrente = contaCorrenteService.buscarContaPorId(conta);

		if (contaCorrente == null) {
			return new ResponseEntity<ContaCorrente>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ContaCorrente>(contaCorrente, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/criarConta", method = RequestMethod.POST)
	public ResponseEntity<ContaCorrente> criarConta(@RequestBody ContaCorrente conta) {

		try {
			ContaCorrente contaInserida = contaCorrenteService.inserirConta(conta);
			return new ResponseEntity<ContaCorrente>(contaInserida, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ContaCorrente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/atualizarConta/{conta}", method = RequestMethod.PUT)
	public ResponseEntity<ContaCorrente> atualizarConta(@PathVariable Long conta, @RequestBody ContaCorrente contaCorrenteNova) {

		try {
			ContaCorrente contaAtualizada = contaCorrenteService.atualizarConta(conta, contaCorrenteNova);
			return new ResponseEntity<ContaCorrente>(contaAtualizada, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ContaCorrente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/excluirConta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluirConta(@PathVariable Long id) {

		contaCorrenteService.excluirConta(id);

		return ResponseEntity.noContent().build();
	}

	public ContaCorrenteService getConteCorrenteService() {
		return contaCorrenteService;
	}

	public void setConteCorrenteService(ContaCorrenteService contaCorrenteService) {
		this.contaCorrenteService = contaCorrenteService;
	}

}
