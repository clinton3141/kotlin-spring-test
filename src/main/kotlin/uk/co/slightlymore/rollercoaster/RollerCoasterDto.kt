package uk.co.slightlymore.rollercoaster

import uk.co.slightlymore.themepark.ThemeParkDto

data class RollerCoasterDto(val name: String, val park: ThemeParkDto, val category: RollerCoaster.Category) {
    companion object {
        fun from(rollerCoaster: RollerCoaster): RollerCoasterDto {
            return RollerCoasterDto(rollerCoaster.name, ThemeParkDto.from(rollerCoaster.park), rollerCoaster.category)
        }
    }
}
