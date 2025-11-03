package com.tuempresa.factura.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter
public class Producto {

    @Id
    @Column(length=9)
    int numero;

    @Column(length=50)
    @Required
    String descripcion;

    // ? Relación con la entidad Categoria
    @ManyToOne(fetch=FetchType.LAZY, optional=true)
    @DescriptionsList
    Categoria categoria;

    // ? Relación con Autor
    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Autor autor;

    @Money // La propiedad precio se usa para almacenar dinero
    BigDecimal precio; // BigDecimal se suele usar para dinero

    @Files // Galería de fotos
    @Column(length=32)
    String fotos;

    @TextArea // Texto largo
    String observaciones;

    @Embedded @NoFrame // Campo embebido sin marco
    private Direccion direccion;
}
