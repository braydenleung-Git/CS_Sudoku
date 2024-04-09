/*
To do list:

 */
public class game extends interfacing {
    public static boolean replay = false;
    public static void main(String[] args) {
        do {
            gameProcedure();
        } while (replay);
    }

    private static void gameProcedure(){
        introduction();
        int currentStatus = 0;
        while(currentStatus == 0){
            currentStatus = round();
        }
    }
}

