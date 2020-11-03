package chimbeev.spring.project.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Document {
    private int id;
    private String name;
    private String sender;
    private final String date;
    private String imgRoute;

    public Document(int id, String name, String sender) {
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        this.date = simpleDateFormat.format(d);
        this.id = id;
        this.name = name;
        this.sender = sender;
    }

    public Document() {
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        this.date = simpleDateFormat.format(d);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Документ " + getName() + " ID " + getId() + " Отправитель " + getSender() + " Загружено " + getDate();
    }
}
