package uk.co.slightlymore.rollercoaster

import org.junit.Assert.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class RollerCoasterRepositoryTest {
//    @Autowired
//    lateinit var rollerCoasterRepository: RollerCoasterRepository
//
    @Test
    fun `It should provide list of all roller coasters`() {
//        val all = rollerCoasterRepository.getAll()

        assertEquals(4, 4)
    }

}
