package ch.m1m.edoc;

import java.time.LocalDate;
import java.util.UUID;

public class DocData {

    private UUID uuid;
    private LocalDate entryDate;

    private String fileExtension;

    private String path;

    private byte[] content;

    public UUID getUuid() { return uuid; }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
