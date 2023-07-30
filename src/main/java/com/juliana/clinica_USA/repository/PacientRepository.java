package com.juliana.clinica_USA.repository;

import com.juliana.clinica_USA.model.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacientRepository extends JpaRepository<PacientModel,Integer> {

    @Query(value = "SELECT pacient.*, count(*) AS count_status FROM pacient \n"+
            "GROUP BY client.id_client\n", nativeQuery = true)
    List<PacientModel> reportPacients(String status);
}
