package classes;


import java.util.Objects;

public class Dialog {
    boolean lasttime;
    public static void AskaboutSomething(Character1 ch1, Character1 ch2, boolean lasttime) {
        if (lasttime == true) {
            System.out.println(ch2.getName() + " спросила." + ch1.getName() + " ответил Нет,нет,никогда");
        } else {
            System.out.println(ch2.getName() + " спросила." + ch1.getName() + " сказал да,да!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dialog dialog = (Dialog) o;
        return lasttime == dialog.lasttime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lasttime);
    }

}
