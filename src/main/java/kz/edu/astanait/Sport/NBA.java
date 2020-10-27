package kz.edu.astanait.Sport;

public class NBA implements Sport {
    private String name = "nba 2k21";
    @Override
    public String name() {
        return name;
    }

    @Override
    public int id() {
        return 3;
    }

    @Override
    public int price() {
        return 40;
    }
}
