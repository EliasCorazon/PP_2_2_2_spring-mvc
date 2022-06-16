package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService{
    @Override
    public List<Car> returnTheNumberOfCars(List<Car> carList, Integer carNum) {
        if (carNum == null) {
            return carList;
        } else {
            return carList.stream().limit(carNum).collect(Collectors.toList());
        }
    }
}
