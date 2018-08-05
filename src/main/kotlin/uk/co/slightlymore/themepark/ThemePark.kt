package uk.co.slightlymore.themepark

class ThemePark(val name: String) {
    fun toDto(): ThemeParkDto = ThemeParkDto.from(this)
}

data class ThemeParkDto(val name: String) {
    companion object {
        fun from(park: ThemePark): ThemeParkDto {
            return ThemeParkDto(park.name)
        }
    }
}