package uk.co.slightlymore.rollercoaster

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import uk.co.slightlymore.themepark.ThemeParkDto

@ResponseStatus(HttpStatus.NOT_FOUND)
class RollerCoasterNotFoundException(name: String) : RuntimeException("RollerCoaster not found: $name")

@RestController
@RequestMapping("/rollercoaster")
class RollerCoasterController(private val repository: RollerCoasterRepository) {
    @GetMapping("")
    fun allRollercasters(): List<RollerCoasterDto> {
        return repository.getAll().map{ RollerCoasterDto.from(it) }
    }

    @GetMapping("/{name}")
    fun getRollerCoaster(@PathVariable name: String): RollerCoasterDto {
        val coaster = repository.find(name) ?: throw RollerCoasterNotFoundException(name)
        return RollerCoasterDto.from(coaster)
    }
}