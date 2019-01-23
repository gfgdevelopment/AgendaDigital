package br.com.iftm.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessExecption;
import br.com.iftm.business.CidadeBusiness;
import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.enums.Estado;

@RestController // habilita Classe como um servico rest.
@RequestMapping(value = "/cidade") // Nome do Serviço.

public class CidadeRest {

	@Autowired // procura pela classe, evita de instanciar
	private CidadeBusiness cidadeBusiness; // acessando a classe

	// CREATE
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cidade cidade) {

		try {
			cidade = cidadeBusiness.create(cidade);
			return ResponseEntity.ok(cidade);
		} catch (BusinessExecption e) {
			e.printStackTrace();
			// mensagem de erro
			return ResponseEntity.badRequest().body(e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	// READ
	@GetMapping
	public ResponseEntity<?> read() {

		try {
			List<Cidade> retorna = cidadeBusiness.read();

			if (retorna.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				// devolve a lista
				return ResponseEntity.ok(retorna);
			}

		} catch (BusinessExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e); // retorna um codigo de badRequest
		}

	}

	// READ BY ESTADO (buscar por estado)
	@GetMapping("/filtro/estado") // rota que será retornada algum dado
	public ResponseEntity<?> readByEstado(@PathParam("estado") Estado estado) {

		try {
			List<Cidade> retornaEstado = cidadeBusiness.readByEstado(estado);

			if (retornaEstado == null || retornaEstado.isEmpty()) {
				return ResponseEntity.notFound().build();
			} else {
				// devolve a lista
				return ResponseEntity.ok(retornaEstado);
			}

		} catch (BusinessExecption e) {
			// mensagem de erro
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e); // retorna um codigo de badRequest
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	// UPDATE
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Cidade cidade) {

		try {
			cidade = cidadeBusiness.update(cidade);

			// devolve o objeto criado
			return ResponseEntity.ok(cidade);
		} catch (BusinessExecption e) {
			e.printStackTrace();
			// mensagem de erro
			return ResponseEntity.badRequest().body(e);
		}
	}

	// DELETE
	@DeleteMapping(value = "/{id}") // deletando pelo código, no caso ID
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

		try {
			cidadeBusiness.delete(id);
			return ResponseEntity.ok().build();

		} catch (BusinessExecption e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

}
