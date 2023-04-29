package org.designpatterns;


import java.io.*;
import java.time.LocalDateTime;

public class Editor {
    private File file;
    private EventManager eventManager;

    public Editor(){
        this.eventManager = new EventManager();
    }

    private static FileEventData newEventData(FileEventType fileEventType, String filename){
        return new FileEventData(LocalDateTime.now(),fileEventType,filename);
    }

    public void openFile(String filename) {
        this.file = new File(filename);
        FileEventData fed = Editor.newEventData(FileEventType.OPEN,this.file.getName());
        this.eventManager.notify(fed);
    }

    public EventManager getEventManager() {
        return this.eventManager;
    }

    public void writeFile(String text) throws IOException {
        try (OutputStream os = new FileOutputStream(this.file, true); PrintWriter printWriter = new PrintWriter(os);) {
            printWriter.println(text);
        }
        FileEventData fed = Editor.newEventData(FileEventType.WRITE,this.file.getName());
        this.eventManager.notify(fed);
    }

    public void deleteFile() {
        String filename = this.file.getName();
        if(this.file.delete()){
            FileEventData fed = Editor.newEventData(FileEventType.DELETE,filename);
            this.eventManager.notify(fed);
        }
    }
}
