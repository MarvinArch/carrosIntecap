package com.api.v1.autos.CarService;

import com.api.v1.autos.DAO.InterfaceCarDAO;
import com.api.v1.autos.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private InterfaceCarDAO interfaceCarDAO;

    public List<CarModel> findAll(){
        return (List<CarModel>) interfaceCarDAO.findAll();
    }

    public void delete(Long id){
        Optional<CarModel> buscar= interfaceCarDAO.findById(id);
        if (buscar.isPresent()){
            interfaceCarDAO.delete(buscar.get());
        }
    }

    public CarModel newSave(CarModel carModel){
        return interfaceCarDAO.save(carModel);
    }

    public Optional<CarModel> findById(Long id){
        return interfaceCarDAO.findById(id);
    }

    public void updateCar(CarModel carModel, Long id){
        Optional<CarModel> carfind= interfaceCarDAO.findById(id);
        if (carfind.isPresent()){
            CarModel carPresent= carfind.get();
            carPresent.setMarca(carModel.getMarca());
            carPresent.setModelo(carModel.getModelo());
            carPresent.setPrecio(carModel.getPrecio());
            interfaceCarDAO.save(carPresent);
        }
    }
}
