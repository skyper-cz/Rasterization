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

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) {
        if(getSelectedPoints().size() < 3) {
            return false;
        }
        Coordinate[] xyArray = new Coordinate[3];
        int i = 0;
        for (Coordinate getCoords : getSelectedPoints()) {
            xyArray[i] = getCoords;
            i++;
        }


        float a1 = (float)(xyArray[1].getY() - xyArray[0].getY()) / (xyArray[1].getX() - xyArray[0].getX());
        float b1 = xyArray[0].getY() - a1 * xyArray[0].getX();

        float a2= (float)(xyArray[2].getY() - xyArray[1].getY()) / (xyArray[2].getX() - xyArray[1].getX());
        float b2 = xyArray[1].getY() - a2 * xyArray[1].getX();

        float a3 = (float)(xyArray[0].getY() - xyArray[2].getY()) / (xyArray[0].getX() - xyArray[2].getX());
        float b3 = xyArray[2].getY() - a3 * xyArray[2].getX();

        boolean one = false;
        boolean two = false;
        boolean three = false;

        if (xyArray[2].getY() > a1 * xyArray[2].getX() + b1) {
            one = true;
        } else if (xyArray[2].getY() < a1 * xyArray[2].getX() + b1) {
            one = false;
        }

        if (xyArray[0].getY() > a2 * xyArray[0].getX() + b2) {
            two = true;
        } else if (xyArray[0].getY() < a2 * xyArray[0].getX() + b2) {
            two = false;
        }

        if (xyArray[1].getY() > a3 * xyArray[1].getX() + b3) {
            three = true;
        } else if (xyArray[1].getY() < a3 * xyArray[1].getX() + b3) {
            three = false;
        }

        if (one && two && three) {
            if (coordinate.getY() >= a1 * coordinate.getX() + b1 &&
                    coordinate.getY() >= a2 * coordinate.getX() + b2 &&
                    coordinate.getY() >= a3 * coordinate.getX() + b3) {
                return true;
            }
        } else if (one && two && !three) {
            if (coordinate.getY() >= a1 * coordinate.getX() + b1 &&
                    coordinate.getY() >= a2 * coordinate.getX() + b2 &&
                    coordinate.getY() <= a3 * coordinate.getX() + b3) {
                return true;
            }

        } else if (one && !two && three) {
            if (coordinate.getY() >= a1 * coordinate.getX() + b1 &&
                    coordinate.getY() <= a2 * coordinate.getX() + b2 &&
                    coordinate.getY() >= a3 * coordinate.getX() + b3) {
                return true;
            }

        } else if (!one && two && three) {
            if (coordinate.getY() <= a1 * coordinate.getX() + b1 &&
                    coordinate.getY() >= a2 * coordinate.getX() + b2 &&
                    coordinate.getY() >= a3 * coordinate.getX() + b3) {
                return true;
            }

        } else if (!one && !two && three) {
            if (coordinate.getY() <= a1 * coordinate.getX() + b1 &&
                    coordinate.getY() <= a2 * coordinate.getX() + b2 &&
                    coordinate.getY() >= a3 * coordinate.getX() + b3) {
                return true;
            }

        } else if (!one && two && !three) {
            if (coordinate.getY() <= a1 * coordinate.getX() + b1 &&
                    coordinate.getY() >= a2 * coordinate.getX() + b2 &&
                    coordinate.getY() <= a3 * coordinate.getX() + b3) {
                return true;
            }

        } else if (one && !two && !three) {
            if (coordinate.getY() >= a1 * coordinate.getX() + b1 &&
                    coordinate.getY() <= a2 * coordinate.getX() + b2 &&
                    coordinate.getY() <= a3 * coordinate.getX() + b3) {
                return true;
            }

        } else if (!one && !two && !three) {
            if (coordinate.getY() <= a1 * coordinate.getX() + b1 &&
                    coordinate.getY() <= a2 * coordinate.getX() + b2 &&
                    coordinate.getY() <= a3 * coordinate.getX() + b3) {
                return true;
            }

        }
        return false;
    }
}
