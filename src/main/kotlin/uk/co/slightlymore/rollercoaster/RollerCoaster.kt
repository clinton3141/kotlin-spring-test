package uk.co.slightlymore.rollercoaster

import uk.co.slightlymore.themepark.ThemePark
import uk.co.slightlymore.themepark.ThemeParkDto

class RollerCoaster(val name: String, val park: ThemePark, val category: Category) {
    enum class Category {
        Floorless,
        Inverted,
        SitDown,
        StandUp
    }

    fun toDto(): RollerCoasterDto = RollerCoasterDto.from(this)
}

data class RollerCoasterDto(val name: String, val park: ThemeParkDto, val category: RollerCoaster.Category) {
    companion object {
        fun from(rollerCoaster: RollerCoaster): RollerCoasterDto {
            return RollerCoasterDto(rollerCoaster.name, ThemeParkDto.from(rollerCoaster.park), rollerCoaster.category)
        }
    }
}
