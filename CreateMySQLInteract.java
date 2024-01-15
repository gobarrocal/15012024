import java.sql.*;
import java.util.*;
public class CreateMySQLInteract{
    public static void main(String[] args) {

        String status = "Nada aconteceu ainda...";

        boolean sair = false;
        String str1 = "CREATE TABLE `mysql_connector`.`";
        String str2 = "` (`id` INT NOT NULL AUTO_INCREMENT, `";
        String str3 = "` VARCHAR(255) NULL, PRIMARY KEY (`id`));";
        Scanner scan = new Scanner(System.in);
        String strCreateTable;
        String strNomeTabela;
        String strNomeCampo;
        Connection conn = App.conectar();
        Statement stmSQL = null;
        String confirmarSaida;

        while (sair == false) {
            try {
                System.out.print("Digite o nome da Tabela >> ");
                strNomeTabela = scan.nextLine();

                System.out.print("Digite o nome do campo >> ");
                strNomeCampo = scan.nextLine();

        

                strCreateTable = str1 + strNomeTabela + str2 + strNomeCampo + str3;
                stmSQL = conn.createStatement();
                stmSQL.addBatch(strCreateTable);
                stmSQL.executeBatch();
                stmSQL.close();
                status = "Tabela(s) criada(s) com sucesso";

                System.out.println("Deseja criar outra tabela? Digite [c] para continuar ou [s] para sair.");
                confirmarSaida = scan.nextLine();
                if (confirmarSaida.equals("s") || confirmarSaida.equals("S")) {
                    sair = true;
                }
            } catch (Exception e) {
                System.err.println("Ops! Algo de errado não está certo." + e);
            }
        }
        scan.close();
        System.out.println(status);
    }
}