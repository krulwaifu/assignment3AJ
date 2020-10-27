package kz.edu.astanait;


import kz.edu.astanait.RPG.RPGFactory;
import kz.edu.astanait.Racing.RacingFactory;
import kz.edu.astanait.Sport.SportFactory;

//Abstract factory provider to create factory of objects
public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("Racing")){
            return new RacingFactory();
        }else if (choice.equalsIgnoreCase("RPG")){
            return new RPGFactory();
        }
        else if (choice.equalsIgnoreCase("Sport")){
            return new SportFactory();
        }
        return null;
    }
}
