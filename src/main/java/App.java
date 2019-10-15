import com.esliceu.controller.AsteroidController;
import com.esliceu.model.Asteroid;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        /*CAPA VISTA
        * SOLO SE CONECTA CON EL CONTROLADOR*/
        LocalDate data  = LocalDate.now();
        AsteroidController asteroidControlller = new AsteroidController();
        List<Asteroid> asteroides = asteroidControlller.getAsteroids();
        for(Asteroid asteroid :asteroides){
            System.out.println("\nNombre: "+asteroid.getNombre()+"\nVelocidad: "+asteroid.getVelocidad()+"\nTamaño: "
            +asteroid.getTamano()+"\nPeligro: "+asteroid.isEsPeligroso());
        };
    }
}
