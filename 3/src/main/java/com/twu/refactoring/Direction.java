package com.twu.refactoring;


public class Direction {
    private final char direction;
    private static final String DIRECTION_SET = "NESW";

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turn(String turnDirection) {
        switch (turnDirection) {
            case "left":
                return new Direction(DIRECTION_SET.charAt((DIRECTION_SET.indexOf(direction) + 3) % 4));
            case "right":
                return new Direction(DIRECTION_SET.charAt((DIRECTION_SET.indexOf(direction) + 1) % 4));
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
