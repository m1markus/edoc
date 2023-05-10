package ch.m1m.edoc.utils;

import java.time.LocalDate;
import java.util.UUID;

public class StoreFSUtils {

    /* return a path in the following format
     *    2022/01/31/d3e50b88-d5e6-477b-909f-11add1de03e1
     *    Year
     *         Month
     *            Day
     *               UUID
     */
    public String generatePath_v1(LocalDate createDate, UUID uuid) {
        //String uuidFirstTwoChars = uuid.toString().substring(0, 2);
        return String.format("%04d/%02d/%02d/%s",
                createDate.getYear(),
                createDate.getMonthValue(),
                createDate.getDayOfMonth(),
                uuid);
    }

    public String generatePath_v1(LocalDate createDate, UUID uuid, String fileExtension) {
        return String.format("%04d/%02d/%02d/%s.%s",
                createDate.getYear(),
                createDate.getMonthValue(),
                createDate.getDayOfMonth(),
                uuid,
                fileExtension);
    }
}
