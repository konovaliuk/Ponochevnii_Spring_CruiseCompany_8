package ua.study.poject.cruise.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Util class to convert LocalDateTime to Timestamp and vice versa
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    /**
     * Converts from LocalDateTime to Timestamp
     *
     * @param locDateTime
     * @return Timestamp
     */
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
        return locDateTime == null ? null : Timestamp.valueOf(locDateTime);
    }

    /**
     * Converts from Timestamp to LocalDateTime
     *
     * @param sqlTimestamp
     * @return LocalDateTime
     */
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime();
    }
}