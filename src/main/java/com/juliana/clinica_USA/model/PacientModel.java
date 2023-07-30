package com.juliana.clinica_USA.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Pacient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pacient")
    private int idPacient;

    @Column(length = 250)
    private String paciente;

    @Column(length = 250)
    private String servicio;

    @Column(length = 8)
    private float precio;

    @Column(length = 6)
    private String hora;

}
