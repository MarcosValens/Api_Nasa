package com.esliceu.service;

import com.esliceu.model.Asteroid;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LocalService {

    private List<Asteroid> asteroids;

    public LocalService() {
        this.asteroids = new ArrayList<>();
    }

    public List<Asteroid> findAll() throws IOException {
       return this.asteroids;
    }

    public void addAsteroid(Asteroid asteroid){
        this.asteroids.add(asteroid);
    }

    public void removeAsteroid(int index){
        this.asteroids.remove(index);
    }


}
