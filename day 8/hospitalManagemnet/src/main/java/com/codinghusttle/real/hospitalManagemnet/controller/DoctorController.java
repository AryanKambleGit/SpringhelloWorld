package com.codinghusttle.real.hospitalManagemnet.controller;

import com.codinghusttle.real.hospitalManagemnet.Dto.DoctorDto;
import com.codinghusttle.real.hospitalManagemnet.Service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/id/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorByid(id));
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getStudent() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/speciality/{speciality}")
    public ResponseEntity<List<DoctorDto>> getDoctorsBySpeciality(@PathVariable String speciality) {
        return ResponseEntity.ok(doctorService.getDoctorBySpeciality(speciality));
    }



    @GetMapping("/name/{name}")
    public ResponseEntity<List<DoctorDto>> getDoctorByName(@PathVariable String name) {
        return ResponseEntity.ok(doctorService.getDoctorByName(name));
    }


    @GetMapping("/webPage")
    public String getDoctors() {
        return "homepage";  // Spring will look for homepage.html in templates folder
    }



//    @PostMapping
//    public ResponseEntity<DoctorDto> addDoctor(@RequestBody AddNewDoctor addNewDoctor){
//        return ResponseEntity.
//    }

}
