class main {
    public static void main(String[] args) {
        grid testGrid = new grid();
        //testGrid.printGrid();
        int[][] sampleGrid1 = {
            {4, 3, 5, 2, 6, 9, 7, 8, 1},
            {6, 8, 2, 5, 7, 1, 4, 9, 3},
            {1, 9, 7, 8, 3, 4, 5, 6, 2},
            {8, 2, 6, 1, 9, 5, 3, 4, 7},
            {3, 7, 4, 6, 8, 2, 9, 1, 5},
            {9, 5, 1, 7, 4, 3, 6, 2, 8},
            {5, 1, 9, 3, 2, 6, 8, 7, 4},
            {2, 4, 8, 9, 5, 7, 1, 3, 6},
            {7, 6, 3, 4, 1, 8, 2, 5, 9}
        };
        testGrid.arrayToGrid(sampleGrid1);
        if (!gcheck.parser(testGrid.gameGrid)){
            System.out.println("Invalid grid");
        }
        else{
            System.out.println("Valid grid");
        }



        /* Expected order of operations:
        Start menu
        smth
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

    }
}

