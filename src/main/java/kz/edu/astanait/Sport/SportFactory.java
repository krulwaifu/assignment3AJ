package kz.edu.astanait.Sport;


import kz.edu.astanait.AbstractFactory;

public class SportFactory implements AbstractFactory<Sport> {
//Factory that creates object
    @Override
    public Sport create(String type) {
        if (type.equalsIgnoreCase("NFL")){
            return new NFL();
        } else if (type.equalsIgnoreCase("Fifa")){
            return new Fifa();
        } else if (type.equalsIgnoreCase("NBA")){
            return new NBA();
        }
        return null;
    }
}
