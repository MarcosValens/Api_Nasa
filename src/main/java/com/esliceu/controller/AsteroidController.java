package com.esliceu.controller;

import com.esliceu.model.Asteroid;
import com.esliceu.service.LocalService;
import com.esliceu.service.NasaService;
import java.util.List;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AsteroidController {
    LocalService localService;
    NasaService nasaService;

    public AsteroidController() {
        this.localService = new LocalService();
        this.nasaService = new NasaService();

    }

    public List<Asteroid> getAsteroids() throws IOException {
        LocalDate data = LocalDate.now();
        List<Asteroid> locals = this.localService.findAll();
        List<Asteroid> nasa = this.nasaService.getAsteroidsFromNasa(data);

        List<Asteroid> all = new ArrayList<>();
        all.addAll(locals);
        all.addAll(nasa);
        return all;
    }
}
