import java.sql.*;
import java.util.Scanner;

public class MainApp
{
    private static final String URL = "jdbc:mysql://localhost:3306/lab8";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            while (running) {
                System.out.println("Meniu:");
                System.out.println("1. Adaugare persoana");
                System.out.println("2. Adaugare excursie");
                System.out.println("3. Afisare persoane si excursii");
                System.out.println("4. Iesire");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Introduceti numele persoanei:");
                        String nume = scanner.nextLine();
                        System.out.println("Introduceti varsta persoanei:");
                        int varsta = scanner.nextInt();
                        scanner.nextLine();

                        String insertPersoana = "INSERT INTO persoane (nume, varsta) VALUES (?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(insertPersoana)) {
                            pstmt.setString(1, nume);
                            pstmt.setInt(2, varsta);
                            pstmt.executeUpdate();
                            System.out.println("Persoana a fost adaugata cu succes!");
                        }
                        break;
                    case 2:
                        System.out.println("Introduceti ID-ul persoanei:");
                        int idPersoana = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Introduceti destinația excursiei:");
                        String destinatia = scanner.nextLine();
                        System.out.println("Introduceti anul excursiei:");
                        int anul = scanner.nextInt();
                        scanner.nextLine();

                        String insertExcursie = "INSERT INTO excursii (id_persoana, destinatia, anul) VALUES (?, ?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(insertExcursie)) {
                            pstmt.setInt(1, idPersoana);
                            pstmt.setString(2, destinatia);
                            pstmt.setInt(3, anul);
                            pstmt.executeUpdate();
                            System.out.println("Excursia a fost adaugată cu succes!");
                        }
                        break;
                    case 3:
                        String query = "SELECT p.nume, p.varsta, e.destinatia, e.anul FROM persoane p LEFT JOIN excursii e ON p.id = e.id_persoana";
                        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                            while (rs.next()) {
                                String nume1 = rs.getString("nume");
                                int varsta1 = rs.getInt("varsta");
                                String destinatia1 = rs.getString("destinatia");
                                int anul1 = rs.getInt("anul");

                                destinatia = (destinatia1 != null) ? destinatia1 : "Nicio excursie";
                                String anulText = (rs.wasNull()) ? "N/A" : String.valueOf(anul1);

                                System.out.println("Nume: " + nume1 + ", Varsta: " + varsta1 + ", Destinatia: " + destinatia + ", Anul: " + anulText);
                            }
                        }
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Optiune invalida!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
