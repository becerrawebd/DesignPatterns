package org.designpatterns;

import org.designpatterns.subscribers.FileLoggingListener;
import org.designpatterns.subscribers.StdOutLoggingListener;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        StdOutLoggingListener stdOutLoggingListener = new StdOutLoggingListener();
        FileLoggingListener fileLoggingListener = new FileLoggingListener("observer/logs.txt");
        editor.getEventManager().subscribe(FileEventType.OPEN, stdOutLoggingListener);
        editor.getEventManager().subscribe(FileEventType.WRITE, stdOutLoggingListener);
        editor.getEventManager().subscribe(FileEventType.OPEN, fileLoggingListener);
        editor.getEventManager().subscribe(FileEventType.DELETE, fileLoggingListener);
        editor.openFile("observer/file.txt");
        try {
            editor.writeFile("Hello World");
            editor.deleteFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}