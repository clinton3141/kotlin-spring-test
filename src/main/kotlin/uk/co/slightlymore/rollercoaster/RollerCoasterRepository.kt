package uk.co.slightlymore.rollercoaster

import org.springframework.stereotype.Service
import uk.co.slightlymore.themepark.ThemePark

@Service
class RollerCoasterRepository {
    val coasters: Map<String, RollerCoaster>
    init {
        coasters = hashMapOf(
            "dragon-khan" to RollerCoaster("Dragon Khan", ThemePark("PortAventura Park"), RollerCoaster.Category.SitDown),
            "nemesis" to RollerCoaster("Nemesis", ThemePark("Alton Towers"), RollerCoaster.Category.Inverted),
            "oblivion" to RollerCoaster("Oblivion", ThemePark("Alton Towers"), RollerCoaster.Category.SitDown),
            "rougarou" to RollerCoaster("Rougarou", ThemePark("Cedar Point"), RollerCoaster.Category.Floorless)
        )
    }
    fun getAll(): List<RollerCoaster> {
        return coasters.toList().map{ it.second }
    }
    fun find(name: String): RollerCoaster? {
        return coasters[name]
    }
}