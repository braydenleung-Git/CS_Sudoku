import java.util.Scanner;


public class interfacing {

    public void introduction() {
        int count = 0;
        String input = "";
        Scanner s1 = new Scanner(System.in);
        String in = "";
        System.out.println("Hello and welcome to the world of sudoku!");
        if (count > 0) {
            System.out.println("Do you wish to skip the tutorial?");
            in = (s1.nextLine()).toUpperCase();


        }
        if(in.equals("NO") || count < 0){
            System.out.println("");
            System.out.println("In this game, there is a 9x9 grid with some numbers already filled in and some that are empty.");
            System.out.println("Your job is to find out what belongs in the empty grids and fill them in!");
            System.out.println("Each 3x3 box should contain all of the numbers from 1-9 with no duplicates.");
            System.out.println("Therefore, if you type a '9' in a box that already contains a '9', you won't be able to complete the grid!");
            System.out.println("Each horizontal and vertical line should also have all numbers from 1-9 with no duplicates.");
            System.out.println("Use these important info in your play! Have fun in navigating the world of numbers and logic!");
            System.out.println();
        }
        else{
            System.out.println("");
            System.out.println("Please select the difficulty: ");
            System.out.println("Easy --> just right for beginners");
            System.out.println("Medium --> slightly more challenging");
            System.out.println("Difficult --> sudoku nightmare :)");
            System.out.println("");
        }
        input = (s1.nextLine()).toUpperCase();
    }

    public void

    public void finish() {
        //input conditions using if statements
        System.out.println("Good job! You solved the sudoku puzzle!");
    }



}
