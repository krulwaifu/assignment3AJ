package kz.edu.astanait.Racing;


import kz.edu.astanait.AbstractFactory;

public class RacingFactory implements AbstractFactory<Racing> {
  /*AsettoCorsa asettoCorsa = new AsettoCorsa();
    NFS nfs = new NFS();
    ProjectCars projectCars = new ProjectCars();
    was test code
  */
    //Factory that creates object

    @Override
    public Racing create(String type) {
        if (type.equalsIgnoreCase("Assetto Corsa")){
            //return rio.construct();
            return new AsettoCorsa();
        }else if (type.equalsIgnoreCase("Need for Speed")){
            //return cerato.construct();
            return new NFS();
        }else if (type.equalsIgnoreCase("Project Cars 2")){
            //return sportage.construct();
            return new ProjectCars();
        }
        return null;
    }
}
