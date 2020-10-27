package kz.edu.astanait.Sport;

public class Fifa implements Sport {
    private String name = "fifa-21";
    @Override
    public String name() {
        return name;
    }

    @Override
    public int id() {
        return 1;
    }

    @Override
    public int price() {
        return 30;
    }
}
