package ifsp.projeto.poo.model.database;

//Factory para que tenha a possibilidade de conecatr tanto no Mysql quanto Postgre
//Dependendo do banco escolhido

public class DataBaseFactory {
    public static Database getDatabase(String nome){
        if(nome.equals("postgresql")){
            return new DataBasePostgreSQL();
        }else if(nome.equals("mysql")){
            return new DataBaseMysql();
        }
        return null;
    }
}