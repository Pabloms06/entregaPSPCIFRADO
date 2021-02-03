package com.centroafuera.entregaPSP

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity

class Population (var Nation : String,var IDYear : Int,var Year : String,var Population : Int,var SlugNation : String) {

    @Id
    @GeneratedValue
    private val id: Long? = null

    override fun equals(other: Any?): Boolean {
        if (other is Population){
            return other.id == id && id != null
        } else {
            return false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(id, Nation, IDYear, Year, Population, SlugNation)
    }

    override fun toString(): String {
        return "$id es el id de $Nation y el id de la nacion es: $IDYear"
    }
}