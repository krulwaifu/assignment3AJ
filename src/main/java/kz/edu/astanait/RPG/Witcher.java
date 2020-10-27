package kz.edu.astanait.RPG;

public class Witcher implements RPG {
    @Override
    public String name() {
        return "the Witcher 3";
    }

    @Override
    public int price() {
        return 30;
    }
}
