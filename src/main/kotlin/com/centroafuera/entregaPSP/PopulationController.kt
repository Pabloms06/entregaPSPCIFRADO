package com.centroafuera.entregaPSP

import org.springframework.web.bind.annotation.*

@RestController
class PopulationController(private val PopulationRepository : PopulationRepository) {

    @GetMapping("/nation")
    fun getAllStudents() : List<Population> {
        return PopulationRepository.findAll()
    }

    @GetMapping("/nation/{id}")
    fun getStudent(@PathVariable id : Long) : Population {
        return PopulationRepository.findById(id).get()
    }
}