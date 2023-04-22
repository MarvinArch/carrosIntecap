package com.api.v1.autos.DAO;

import com.api.v1.autos.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceCarDAO extends JpaRepository<CarModel, Long> {
}
