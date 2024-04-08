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
public class main extends interfacing {
    public static boolean replay = false;
    public static void main(String[] args) {
        game();
    }

    private static void game(){
        introduction();
        while(true){
            round();
        }
    }
}

