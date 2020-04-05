package org.grasswort.xstream.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuliangliang
 * @Classname Student.java
 * @Description
 * @Date 2020/4/5
 * @blame Java Team
 */
@Data
public class Student {

    private String name;

    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    @Data
    public static class Note {

        private String title;

        private String description;

    }
}
