package br.cesed.si.arquitetura.contapoupanca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.arquitetura.contapoupanca.entidade.ContaPoupanca;
import br.cesed.si.arquitetura.contapoupanca.service.ContaPoupancaService;

@RestController
@RequestMapping(value = "/contaPoupanca")
public class ContaPoupancaController {

	@Autowired
	private ContaPoupancaService contaPoupancaService;

	@RequestMapping(value = "/contaPoupanca", method = RequestMethod.GET)
	public ResponseEntity<List<ContaPoupanca>> listarTodasContas() {

		List<ContaPoupanca> listaContaPoupanca = contaPoupancaService.listarTodasContas();

		return new ResponseEntity<List<ContaPoupanca>>(listaContaPoupanca, HttpStatus.OK);
	}

	@RequestMapping(value = "/contaPoupanca/{id}", method = RequestMethod.GET)
	public ResponseEntity<ContaPoupanca> listarPorId(@PathVariable Long id) {

		ContaPoupanca contaPoupanca = contaPoupancaService.listarPorId(id);

		if (contaPoupanca == null) {
			return new ResponseEntity<ContaPoupanca>(HttpStatus.NOT_FOUND);
		}

		else {
			return new ResponseEntity<ContaPoupanca>(contaPoupanca, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/criarConta", method = RequestMethod.POST)
	public ResponseEntity<ContaPoupanca> criaConta(@RequestBody ContaPoupanca novaConta) {

		try {

			ContaPoupanca contaInserida = contaPoupancaService.criaConta(novaConta);
			return new ResponseEntity<ContaPoupanca>(contaInserida, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ContaPoupanca>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/atualizarConta/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ContaPoupanca> atualizaConta(@PathVariable Long id, @RequestBody ContaPoupanca novaConta) {

		try {

			ContaPoupanca contaAtualizada = contaPoupancaService.atualizarConta(id, novaConta);
			return new ResponseEntity<ContaPoupanca>(contaAtualizada, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ContaPoupanca>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/deletarConta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarConta(@PathVariable Long id) {
		contaPoupancaService.deletarConta(id);
		return ResponseEntity.noContent().build();
	}
}
