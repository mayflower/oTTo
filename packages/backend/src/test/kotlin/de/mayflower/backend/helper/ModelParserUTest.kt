package de.mayflower.backend.helper

import de.mayflower.backend.entity.DayEntity
import de.mayflower.backend.entity.EventEntity
import de.mayflower.backend.stubs.model.Day
import de.mayflower.backend.stubs.model.Room
import de.mayflower.backend.stubs.model.Session
import de.mayflower.backend.stubs.model.Timeslot
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.modelmapper.MappingException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.util.*

//@SpringBootTest
class ModelParserUTest {
    @Autowired
    lateinit var underTest: ModelParser

    private val TEST_DAY = Day(
        "01GYF7GERCYTZD1JDNX7S01ZZC",
        LocalDate.of(2023, 5, 2),
        "This is a note for the day",
        listOf(
            Room(
                "01GYF7GERCYTZD1JDNX7S01ZZC",
                "Nice Room",
                listOf(Timeslot(
                    "JIMQP7GERCYTZD1JDNX7S0ONEP",
                    "1683007200",
                    "1683021600",
                    true,
                    true,
                    Session(
                        "KMQP7GERCYTZD1JDNX7S0012H",
                        "Lunch",
                        Collections.emptyList(),
                        listOf("Max Mustermann", "Rainer Zufall"),
                        "This is our lunch-break do not disturb the gazelle, because the will flee."
                    )),
                    Timeslot(
                        "01GYF7GERCYTZD1JDNX7S01ZZI",
                        "1683093600",
                        "1683108000",
                        true,
                        true,
                        Session(
                            "IJ61F7GERCYTZD1JDNX7S0KQPV",
                            "Lunch",
                            Collections.emptyList(),
                            listOf("Max Mustermann", "Rainer Zufall"),
                            "This is our lunch-break do not disturb the gazelle, because the will flee."
                        )
                    )
                )
            )
        )
    )

    @Test
    fun test_parseDayToDayEntitySuccessful() {
        //given
        //the test day

        try {
            //when
            val result = underTest.parse<Day, DayEntity>(TEST_DAY);

            //then
            assertTrue(TEST_DAY.id == result.id)
        }
        catch (exception: MappingException) {
            //then
            fail(exception.message)
        }
    }

    @Test
    fun test_parseDayDtoToEventEntityUnsuccessful() {
        //given
        //the test day

        //when then
        assertThrows(MappingException::class.java) {
            underTest.parse<Day, EventEntity>(TEST_DAY)
        }
    }
}