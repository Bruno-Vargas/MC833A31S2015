import java.rmi.*;
import java.rmi.registry.*;

public class MovieRentalClient {

    private MovieRentalClient() {}

    public static void main(String args[]) {
        
        try {
            
            MovieRentalInterface rentalStub  = (MovieRentalInterface) Naming.lookup("//" +
                "192.168.1.114" + 
                "/MovieRental");
            long start, end;

            CommandParser parser = new CommandParser();
            CommandWrapper cmd = parser.parseCommand(args);
            start = System.nanoTime();
            switch (cmd.command) {
                case LIST_ALL:
                System.out.println(rentalStub.getAllMovies());
                break;
                case LIST_ALL_TITLES_AND_YEARS:
                System.out.println(rentalStub.getAllNamesAndYears());
                break;
                case LIST_ALL_BY_GENRE:
                System.out.println(rentalStub.getAllTitlesAndYearByGenre(cmd.identifier));
                break;
                case SYNOPISIS_BY_ID:
                System.out.println(rentalStub.getSynopsisById(cmd.identifier));
                break;
                case INFO_BY_ID:
                System.out.println(rentalStub.getInfoById(cmd.identifier));
                break;
                case QUANTITY_BY_ID:
                System.out.println(rentalStub.getQuantityOfMovie(cmd.identifier));
                break;
                case UPDATE_QUANTITY:
                    rentalStub.setQuantityOfMovie(cmd.identifier, cmd.quantity);
                    System.out.println("Updated");
                break;
            }
            end = System.nanoTime();
            System.err.println((end-start));
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
