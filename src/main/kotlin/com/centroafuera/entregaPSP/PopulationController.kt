package com.centroafuera.entregaPSP

import org.springframework.web.bind.annotation.*
import java.security.MessageDigest
import java.util.*
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import kotlin.jvm.Throws




@RestController
class PopulationController(private val PopulationRepository : PopulationRepository) {

    @GetMapping("/nation")
    fun getPopulation() : List<Population> {
        return PopulationRepository.findAll()
    }

    @GetMapping("/nation/{id}")
    fun getPopulation(@PathVariable id: Long): Population{
        val encriptacion = id.toString()
        val tipodellave = "QWERTY"
        val descifrada = descifrar(cifrar(encriptacion,tipodellave),tipodellave)
        return PopulationRepository.findById(descifrada.toLong()).get()

    }

    private fun cifrar(texto: String, llave: String): String {
        println("Voy a cifrar $texto")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, getKey(llave))
        val textCifrado = Base64.getEncoder().encodeToString(cipher.doFinal(texto.toByteArray(Charsets.UTF_8)))
        println("He obtenido $textCifrado")
        return textCifrado
    }

    @Throws(BadPaddingException::class)
    private fun descifrar(textoCifrrado: String, llave: String): String {
        println("Voy a descifrar $textoCifrrado")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, getKey(llave));
        val textDescifrado = String(cipher.doFinal(Base64.getDecoder().decode(textoCifrrado)))
        println("He obtenido $textDescifrado")
        return textDescifrado
    }


    private fun getKey(llaveEnString: String): SecretKeySpec {
        var llaveUtf8 = llaveEnString.toByteArray(Charsets.UTF_8)
        val sha = MessageDigest.getInstance("SHA-1")
        llaveUtf8 = sha.digest(llaveUtf8)
        llaveUtf8 = llaveUtf8.copyOf(16)
        return SecretKeySpec(llaveUtf8, "AES")
    }

}
