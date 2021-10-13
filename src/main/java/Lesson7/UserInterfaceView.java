package Lesson7;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter city name: ");
            String city = scanner.nextLine();
            setGlobalCity(city);

            System.out.println("Please enter chosen forecast: 1 - current forecast, " + "5 - forecast for the next 5 days, "
                    + "exit - finish and exit application");
            String command = scanner.nextLine();

            checkIsExit(command);
            try {
                validateUserInput(command);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
           /* try {
                notifyController(command);
            } catch (IOException e) {
                e.printStackTrace();
            }*/

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

      private void checkIsExit(String command) {
            if (command.toLowerCase().equals("exit")) {
                System.out.println("Application quites");
                System.exit(0);
            }
        }

        private void setGlobalCity(String city) {
            ApplicationGlobalState.getInstance().setSelectedCity(city);
        }

        private void validateUserInput (String userInput) throws IOException {
            if (userInput == null || userInput.length() != 1) {
                throw new IOException("incorrect input: one digit answer expected but got actually " + userInput);
            }
            int answer = 0;
            try {
                answer = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                throw new IOException("Incorrect input type: character but not digit!");
            }
        }

       // private void notifyController (String input) throws IOException {
       //     controller.getWeather(input);
       // }
    }

