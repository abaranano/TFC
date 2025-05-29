package com.tfc.Deudak.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "User")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String phone;

    @OneToMany(mappedBy = "deudor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeudaModel> deudasComoDeudor = new ArrayList<>();

    @OneToMany(mappedBy = "acreedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeudaModel> deudasComoAcreedor = new ArrayList<>();
}
