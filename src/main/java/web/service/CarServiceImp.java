package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService{

    private final List<Car> cars = Arrays.asList(new Car("model1", "color1", 1),
            new Car("model2", "color2", 2), new Car("model3", "color3", 3),
            new Car("model4", "color4", 4), new Car("model5", "color5", 5));
    @Override
    public List<Car> returnTheNumberOfCars( Integer carNum) {
        if (carNum == null) {
            return cars;
        } else {
            return cars.stream().limit(carNum).collect(Collectors.toList());
        }
    }
}
