package com.wso.evento.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wso.evento.model.Evento;
import com.wso.evento.repository.Eventos;

@RestController
@RequestMapping("/eventos")
public class EventoResources {
	
	@Autowired
	private Eventos eventos;
	
	@GetMapping
	public List<Evento> listar() {
		return eventos.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Evento>> buscar(@PathVariable Long id) {
		Optional<Evento> evento = eventos.findById(id);
		
		if (evento == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(evento);
	}
	
	@PostMapping
	public Evento adicionar(@RequestBody @Valid	Evento evento) {
		return eventos.save(evento);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		Optional<Evento> evento = eventos.findById(id);
		
		if (evento == null) {
			return ResponseEntity.notFound().build();
		}
		
		eventos.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
