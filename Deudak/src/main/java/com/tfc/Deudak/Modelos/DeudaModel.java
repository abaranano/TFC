package com.tfc.Deudak.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Deuda")
public class DeudaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "deudor_id", nullable = false)
    private UserModel deudor;

    @ManyToOne
    @JoinColumn(name = "acreedor_id", nullable = false)
    private UserModel acreedor;
}