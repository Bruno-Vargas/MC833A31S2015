/**
 * Created by BrunoVargas on 07/06/15.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MovieRentalInterface extends Remote {

    /*
     * Return All information of all movies of MovieRental
     * */
    public String getAllMovies()  throws RemoteException;
    /*
    * Return all titles and years of MovieRental
    * */
    public String getAllNamesAndYears() throws RemoteException;
    /*
    * Returns a list of all the movies from the past type
    * */
    public String getAllTitlesAndYearByGenre(String genre) throws RemoteException;
    /*
    * Return the synopsis of the movie past
    * */
    public String getSynopsisById (String identifier) throws RemoteException;
    /*
    * Return the all info of the movie past
    * */
    public String getInfoById (String idenfifier) throws RemoteException;
    /*
    * Change the quantity available of the movie past
    * */
    public void setQuantityOfMovie (String identifier, int quantity) throws RemoteException;
    /*
    * Return the Quantity Disponible of the movie past
    * */
    public String getQuantityOfMovie (String identifier) throws RemoteException;

}
