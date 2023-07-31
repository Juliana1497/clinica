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

    public List<PacientModel> buscar(String paciente,String servicio, String hora){
        return pacientRepository.findByPacienteAndServicioAndHora(paciente,servicio,hora);
    }

    //Obtener los datos ordenados descendentemente
    public List<PacientModel> ordenar(){
        return pacientRepository.order();
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

    //Obtener el nombre del paciente con la cita más costosa
    public List<PacientModel> maximo(){
        return pacientRepository.max();
    }

    //Obtener el nombre del paciente con la cita menos costosa
    public List<PacientModel> minimo(){
        return pacientRepository.min();
    }

    //Obtener el promedio de los precios
    public List<PacientModel> promedio(){
        return pacientRepository.average();
    }
}
