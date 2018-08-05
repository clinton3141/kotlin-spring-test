import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

import uk.co.slightlymore.KotlinSpringApplication
import uk.co.slightlymore.rollercoaster.RollerCoaster
import uk.co.slightlymore.rollercoaster.RollerCoasterDto
import uk.co.slightlymore.themepark.ThemeParkDto

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(KotlinSpringApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RollerCoasterControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `all rollercoasters`() {
        val result = testRestTemplate
                .getForEntity("/rollercoaster", Array<RollerCoasterDto>::class.java)

        val expected = arrayOf(
                RollerCoasterDto("Nemesis", ThemeParkDto("Alton Towers"), RollerCoaster.Category.Inverted),
                RollerCoasterDto("Dragon Khan", ThemeParkDto("PortAventura Park"), RollerCoaster.Category.SitDown),
                RollerCoasterDto("Oblivion", ThemeParkDto("Alton Towers"), RollerCoaster.Category.SitDown),
                RollerCoasterDto("Rougarou", ThemeParkDto("Cedar Point"), RollerCoaster.Category.Floorless)
        )

        assertNotNull(result)
        assertEquals(result?.statusCode, HttpStatus.OK)
        assertArrayEquals(expected, result?.body)
    }

    @Test
    fun `single rollercoaster`() {
        val result = testRestTemplate
                .getForEntity("/rollercoaster/nemesis", RollerCoasterDto::class.java)

        val expected = RollerCoasterDto("Nemesis", ThemeParkDto("Alton Towers"), RollerCoaster.Category.Inverted)

        assertNotNull(result)
        assertEquals(result?.statusCode, HttpStatus.OK)
        assertEquals(expected, result?.body)
    }
}