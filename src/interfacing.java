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
    private static boolean validateInput(String input, int format){
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
}
