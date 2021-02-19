package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    private double rovnice(Coordinate x, Coordinate y) {
        double a = ((double) y.getY() - x.getY()) / (y.getX() - x.getX());
        double result = (double) x.getY() - (a * x.getX());
        return result;
    }


    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) { // TODO: Implement this
        if(getSelectedPoints().size() < 3) {
            return false;
        }
        Coordinate[] xyArray = new Coordinate[3];
        int i = 0;
        for (Coordinate getCoords : getSelectedPoints()) {
            xyArray[i] = getCoords;
            i++;
        }
        float a =(float)(xyArray[1].getY() - xyArray[0].getY() / xyArray[1].getX() - xyArray[0].getX());
        float b = xyArray[0].getY() - a * coordinate.getX();

        if (coordinate.getY() <= a * coordinate.getX() + b && ) {
            return true;
        }
        return false;

    }
}
