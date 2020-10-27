package kz.edu.astanait.Sport;

public class NFL implements Sport {
    private String name = "madden-nfl-20";
    @Override
    public String name() {
        return name;
    }

    @Override
    public int id() {
        return 2;
    }

    @Override
    public int price() {
        return 30;
    }
}
