package app.sunshine.com.example.android.fitnesseveryday;

/**
 * Created by Ahmed Hassan on 7/18/2017.
 */

public class Note {

    private String title;
    private String step;

    public Note() {
    }

    public Note(String title, String step) {
        this.title = title;
        this.step = step;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }


    }


