package com.juliana.clinica_USA.service;

import com.juliana.clinica_USA.model.PacientModel;
import com.juliana.clinica_USA.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientService {

    @Autowired
    PacientRepository pacientRepository;

    public List<PacientModel> obtener(){
        return pacientRepository.findAll();
    }

    public void agendar(PacientModel pacient){
        pacientRepository.save(pacient);
    }
    public void cancelar(int id ){
        pacientRepository.deleteById(id);
    }

    public void actualizar(PacientModel pacient){
        if(pacientRepository.existsById(pacient.getIdPacient())){
            pacientRepository.save(pacient);
        }
    }
}
