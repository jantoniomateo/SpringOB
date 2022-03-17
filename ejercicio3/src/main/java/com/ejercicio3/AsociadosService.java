package com.ejercicio3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface AsociadosService extends JpaRepository<Asociados, Long>{


}
