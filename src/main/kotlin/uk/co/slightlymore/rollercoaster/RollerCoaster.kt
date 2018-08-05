package uk.co.slightlymore.rollercoaster

import uk.co.slightlymore.themepark.ThemePark

data class RollerCoaster(val name: String, val park: ThemePark, val category: Category) {
    enum class Category {
        Floorless,
        Inverted,
        SitDown,
        StandUp
    }
}