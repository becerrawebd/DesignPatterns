package org.designpatterns;

import java.time.LocalDateTime;

public class FileEventData {
    private LocalDateTime fileEventTime;
    private FileEventType fileEventType;
    private String filename;

    public FileEventData(LocalDateTime fileEventTime, FileEventType fileEventType, String filename) {
        this.fileEventType = fileEventType;
        this.fileEventTime = fileEventTime;
        this.filename = filename;
    }

    public FileEventType getFileEventType() {
        return fileEventType;
    }

    public LocalDateTime getFileEventTime() {
        return fileEventTime;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return "FileEventData{" +
                "fileEventTime=" + fileEventTime +
                ", fileEventType=" + fileEventType +
                ", filename='" + filename + '\'' +
                '}';
    }
}
