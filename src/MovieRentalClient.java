import java.rmi.*;
import java.rmi.registry.*;

public class MovieRentalClient {

    private MovieRentalClient() {}

    public static void main(String args[]) {
        
        try {
            
            Response response = new Response("", 1);
            Boolean timeOnly = true;
                

            CommandParser parser = new CommandParser();
            CommandWrapper cmd = parser.parseCommand(args);

            long start, end, diff;

            int count = 1;

            while (count > 0) {
                
                start = System.nanoTime();

                MovieRentalInterface rentalStub  = (MovieRentalInterface) Naming.lookup("//" +
                    "192.168.1.156" + 
                    "/MovieRental");
                
                switch (cmd.command) {
                    case LIST_ALL:
                    response = rentalStub.getAllMovies();
                    break;
                    case LIST_ALL_TITLES_AND_YEARS:
                    response = rentalStub.getAllNamesAndYears();
                    // System.err.println(response.toString());
                    break;
                    case LIST_ALL_BY_GENRE:
                    response = rentalStub.getAllTitlesAndYearByGenre(cmd.identifier);
                    break;
                    case SYNOPISIS_BY_ID:
                    response = rentalStub.getSynopsisById(cmd.identifier);
                    break;
                    case INFO_BY_ID:
                    response = rentalStub.getInfoById(cmd.identifier);
                    break;
                    case QUANTITY_BY_ID:
                    response = rentalStub.getQuantityOfMovie(cmd.identifier);
                    break;
                    case UPDATE_QUANTITY:
                        response = rentalStub.setQuantityOfMovie(cmd.identifier, cmd.quantity);
                    break;
                }
                end = System.nanoTime();
                diff = end-start;

                long readTime = response.getTime()/1000;
                long comnTime = diff/1000;

                if (timeOnly) {
                    System.out.printf("%d,%d\n", readTime, comnTime);
                } else {
                    System.err.println(response.toString()+"|"+comnTime);
                }

                count = count - 1;
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
