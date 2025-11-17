package com.monEntreprise.meubles.controllers;

import com.monEntreprise.meubles.entities.Furniture;
import com.monEntreprise.meubles.services.FurnitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/furnitures")
public class FurnitureController {
    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService){
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public ResponseEntity<List<Furniture>> getAllFurnitures(){
        return new ResponseEntity<>(furnitureService.getAllFurnitures(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Furniture> getFurnitureById(@PathVariable Long id){
        Optional<Furniture> furniture = furnitureService.getFurnitureById(id);

        if (furniture.isPresent()){
            return new ResponseEntity<>(furniture.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Furniture> createFurniture(@RequestBody Furniture furniture){
        Furniture furnitureCreated = furnitureService.createFurniture(furniture);
        return new ResponseEntity<>(furnitureCreated, HttpStatus.CREATED);
    }

    @PutMapping("/id")
    public ResponseEntity<Furniture> updateFurniture(@PathVariable Long id, @RequestBody Furniture furnitureDetails){
        Optional<Furniture> furniture = furnitureService.updateFurniture(id, furnitureDetails);

        if (furniture.isPresent()){
            return new ResponseEntity<>(furniture.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteFurniture(@PathVariable Long id){
        Optional<Furniture> deletedFurniture = furnitureService.deleteFurniture(id);

        if (deletedFurniture.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
