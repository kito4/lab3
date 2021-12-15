import enums.Mood;
import classes.*;

import java.lang.Character;

public class Story {
    public static void main(String[] args) {
        Thing bell = new Thing("колокольчик");
        Thing lace = new Thing("шнурок");
        Thing announcement= new Thing("объявление");
        Background home = new Background("Дом");
        Background outside = new Background("улица");
        Background forest = new Background("Лес");
        Character1 Fluff = new Character1("Пух", home, Mood.NORMAL,true);
        Character1 Owl = new Character1("Сова", home, Mood.NORMAL,true);
        Character1 Ia = new Character1("Иа",forest,Mood.SAD,false);
        Dialog.AskaboutSomething(Fluff, Owl, false);
        Dialog.AskaboutSomething(Fluff, Owl, true);
        Fluff.changeLocation(outside);
        Owl.changeLocation(outside);
        Fluff.look(bell);
        Fluff.look(announcement);
        Fluff.look(lace);
        Fluff.take(lace);
        Fluff.changeLocation(forest);
        Fluff.give(lace,Ia);
        Ia.setTale(true);
        Ia.setMood(Mood.HAPPY);
        Fluff.setMood(Mood.HAPPY);

    }
}
