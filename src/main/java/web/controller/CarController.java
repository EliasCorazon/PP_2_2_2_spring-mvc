package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {
    private final CarServiceImp carServiceImp;
    private final List<Car> cars = Arrays.asList(new Car("model1", "color1", 1),
            new Car("model2", "color2", 2), new Car("model3", "color3", 3),
            new Car("model4", "color4", 4), new Car("model5", "color5", 5));

    @Autowired
    public CarController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping(value = "/cars")
    public String tableCar(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        model.addAttribute("cars", carServiceImp.returnTheNumberOfCars(cars, count));
        return "cars";
    }

}
