package org.designpatterns.subscribers;

import org.designpatterns.FileEventData;
import org.designpatterns.FileEventListener;

import java.io.*;

public class FileLoggingListener implements FileEventListener  {
    private final File file;

    public FileLoggingListener(String logFile){
        this.file = new File(logFile);
    }

    @Override
    public void update(FileEventData fileEventData) {
        try (OutputStream os = new FileOutputStream(this.file, true); PrintWriter printWriter = new PrintWriter(os);) {
            printWriter.println(fileEventData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
