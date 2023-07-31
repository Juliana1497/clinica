package com.juliana.clinica_USA.repository;

import com.juliana.clinica_USA.model.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacientRepository extends JpaRepository<PacientModel,Integer> {
    //Crear metodo para buscar por un atributo en especifico
    List<PacientModel> find(int idPacient, String paciente,String servicio, String hora);

    //Obtener los datos ordenados descendentemente
    @Query(value="select * from pacient order by precio desc", nativeQuery = true)
    List<PacientModel> order();

    //Obtener el nombre del paciente con la cita más costosa
}
