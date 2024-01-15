import java.sql.*;
public class App {
    public static void main(String[] args)  {
        System.out.println("Conectando ao Banco de Dados...");
       
        conectar();
    } 
    public static Connection conectar(){
    String status = "Nada acontece ainda...";
    String mysqlHost = "127.0.0.1";
    String mysqlUser = "root";
    String mysqlDB = "mysql_connector";
    String mysqlPassword = "123456";
    String mysqlUrl = "jdbc:mysql://" + mysqlHost + "/" + mysqlDB + "?user=" + mysqlUser + "&password=" + mysqlPassword;
    
        Connection conn = null;
    
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(mysqlUrl);
        status = "Conexão realizada com sucesso! ";
    } catch (SQLException | InstantiationException | IllegalStateException | ClassNotFoundException | IllegalAccessException e){
        status = "Ops! Algo de errado não está certo com  a conexão com o banco de daso MySQL! mensagem do servidor" + e;
    }

    System.out.println(status);
    return conn;
    }       
}
