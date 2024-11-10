package guru.springframework.spring5webapp.designpattern.project.elevator;

public class ElevatorCar {
    int id;
    ElevatorDisplay elevatorDisplay;
    int currentFloor;
    Direction direction;
    ElevatorState elevatorState;
    InternalButton internalButton;
    ElevatorDoor elevatorDoor;

    public ElevatorCar() {
        elevatorDisplay=new ElevatorDisplay();
        currentFloor=0;
        direction= Direction.UP;
        elevatorDoor=new ElevatorDoor();
        internalButton=new InternalButton();
    }

    public void display(){
        elevatorDisplay.showDisplay();
    }


}
