package guru.springframework.spring5webapp.designpattern.project.elevator;

public class InternalButton {

    InternalButtonDispatcher internalButtonDispatcher=new InternalButtonDispatcher();

    int [] availableButtons={1,2,3,4,5,6,7,8,9};
    int buttonSelected;

    void pressButton(int destination, ElevatorCar elevatorCar){
        //check if the destination is in list of available floors;
        // then submit the request
        internalButtonDispatcher.submitInternalRequest(destination,elevatorCar);
    }
}
