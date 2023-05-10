package ch.m1m.edoc.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class StoreFSUtilsTest {

    StoreFSUtils storeFSUtils = new StoreFSUtils();

    @Test
    public void generate_valid_path_for_a_document() {
        // GIVEN
        //
        UUID uuid = UUID.fromString("d3e50b88-d5e6-477b-909f-11add1de03e1");
        LocalDate createDate = LocalDate.of(2022, 12, 31);

        // WHEN
        //
        String result = storeFSUtils.generatePath_v1(createDate, uuid);

        // THEN
        //
        assertEquals("2022/12/31/d3e50b88-d5e6-477b-909f-11add1de03e1", result);
    }
}