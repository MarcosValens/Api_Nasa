import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws IOException {
        LocalDate data  = LocalDate.now();
        asteroidService asteroids = new asteroidService();
        asteroids.getAsteroidsFromNasa(data);
    }
}
