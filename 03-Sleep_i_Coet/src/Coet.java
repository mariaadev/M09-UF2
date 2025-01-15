import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Coet {
    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor();
            motors[i].setName("Motor " + i);
        }
    }

    public void passaAPotencia(int p) {
        System.out.println("Passant a potència " + p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }
    
     public static void main(String[] args) {
        Coet coet = new Coet();

        coet.arranca();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = reader.readLine();
                if (input == null || input.trim().isEmpty()) continue;

                int potencia = Integer.parseInt(input.trim());
                coet.passaAPotencia(potencia);

                if (potencia == 0) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
