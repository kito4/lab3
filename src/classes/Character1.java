package classes;

import abstractions.Location;
import enums.Mood;
import interfaces.HasMood;
import interfaces.Mobile;

import java.util.ArrayList;
import java.util.Objects;

public class Character1 implements HasMood, Mobile {
    private final String name;
    private Location location;
    private Mood moodState;
    private ArrayList<String> list=new ArrayList<>();
    private Boolean tale;

    public Character1(String name, Location location, Mood moodState,Boolean tale) {
        this.name = name;
        this.location = location;
        this.moodState = moodState;
    }

    public String getName() {
        return name;
    }

    public void changeLocation(Background str1) {
        location.name = str1.name;
        System.out.println(name + " переместился на " + location.name);
    }

    @Override
    public String getLocation() {
        return location.name;
    }

    @Override
    public String getMood() {
        return moodState.getRepresentation();
    }

    @Override
    public void setMood(Mood newMood) {
        moodState = newMood;
        System.out.println("У " + name + " теперь " + getMood() + " настроение");
    }

    public void look(Thing thing) {
        System.out.println(name + " смотрит на " + thing.name);
    }
    public void take(Thing thing){
        list.add(thing.name);
        System.out.println(name+" взял "+thing.name);
    }
    public void give(Thing thing,Character1 ch1){
        list.remove(thing.name);
        System.out.println(name+" отдал "+thing.name+" "+ch1.getName());
    }

    public void setTale(Boolean tale) {
        this.tale = tale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character1 that = (Character1) o;
        return Objects.equals(name, that.name) && Objects.equals(location, that.location) && moodState == that.moodState && Objects.equals(list, that.list) && Objects.equals(tale, that.tale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, moodState, list, tale);
    }
}
