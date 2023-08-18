package dao;

public class DaoImpl implements IDao{

    @Override
    public double getData() {

        //connect to database to get data
        //here we just use a attribute as example for data
        System.out.println("version base de données");
        double temp=Math.random()*40;
        return temp;
    }
}
