package classes;

import abstractions.Location;
import interfaces.Reaction;
import enums.Mood;
import interfaces.HasMood;
import interfaces.Mobile;

import java.util.ArrayList;
import java.util.Objects;

public class Personage implements HasMood, Mobile, Reaction {
    ArrayList<Thing> favorite_things = new ArrayList<>();
    private final String name;
    private Location location;
    private Mood moodState;
    private ArrayList<Thing> list = new ArrayList<>();
    private Boolean tale;

    public Personage(String name, Location location, Mood moodState, Boolean tale) {
        this.name = name;
        this.location = location;
        this.moodState = moodState;
    }

    public void setFavorite_things(ArrayList<Thing> favorite_things) {
        this.favorite_things = favorite_things;
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

    public void take(Thing thing) {
        list.add(thing);
        System.out.println(name + " взял " + thing.name);
    }

    public void give(Thing thing, Personage receiver) {
        list.remove(thing);
        receiver.list.add(thing);
        System.out.println(name + " отдал " + thing.name + " " + receiver.getName());
        react_to_thing(thing, receiver);
    }

    public void setTale(Boolean tale) {
        this.tale = tale;
    }

    @Override
    public void react_to_thing(Thing thing, Personage persona) {
        if (persona.favorite_things.contains(thing)) {
            persona.setMood(Mood.HAPPY);
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personage that = (Personage) o;
        return Objects.equals(name, that.name) && Objects.equals(location, that.location) && moodState == that.moodState && Objects.equals(list, that.list) && Objects.equals(tale, that.tale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, moodState, list, tale);
    }


}
