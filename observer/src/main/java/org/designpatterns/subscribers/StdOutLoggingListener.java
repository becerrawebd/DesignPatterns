package org.designpatterns.subscribers;

import org.designpatterns.FileEventData;
import org.designpatterns.FileEventListener;

public class StdOutLoggingListener implements FileEventListener {

    @Override
    public void update(FileEventData fileEventData) {
        System.out.println(fileEventData);
    }
}
