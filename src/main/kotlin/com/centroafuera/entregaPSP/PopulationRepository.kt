package com.centroafuera.entregaPSP

import org.springframework.data.jpa.repository.JpaRepository

interface PopulationRepository : JpaRepository<Population, Long>
