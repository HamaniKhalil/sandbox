import kotlinx.datetime.*
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.char
import java.sql.Time
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.Instant as JavaInstant

fun String.withMillisecondsLocalDateTime(): LocalDateTime =
    LocalDateTime.Format {
        year()
        char('-')
        monthNumber()
        char('-')
        dayOfMonth()
        char('T')
        hour()
        char(':')
        minute()
        char(':')
        second()
        char('.')
        secondFraction()
        char('Z')
    }
        .parse(this)


fun LocalDateTime.asOffsetDateTime(): String =
    "${this}${TimeZone.currentSystemDefault().offsetAt(Clock.System.now())}"


fun main() {
    val aNow = Clock.System.now()
    val aTimeZone = TimeZone.currentSystemDefault()
    println(
        aNow.toLocalDateTime(aTimeZone).asOffsetDateTime()
    )

    val asString = "2024-08-01T22:26:16+02:00"
//    val asStringMillis = "2024-08-01T22:26:16.936Z"
    val asStringMillis = "2024-08-12T14:16:18.983084000Z"

    val dateTimeComponents = DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET
        .parse(asString)

    val dateTime = dateTimeComponents.toLocalDateTime()

    println(dateTime)
    println(dateTime.format(LocalDateTime.Formats.ISO))

    val now = Clock.System.now()

    println(
        "$dateTime.${dateTime.nanosecond}${TimeZone.currentSystemDefault().offsetAt(now)}"
    )

    println(asStringMillis.withMillisecondsLocalDateTime())

    val asShortString = "2024-07-01"
    println(LocalDate.Formats.ISO.parse(asShortString))

    println(LocalDateTime(0, 1, 1, 0, 0, 0))

    val epochs = dateTime.date.toEpochDays().toLong()
    println(epochs)
    println(
        OffsetDateTime.of(
            dateTime.toJavaLocalDateTime(),
            ZoneOffset.systemDefault().rules.getOffset(JavaInstant.now())
        )
    )
}