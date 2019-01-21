package br.com.iftm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.entily.TipoServico;


@RestController //habilita Classe como um servico rest.
@RequestMapping(value="/tiposervico") // Nome do Serviço.
public class TipoServicoRest {

	private List<TipoServico> lista = new ArrayList<>();
	private int indice = 0;
	
	//create
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody TipoServico tipoServico){ //requestBody está vindo no corpo da requisição
		
		//validação se está preenchido ou não
		if(StringUtils.isEmpty(tipoServico.getNome() )) {
			
			return ResponseEntity.badRequest().body("Nome Requerido!");
		}
		
		//numero do codigo em sequencia
		tipoServico.setCodigo(indice++);
		
		//envia para a lista
		lista.add(tipoServico);
		
		//devolve o objeto criado
		return ResponseEntity.ok(tipoServico);
	}
	
	
	//read
	@GetMapping
	public ResponseEntity<?> read(){
		
		return ResponseEntity.ok(lista);
	}
	
	//update
	@PutMapping
	public ResponseEntity<?> update(@RequestBody TipoServico tipoServico){ //requestBody está vindo no corpo da requisição
		
		if(tipoServico.getCodigo() == null) {
			
			return ResponseEntity.badRequest().body("Nome Requerido!");
		}
		
		//validação se está preenchido ou não
		if(StringUtils.isEmpty(tipoServico.getNome() )) {
			
			return ResponseEntity.badRequest().body("Nome Requerido!");
		}
		
		
		
		for(TipoServico tipoServico2 : lista) {
			
			if(tipoServico2.getCodigo().equals(tipoServico.getCodigo() )) {
				tipoServico2.setNome(tipoServico.getNome());
			}
		}
		
		//devolve o objeto criado
		return ResponseEntity.ok(tipoServico);
	}
	
	//delete
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody TipoServico tipoServico){
		
		if(StringUtils.isEmpty(tipoServico.getNome() )) {
			
			return ResponseEntity.badRequest().body("Nome Requerido!");
		}
		
		for(TipoServico tipoServico2 : lista) {
			
			if(tipoServico2.getCodigo().equals(tipoServico.getCodigo() )) {
				//remove da lista
				lista.remove(tipoServico2);
				break;
			}
		}
			
		return ResponseEntity.ok().build();
	}		
}
