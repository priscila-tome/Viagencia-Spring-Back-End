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

import br.com.viagencia.model.Cliente;
import br.com.viagencia.repository.ClienteRepository;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@GetMapping ("/{id}")
	public Cliente listarPorId(@PathVariable Integer id) {
		return clienteRepository.findById(id).get();
	}
	
	@DeleteMapping ("/{id}")
	public String deletarPorId(@PathVariable Integer id) {
		clienteRepository.deleteById(id);
		return "Deletado com sucesso";
	}
	
	@PutMapping ("/{id}")
	public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable Integer id) {
		
		Cliente clienteAtualizado = clienteRepository.findById(id).get();
		clienteAtualizado.setNome(cliente.getNome());
		
		return clienteRepository.save(clienteAtualizado);
	}
	

}
