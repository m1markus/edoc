package ch.m1m.edoc;

import ch.m1m.edoc.utils.StoreFSUtils;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DocStoreFSTest {

    private static final String STRING_DEADBEEF = "deadbeef";

    private static DocStoreFS docFS;
    private static DocData docData;

    @BeforeAll
    public static void init() throws IOException {
        docData = createTestDocument();
        docFS = new DocStoreFS("target/test/data");
    }

    @Test
    @Order(1)
    public void test_create() throws IOException {
        // GIVEN
        // WHEN
        docFS.create(docData.getPath(), docData.getContent());

        // THEN
        assertTrue(docFS.pathExists(docData.getPath()));
    }

    @Test
    @Order(2)
    public void test_getBytes() throws IOException {
        // GIVEN
        // WHEN
        byte[] allBytes = docFS.getBytes(docData.getPath());

        // THEN
        assertEquals(STRING_DEADBEEF, new String(allBytes));
    }

    @Test
    @Order(3)
    public void test_delete() throws IOException {
        // GIVEN
        // WHEN
        docFS.delete(docData.getPath());

        // THEN
        assertFalse(docFS.pathExists(docData.getPath()));
    }

    private static DocData createTestDocument() {
        DocData docData = new DocData();
        docData.setUuid(UUID.randomUUID());
        docData.setEntryDate(LocalDate.of(2022, 12, 31));

        byte[] bytes = STRING_DEADBEEF.getBytes(StandardCharsets.UTF_8);
        docData.setContent(bytes);
        docData.setFileExtension("txt");

        String path = new StoreFSUtils().generatePath_v1(docData.getEntryDate(),
                docData.getUuid(), docData.getFileExtension());
        docData.setPath(path);

        return docData;
    }
}