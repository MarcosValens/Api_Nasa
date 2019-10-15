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

public class NasaService {
    private static final String API_KEY_NASA = "ShV0umuKcz7vJybpcvHldBMGOLzgb3elRrfbeSJw";
    private List<Asteroid> asteroids = new ArrayList<>();
    public List<Asteroid> getAsteroidsFromNasa(LocalDate data) throws IOException {

        String date = data.toString();
        URL client = new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date=" + date + "&end_date=" + date + "&api_key=" + API_KEY_NASA);
        URLConnection conexion = client.openConnection();
        conexion.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String inputLine;
        String outputLine = "";
        while ((inputLine = in.readLine()) != null) {
            outputLine += inputLine;
        }
        in.close();
        try {
            JSONParser parser = new JSONParser();
            JSONObject principal = (JSONObject) parser.parse(outputLine);
            JSONObject meteoritosData = (JSONObject) principal.get("near_earth_objects");
            JSONArray meteoritos = (JSONArray) meteoritosData.get(date);
            for (int i = 0; i < meteoritos.size(); i++) {
                JSONObject asteroidObject = (JSONObject) meteoritos.get(i);
                JSONObject asteroidSize = (JSONObject) asteroidObject.get("estimated_diameter");
                JSONObject asteroidKilometers = (JSONObject) asteroidSize.get("kilometers");
                JSONArray asteroidSpeed = (JSONArray) asteroidObject.get("close_approach_data");
                JSONObject relativeSpeed = (JSONObject) asteroidSpeed.get(0);
                JSONObject kmHour = (JSONObject) relativeSpeed.get("relative_velocity");
                double size = (double) asteroidKilometers.get("estimated_diameter_max");
                double speed =  Double.parseDouble((String)kmHour.get("kilometers_per_hour"));
                boolean isDangerous = (boolean) asteroidObject.get("is_potentially_hazardous_asteroid");
                String name = (String)asteroidObject.get("name");
                Asteroid asteroid = new Asteroid(name,speed,isDangerous,size);
                asteroids.add(asteroid);
            }
        } catch (org.json.simple.parser.ParseException e){
            e.printStackTrace();
        }
        return asteroids;
    }
}
