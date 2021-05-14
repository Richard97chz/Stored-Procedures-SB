package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Coche;
import com.example.demo.repository.CocheRepository;

@Service
public class CocheService {
	@Autowired
	CocheRepository cocheRepository;
	
	public java.util.List<Coche>lista(){
		//return cocheRepository.findAll();
		return cocheRepository.listaProcedure();
	}
	
	public java.util.Optional<Coche>getById(int id){
		return cocheRepository.idProcedure(id);
	}
	
	public java.util.List<Coche>getByMarca(String marca){
		return cocheRepository.marcaProcedure(marca);
	}
	
	public void saveProcedure(Coche coche) {
		cocheRepository.saveProcedure(coche.getMarca(),coche.getModelo(),coche.getAnyo(),coche.getKm());
	}
	
	public float mediaKm() {
		return cocheRepository.mediaKm();
	}
	
	public void borrarProcedure(int id) {
		cocheRepository.borrarProcedure(id);
	}
}

