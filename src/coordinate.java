/**
 * This class is used as a pass-through for coordinate on a grid, such that increasing readability, and ease of implementing coordinate to other classes
 *
 * All coordinate defined has to be compliant to the index that the array is set to
 */
public class coordinate {
    private int verticalCoordinate;
    private int horizontalCoordinate;

    /**
     * This is the overload constructor method
     */
    public coordinate(){
        verticalCoordinate = 0;
        horizontalCoordinate = 0;
    }

    /**
     * This is the default constructor method for coordinate objects
     * @param verticalCoordinate vertical coordinate
     * @param horizontalCoordinate horizontal coordinate
     */
    public coordinate(int verticalCoordinate, int horizontalCoordinate){
        this.verticalCoordinate = verticalCoordinate;
        this.horizontalCoordinate = horizontalCoordinate;
    }
    public int getVerticalCoordinate() {
        return verticalCoordinate;
    }

    public int getHorizontalCoordinate() {
        return horizontalCoordinate;
    }

    public void setVerticalCoordinate(int verticalCoordinate){
        this.verticalCoordinate = verticalCoordinate;
    }
    public void setHorizontalCoordinate(int horizontalCoordinate) {
        this.horizontalCoordinate = horizontalCoordinate;
    }

    @Override
    public String toString() {
        return "coordinate{" +
                "row:" + verticalCoordinate +
                ", column:" + horizontalCoordinate +
                '}';
    }
}
