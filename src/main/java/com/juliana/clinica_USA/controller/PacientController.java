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
        System.out.println(pacientService.ordenar());
        return pacientService.ordenar();
    }

    @GetMapping("/all")
    public List<PacientModel> obtener(){
        System.out.println(pacientService.obtener());
        return pacientService.obtener();
    }

    //Crear metodo para buscar por un atributo en especifico
    @GetMapping("/all-paciente-servicio-hora")
    public List<PacientModel> buscar(@RequestParam String paciente,@RequestParam String servicio, @RequestParam String hora){
        System.out.println(pacientService.buscar(paciente, servicio, hora));
        return pacientService.buscar(paciente, servicio, hora);
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

    //Obtener el paciente con la cita más costosa
    @GetMapping("/name-maxprecio")
    public List<PacientModel> maximo(){
        System.out.println(pacientService.maximo());
        return pacientService.maximo();
    }

    //Obtener el paciente con la cita menos costosa
    @GetMapping("/name-minprecio")
    public List<PacientModel> minimo(){
        System.out.println(pacientService.minimo());
        return pacientService.minimo();
    }

    //Obtener el promedio de los precios
    @GetMapping("/precio-promedio")
    public List<PacientModel> promedio(){
        System.out.println(pacientService.promedio());
        return pacientService.promedio();
    }
}
