package com.juliana.clinica_USA.controller;

import com.juliana.clinica_USA.model.PacientModel;
import com.juliana.clinica_USA.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacient")
@CrossOrigin(value = "*")
public class PacientController {
    @Autowired
    PacientService pacientService;

    //Obtener los datos ordenados descendentemente
    @GetMapping("/all-order")
    public List<PacientModel> ordenar(){
        return pacientService.ordenar();
    }

    @GetMapping("/all")
    public List<PacientModel> obtener(){
        return pacientService.obtener();
    }

    //Crear metodo para buscar por un atributo en especifico
    @GetMapping("/all-idPacient-paciente-servicio-hora")
    public List<PacientModel> buscar(@RequestParam int idPacient,@RequestParam String paciente,@RequestParam String servicio, @RequestParam String hora){
        return pacientService.buscar(idPacient, paciente, servicio, hora);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void agendar(@RequestBody PacientModel pacient){
        pacientService.agendar(pacient);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody PacientModel pacient){
        pacientService.actualizar(pacient);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelar(@PathVariable int id){
        pacientService.cancelar(id);
    }
}
