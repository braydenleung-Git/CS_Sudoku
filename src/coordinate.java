/**
 * This class is used as a pass-through for data that cannot be easily pass through the primitive return types,
 * and such, the instances of this class can instantiate to pass down that information
 */
public class coordinate {
    private int verticalCoordinate = 0;
    private int horizontalCoordinate = 0;

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
