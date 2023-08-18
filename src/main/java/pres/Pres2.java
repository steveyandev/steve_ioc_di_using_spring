package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException
        Scanner scanner=new Scanner(new File("config.txt"));
        String daoClassName= scanner.nextLine();
        //forname() prend un nom de class verifie si elle existe et la charge en memoire
        Class cDao=Class.forName(daoClassName);
        //Object dao=cDao.newInstance(); on n connais pas la version utiliser mais on connais l'interface donc
        IDao dao=(IDao) cDao.newInstance();

        //System.out.println(dao.getData());

        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.newInstance();

        Method method=cMetier.getMethod("setDao",IDao.class);
        //metier.setDao(dao) invoker la methode setDao de metier avec parametre dao
        method.invoke(metier,dao);

        System.out.println("Resultat=>"+metier.calcul());
    }
}
