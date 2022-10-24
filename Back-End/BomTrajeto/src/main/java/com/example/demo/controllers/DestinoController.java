package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Destino;
import com.example.demo.repositorys.ClienteRepository;
import com.example.demo.repositorys.DestinoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DestinoController {

	
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	
	@GetMapping("/destinos")
	public List<Destino> getAllDestinos(){
		return destinoRepository.findAll();
	}
	
	
	
	
	@GetMapping("/destinos/{id}")
	public ResponseEntity<Destino> getDestinoById(@PathVariable Long id) {
		Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destino inexistente"));
		 return ResponseEntity.ok(destino);
	}
	
	
	
	
	@PostMapping("/destinos")
	public Destino createDestino(@RequestBody Destino destino) {
		return destinoRepository.save(destino);
	}
	
	
	
	
	@PutMapping("destinos/{id}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino destinosDetails){
		
		Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destino Inexistente"));
		Cliente cliente = clienteRepository.findById(destinosDetails.getCliente().getId()).get();
		
		destino.setCidade(destinosDetails.getCidade());
		destino.setCliente(cliente);
		
		
		
	    Destino newDestino = destinoRepository.save(destino);
		
		return ResponseEntity.ok(newDestino); 
		}
	
	
	
	
	
	//DELETE
	@DeleteMapping("/destinos/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDestino(@PathVariable Long id){
		
		Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destino Inexistente"));
		
		destinoRepository.delete(destino);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Destino deletado ! deletado", Boolean.TRUE);
		return ResponseEntity.ok(response);
	
	
	
	}
	
}
	

	
	
	
	
	
	

