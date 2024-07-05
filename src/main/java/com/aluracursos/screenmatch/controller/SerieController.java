package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService servicio;


    @GetMapping()
    public List<SerieDTO> obtenerTodasLasSeries(){
        return servicio.obtenerTodasLasSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obtenerTop5(){
        return servicio.obtenerTop5();
    }
    @GetMapping("/lanzamientos")
    public List<SerieDTO> obtenerLanzamientosMasRecientes(){
        return servicio.obtenerLanzamientosMasRecientes();
    }

    @GetMapping("/{id}")
    public SerieDTO obtenerPorId(@PathVariable Long id){
        return servicio.obtenerPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obtenerTemporadas(@PathVariable Long id) {
        return servicio.obtenerTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numTemporada}")
    public List<EpisodioDTO> obtenerEpisodiosPorTemporada(@PathVariable Long id,
                                                          @PathVariable Long numTemporada){
        return servicio.obtenerEpisodiosPorTemporada(id, numTemporada);
    }

    @GetMapping("/categoria/{nombreCategoria}")
    public List<SerieDTO> obtenerPorCategoria(@PathVariable String nombreCategoria){
        return servicio.obtenerPorCategoria(nombreCategoria);
    }

    @GetMapping("/{id}/temporadas/top")
    public List<EpisodioDTO> obtenerTopTemporada(@PathVariable Long id){
        return servicio.obtenerTopTemporada(id);
    }
}
