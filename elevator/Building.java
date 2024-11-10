package guru.springframework.spring5webapp.designpattern.project.elevator;

import java.util.List;

public class Building {

    List<Floor> floorList;

    Building(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public void addFloors(Floor newFloor) {
        floorList.add(newFloor);
    }

    public void removeFloor(Floor removeFloor) {
        floorList.remove(removeFloor);
    }

    List<Floor> getAllFloorList() {
        return floorList;
    }
}
