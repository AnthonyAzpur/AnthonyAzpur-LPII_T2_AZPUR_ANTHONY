package com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.controller;

import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.model.Pelicula;
import com.cibertec.edu.pe.LPII_T2_AZPUR_ANTHONY.service.PeliculaService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public String listarPeliculas(Model model, @ModelAttribute("mensaje") String mensaje, @ModelAttribute("error") String error) {
        model.addAttribute("peliculas", peliculaService.listarPeliculas2());
        if(!mensaje.isEmpty()) {
            model.addAttribute("mensaje", mensaje);
        }
        if(!error.isEmpty()) {
            model.addAttribute("error", error);
        }
        return "peliculas/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/crear";
    }

    @PostMapping
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardar(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Optional<Pelicula> optionalPelicula = peliculaService.obtenerPorId(id);
        if (optionalPelicula.isPresent()) {
            model.addAttribute("pelicula", optionalPelicula.get());
            return "peliculas/actualizar";
        } else {
            return "redirect:/peliculas";
        }
    }

    @PostMapping("/actualizar")
    public String actualizarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardar(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            peliculaService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Película eliminada correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar la película porque está asociada a un alquiler.");
        }
        return "redirect:/peliculas";
    }
}
