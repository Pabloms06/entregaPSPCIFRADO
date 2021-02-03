package com.centroafuera.entregaPSP

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration

class LoadDatabase {

    companion object {
        val logger = LoggerFactory.getLogger(LoadDatabase.javaClass)
    }

    @Bean
    fun initDatabase(PopulationRepository : PopulationRepository) : CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            var a = Population("United States",2016,"2016",323127515,"united-states")
            var b = Population("United States",2015,"2015",321418821,"united-states")
            var c = Population("United States",2014,"2014",318857056,"united-states")
            var d = Population("United States",2013,"2013",316128839,"united-states")

            logger.info("Identificador " + PopulationRepository.save(a))
            logger.info("Identificador " + PopulationRepository.save(b))
            logger.info("Identificador " + PopulationRepository.save(c))
            logger.info("Identificador " + PopulationRepository.save(d))
        }

    }

}