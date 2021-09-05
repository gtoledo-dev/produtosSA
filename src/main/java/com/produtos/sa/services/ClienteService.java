package com.produtos.sa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.produtos.sa.entities.Cliente;
import com.produtos.sa.repositories.ClienteRepository;
import com.produtos.sa.services.exceptions.DatabaseException;
import com.produtos.sa.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();		
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cliente inserir(Cliente obj) {
		return clienteRepository.save(obj);
	}
	
	public void deletar(Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Cliente atualizar(Long id, Cliente obj) {
		Cliente entidade = clienteRepository.getOne(id);
		updateData(entidade, obj);
		return clienteRepository.save(entidade);
	}

	private void updateData(Cliente entidade, Cliente obj) {
		entidade.setNome(obj.getNome());
		entidade.setCpf(obj.getCpf());
		entidade.setDataNascimento(obj.getDataNascimento());		
	}

}
