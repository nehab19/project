package guru.springframework.spring5webapp.designpattern.project.elevator;

public class ElevatorDisplay {
    int floor;
    Direction direction;

    public void setDisplay(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public void showDisplay() {
        System.out.println(direction);
        System.out.println(floor);
    }
}
