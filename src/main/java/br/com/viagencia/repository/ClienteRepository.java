package br.com.viagencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.viagencia.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

}
