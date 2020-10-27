package kz.edu.astanait.RPG;


import kz.edu.astanait.AbstractFactory;

public class RPGFactory implements AbstractFactory<RPG> {
    /* was test code
    Skyline skyline = new Skyline();
    Silvia silvia = new Silvia();
    Sx sx = new Sx();
    */
    //Factory that creates object
    @Override
    public RPG create(String type) {
        if (type.equalsIgnoreCase("Witcher")){
            //return silvia.construct();
            return new Witcher();
        }else if (type.equalsIgnoreCase("Cyberpunk")){
            //return skyline.construct();
            return new Cyberpunk();
        }else if (type.equalsIgnoreCase("Dark Souls")){
            //return sx.construct();
            return new DarkSouls();
        }
        return null;
    }
}
