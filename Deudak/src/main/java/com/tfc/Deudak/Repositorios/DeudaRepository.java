package com.tfc.Deudak.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tfc.Deudak.Modelos.DeudaModel;

public interface DeudaRepository extends JpaRepository<DeudaModel, Long> {}