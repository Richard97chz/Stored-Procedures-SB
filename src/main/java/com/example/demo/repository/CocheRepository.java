package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche,Integer>{
	@Query(value="{call lista_procedure()}",nativeQuery=true)
	java.util.List<Coche> listaProcedure();
	
	@Query(value="{call id_procedure(:idIn)}", nativeQuery=true)
	java.util.Optional<Coche> idProcedure(@Param("idIn") int idIN);
	
	@Query(value="{call marca_procedure(:marcaIn)}", nativeQuery=true)
	java.util.List<Coche> marcaProcedure(@Param("marcaIn") String marcaIN);
	
	@Transactional
	@Modifying
	@Query(value="{call save_procedure(:marcaIn, :modeloIn, :anyoIn, :kmIn)}",nativeQuery=true)
	void saveProcedure(
			@Param("marcaIn") String marcaIn,
			@Param("modeloIn") String modeloIn,
			@Param("anyoIn") int anyoIn,
			@Param("kmIn") int kmIn
	);
	
	@Query(value="{call media_procedure}",nativeQuery=true)
	float mediaKm();
	
	
	@Transactional
	@Modifying
	@Query(value="{call borrar_procedure(:idIn)}", nativeQuery=true)
	void borrarProcedure(@Param("idIn") int idIN);
}
