package br.com.viagencia.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viagencia.model.Destino;
import br.com.viagencia.repository.DestinoRepository;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("api/destino")
public class DestinoController {
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	@GetMapping
	public List<Destino> listar() {
		return destinoRepository.findAll();
	}
	
	@PostMapping
	public Destino adicionar(@RequestBody Destino destino) {
		return destinoRepository.save(destino);
	}
	
	@GetMapping ("/{id}")
	public Destino listarPorId(@PathVariable Integer id) {
		return destinoRepository.findById(id).get();
	}
	
	@DeleteMapping ("/{id}")
	public String deletarPorId(@PathVariable Integer id) {
		destinoRepository.deleteById(id);
		return "Deletado com sucesso";
	}
	
	@PutMapping ("/{id}")
	public Destino atualizar(@RequestBody Destino destino, @PathVariable Integer id) {
		
		Destino destinoAtualizado = destinoRepository.findById(id).get();
		destinoAtualizado.setCidade(destino.getCidade());
		destinoAtualizado.setEstado(destino.getEstado());
		destinoAtualizado.setPais(destino.getPais());
		
		return destinoRepository.save(destinoAtualizado);
	}
	

}
