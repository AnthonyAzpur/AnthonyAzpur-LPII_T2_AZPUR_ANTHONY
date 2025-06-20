package com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.repository;

import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.model.DetalleAlquiler;
import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.model.DetalleAlquilerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleAlquilerRepository extends JpaRepository<DetalleAlquiler, DetalleAlquilerId> {

}
