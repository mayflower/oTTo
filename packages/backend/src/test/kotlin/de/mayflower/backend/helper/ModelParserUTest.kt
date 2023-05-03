package de.mayflower.backend.helper

import de.mayflower.backend.entity.DayEntity
import de.mayflower.backend.entity.EventEntity
import de.mayflower.backend.impl.ClassNameTypeMatcher
import de.mayflower.backend.stubs.model.Day
import de.mayflower.backend.stubs.model.Room
import de.mayflower.backend.stubs.model.Session
import de.mayflower.backend.stubs.model.Timeslot
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.modelmapper.MappingException
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate

class ModelParserUTest {
    @Autowired
    var underTest: ModelParser = ModelParser(ModelMapper(), ClassNameTypeMatcher())

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
                        mutableSetOf(),
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
                            mutableSetOf(),
                            listOf("Max Mustermann", "Rainer Zufall"),
                            "This is our lunch-break do not disturb the gazelle, because the will flee."
                        )
                    )
                ),
                "Test description"
            )
        )
    )

    @Test
    fun test_parseDayToDayEntitySuccessful() {
        try {
            val result = underTest.parse<Day, DayEntity>(TEST_DAY);

            assertTrue(TEST_DAY.note == result.note)
        }
        catch (exception: MappingException) {
            //then
            fail(exception.message)
        }
    }

    @Test
    fun test_parseDayDtoToEventEntityUnsuccessful() {
        assertThrows(MappingException::class.java) {
            var test = underTest.parse<Day, EventEntity>(TEST_DAY)


            println(test)
        }
    }
}