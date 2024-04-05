import java.util.Scanner;

public class interfacing {


    /**
     * This method takes in an input, and the format of the expected input, and returns whether it is in the correct format or not
     * This is currently marked as not working, as another solution is available
     *
     * @param input user input
     * @param format expected format
     * @return
     */
    public static boolean validateInput(String input, int format){
        if (format == 0){
            if (input.length() > 2){
                System.out.println("Input is too long");
                return false;
            }
            //CALL THE GETVERT OR GETHOR METHODS
        }
        else if (format == 1){
            char[] expected = {'q', 'r','s','d'};
            for (int i = 0; i < expected.length; i++) {
                if (input.charAt(0) == expected[i]){
                    return true;
                }
            }
        }
        return false;
    }

    public static String readLine(String prompt) {
        Scanner obj = new Scanner(System.in);
        System.out.print(prompt);
        return obj.nextLine().toUpperCase();
    }
    public static int readInt(String prompt) {
        while(true){
            String input = readLine(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ignored){

            }
        }
    }
    public static void flush() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
