package com.api.v1.autos.CarController;

import com.api.v1.autos.CarService.CarService;
import com.api.v1.autos.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/carros")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("")
    public String getAll(Model model){
        model.addAttribute("carros", carService.findAll());
        return "index";
    }
    @PostMapping("/agregar")
    public String insertCar(@ModelAttribute CarModel carModel){
        carService.newSave(carModel);
        return "redirect:/carros";
    }
    @GetMapping("/agregar")
    public String agragarCar(Model model){
        CarModel carModel= new CarModel();
        model.addAttribute("carModel", carModel);
        return "formAgregar";
    }
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable(name = "id") Long id, Model model){
        carService.delete(id);
        return "redirect:/carros";
    }
    @GetMapping("/editar/{id}")
    public String editCar(@PathVariable(name = "id") Long id, Model model){
        Optional<CarModel> carfind = carService.findById(id);
        if (carfind.isPresent()){
            CarModel carModel= carfind.get();
            model.addAttribute("carModel", carModel);
            return "formEdit";
        }
        return "redirect:/carros";
    }
    @PostMapping("/editar/{id}")
    public String carroEdit(@ModelAttribute CarModel carModel, @PathVariable(name = "id") Long id){
        carService.updateCar(carModel, id);
        return "redirect:/carros";
    }
}
