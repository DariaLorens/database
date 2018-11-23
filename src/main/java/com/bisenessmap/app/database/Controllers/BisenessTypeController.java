package com.bisenessmap.app.database.Controllers;

import com.bisenessmap.app.database.Repositories.BisenessTypeRepository;
import com.bisenessmap.app.database.entity.BisenessType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
public class BisenessTypeController {
    private BisenessTypeRepository bisenessTypeRepository;

    public BisenessTypeController(BisenessTypeRepository bisenessTypeRepository) {
        this.bisenessTypeRepository = bisenessTypeRepository;
    }

    @GetMapping("/all")
    public List<BisenessType> getAll(){
        List<BisenessType> bisenessTypes = this.bisenessTypeRepository.findAll();
        return bisenessTypes;
    }
}
