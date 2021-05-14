package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Coche;
import com.example.demo.service.CocheService;

@RestController
@RequestMapping("/coche")


@ResponseStatus

@ControllerAdvice

public class CocheController {
	
	@Autowired
	CocheService cocheService;

	@GetMapping("/lista")
	public ResponseEntity<java.util.List<Coche>>lista(){
		java.util.List<Coche>lista=cocheService.lista();
		return new ResponseEntity<List<Coche>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/verid/{id}")
	public ResponseEntity<Coche> verId(@PathVariable("id") int id){
		java.util.Optional<Coche>coche=cocheService.getById(id);
		return new ResponseEntity(coche, HttpStatus.OK);
	}
	
	@GetMapping("/vermarca/{marca}")
	public ResponseEntity<List<Coche>> verMarca(@PathVariable("marca") String marca){
		java.util.List<Coche>coches=cocheService.getByMarca(marca);
		return new ResponseEntity(coches, HttpStatus.OK);
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> save(@RequestBody Coche coche){
		cocheService.saveProcedure(coche);
		return new ResponseEntity("coche guardado",HttpStatus.CREATED);
	}
	
	@GetMapping("/media")
	public ResponseEntity<Float>mediaKm(){
		float media=cocheService.mediaKm();
		return new ResponseEntity(media,HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar(@PathVariable("id") int id){
		cocheService.borrarProcedure(id);
		return new ResponseEntity("body:coche eliminado",HttpStatus.OK);
	}
}

