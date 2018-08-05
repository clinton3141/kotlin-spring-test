package uk.co.slightlymore.themepark

data class ThemeParkDto(val name: String) {
    companion object {
        fun from(park: ThemePark): ThemeParkDto {
            return ThemeParkDto(park.name)
        }
    }
}