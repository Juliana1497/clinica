package com.juliana.clinica_USA.repository;

import com.juliana.clinica_USA.model.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacientRepository extends JpaRepository<PacientModel,Integer> {

    //Crear metodo para buscar por un atributo en especifico
    List<PacientModel> findByPacienteAndServicioAndHora(String paciente,String servicio, String hora);

    //Obtener los datos ordenados descendentemente
    @Query(value="SELECT * from pacient ORDER BY precio DESC, id_pacient DESC", nativeQuery = true)
    List<PacientModel> order();

    //Obtener el nombre del paciente con la cita más costosa
    @Query(value = "SELECT paciente FROM pacient WHERE precio = (SELECT MAX(precio) FROM pacient) ORDER BY paciente", nativeQuery = true)
    List<PacientModel> max();

    //Obtener el nombre del paciente con la cita menos costosa
    @Query(value = "SELECT paciente FROM pacient WHERE precio = (SELECT MIN(precio) FROM pacient) ORDER BY paciente", nativeQuery = true)
    List<PacientModel> min();

    //Obtener el promedio del precio
    @Query(value="SELECT CAST(AVG(precio) AS DECIMAL(10,1)) AS promedio FROM pacient", nativeQuery = true)
    List<PacientModel> average();
}
