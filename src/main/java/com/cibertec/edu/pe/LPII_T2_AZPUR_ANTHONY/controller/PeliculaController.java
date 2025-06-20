package com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.controller;

import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.model.Pelicula;
import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    // Mostrar lista de películas
    @GetMapping
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.listarPeliculas2());
        return "peliculas/listar";
    }

    // Mostrar formulario para nueva película
    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/crear";
    }

    // Guardar película nueva
    @PostMapping
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardar(pelicula);
        return "redirect:/peliculas";
    }

    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Optional<Pelicula> optionalPelicula = peliculaService.obtenerPorId(id);
        if (optionalPelicula.isPresent()) {
            model.addAttribute("pelicula", optionalPelicula.get());
            return "peliculas/actualizar"; // templates/peliculas/editar.html
        } else {
            return "redirect:/peliculas"; // Si no se encuentra, redirige
        }
    }

    // Actualizar película
    @PostMapping("/actualizar")
    public String actualizarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardar(pelicula); // Usa el mismo método que guardar
        return "redirect:/peliculas";
    }

    // Eliminar película
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Long id) {
        peliculaService.eliminar(id);
        return "redirect:/peliculas";
    }
}
