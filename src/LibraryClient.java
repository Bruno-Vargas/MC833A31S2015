import java.rmi.*;
import java.rmi.registry.*;

public class LibraryClient {

    private LibraryClient() {}

    public static void main(String args[]) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost");
            RentalInterface stub  = (RentalInterface) reg.lookup("Rental");
            long start, end;

            CommandParser parser = new CommandParser();
            CommandWrapper cmd = parser.parseCommand(args);
            start = System.nanoTime();
            switch (cmd.command) {
                case LIST_ALL:
                System.out.println(stub.getAllMovies());
                break;
                case LIST_ALL_TITLES_AND_YEARS:
                System.out.println(stub.getAllNamesAndYears());
                break;
                case LIST_ALL_BY_GENRE:
                System.out.println(stub.getAllTitlesAndYearByGenre(cmd.identifier));
                break;
                case SYNOPISIS_BY_ID:
                System.out.println(stub.getSynopsisById(cmd.identifier));
                break;
                case INFO_BY_ID:
                System.out.println(stub.getInfoById(cmd.identifier));
                break;
                case QUANTITY_BY_ID:
                System.out.println(stub.getQuantityOfMovie(cmd.identifier));
                break;
                case UPDATE_QUANTITY:
                    stub.setQuantityOfMovie(cmd.identifier, cmd.quantity);
                    System.out.println("Updated");
                break;
            }
            end = System.nanoTime();
            System.err.println((end-start));
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
