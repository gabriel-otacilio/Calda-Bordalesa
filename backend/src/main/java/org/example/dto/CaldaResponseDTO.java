package org.example.dto;

import org.example.entity.Planta;

public class CaldaResponseDTO {
    public double agua;
    public double reagente;
    public Planta planta;

    public CaldaResponseDTO(double agua, double reagente, Planta planta) {
        this.agua = agua;
        this.reagente = reagente;
        this.planta = planta;
    }
}
