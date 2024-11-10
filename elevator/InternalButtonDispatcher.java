package guru.springframework.spring5webapp.designpattern.project.elevator;

import java.util.List;

public class InternalButtonDispatcher {
        List<ElevatorController> elevatorControllerList= ElevatorCreator.elevatorControllerList;
        public void submitInternalRequest(int floor, ElevatorCar elevatorCar){
           // which elevator will go to which floor
        }
}
