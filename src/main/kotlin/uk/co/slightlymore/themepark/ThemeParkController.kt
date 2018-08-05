package uk.co.slightlymore.themepark

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/themepark")
class ThemeParkController(private val repository: ThemeParkRepository) {
    @GetMapping("")
    fun getAll(): List<ThemeParkDto> {
        return repository.getAll().map { it.toDto() }
    }
}