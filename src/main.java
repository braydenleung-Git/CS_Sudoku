/* Expected order of operations:
       Start menu
       flush
       print grid
       action options
       action prompt(mark, set, remove)
       set location
       check grid
       flush
       cycle if not finished
       end menu
       */

/*
To do list:
incorrect coordinate printing
update ui of grid
introduction logic error/unfinished
- skipping tutorial is not working properly


 */
public class main extends interfacing {
    public static boolean replay = false;
    public static void main(String[] args) {
        do {
            game();
        } while (replay);
    }

    private static void game(){
        introduction();
        int currentStatus = 0;
        while(currentStatus == 0){
            currentStatus = round();
        }
    }
}

