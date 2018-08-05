package uk.co.slightlymore.themepark

import org.springframework.stereotype.Service

import uk.co.slightlymore.rollercoaster.RollerCoasterRepository


@Service
class ThemeParkRepository(private val rollerCoasterRepository: RollerCoasterRepository) {
    fun getAll(): List<ThemePark> = rollerCoasterRepository
        .coasters
        .values
        .map{ it.park }
        .distinctBy { it.name }
}