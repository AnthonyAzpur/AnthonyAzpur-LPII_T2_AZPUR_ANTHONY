package com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.service;

import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.model.Pelicula;
import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service // Marca esta clase como un "servicio" de Spring, para que sea manejada como un componente
public class PeliculaService {

    // Inyección del repositorio que permite interactuar con la base de datos
    private final PeliculaRepository peliculaRepository;

    // Constructor para inyectar el repositorio (Spring lo hace automáticamente)
    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    // Método que devuelve todas las películas almacenadas en la base de datos
    public List<Pelicula> listarPeliculas2() {
        return peliculaRepository.findAll(); // Usa el método findAll del repositorio
    }

    // Método que guarda una nueva película o actualiza una existente
    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula); // Usa el método save del repositorio
    }

    public Optional<Pelicula> obtenerPorId(Long id) {
    return peliculaRepository.findById(id);
}

public void eliminar(Long id) {
    peliculaRepository.deleteById(id);
}

}

