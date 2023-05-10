package ch.m1m.edoc;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DocStoreFS {

    private static Logger log = LoggerFactory.getLogger(DocStoreFS.class);

    private final String dataDir;

    public DocStoreFS(String docStoreDir) throws IOException {
        // alternative to get current path
        // Path currentRelativePath = Paths.get("");
        // String cwd = currentRelativePath.toAbsolutePath().toString();
        String cwDir = System.getProperty("user.dir");
        log.info("current dir is: {}", cwDir);
        log.info("docStoreDir is: {}", docStoreDir);

        dataDir = cwDir + "/" + docStoreDir;
        log.info("setting document dataDir to: {}", dataDir);

        Files.createDirectories(Paths.get(dataDir));
    }

    public boolean pathExists(String filePath) {
        String fullPath = createFullPath((filePath));
        Path path = Paths.get(fullPath);
        return Files.exists(path);
    }

    public void create(String filePath, byte[] content) throws IOException {
        String fullPath = createFullPath((filePath));

        String dirPath = FilenameUtils.getFullPathNoEndSeparator(fullPath);
        Files.createDirectories(Paths.get(dirPath));

        Path path = Paths.get(fullPath);
        Files.write(path, content);
    }

    public byte[] getBytes(String filePath) throws IOException {
        String fullPath = createFullPath((filePath));

        Path path = Paths.get(fullPath);
        return Files.readAllBytes(path);
    }

    public void delete(String filePath) throws IOException {
        String fullPath = createFullPath((filePath));

        Path path = Paths.get(fullPath);
        Files.delete(path);
    }

    private String createFullPath(String filePath) {
        return dataDir + "/" + filePath;
    }
}
