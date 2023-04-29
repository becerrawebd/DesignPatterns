package org.designpatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventManager {

    private HashMap<FileEventType, List<FileEventListener>> listeners;

    public EventManager(){
        this.listeners = new HashMap<>();
    }


    public void notify(FileEventData fed) {
        FileEventType eventType = fed.getFileEventType();
        for (FileEventListener fel: this.listeners.get(eventType)) {
            fel.update(fed);
        }
    }

    public void subscribe(FileEventType fileEventType, FileEventListener fileEventListener) {
        if(!this.listeners.containsKey(fileEventType)){
            this.listeners.put(fileEventType, new ArrayList<>());
        }
        this.listeners.get(fileEventType).add(fileEventListener);
    }
}
