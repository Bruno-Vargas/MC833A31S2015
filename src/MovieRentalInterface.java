/**
 * Created by BrunoVargas on 07/06/15.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MovieRentalInterface extends Remote {

    /*
     * Return All information of all movies of MovieRental
     * */
    public Response getAllMovies()  throws RemoteException;
    /*
    * Return all titles and years of MovieRental
    * */
    public Response getAllNamesAndYears() throws RemoteException;
    /*
    * Returns a list of all the movies from the past type
    * */
    public Response getAllTitlesAndYearByGenre(String genre) throws RemoteException;
    /*
    * Return the synopsis of the movie past
    * */
    public Response getSynopsisById (String identifier) throws RemoteException;
    /*
    * Return the all info of the movie past
    * */
    public Response getInfoById (String idenfifier) throws RemoteException;
    /*
    * Change the quantity available of the movie past
    * */
    public Response setQuantityOfMovie (String identifier, int quantity) throws RemoteException;
    /*
    * Return the Quantity Disponible of the movie past
    * */
    public Response getQuantityOfMovie (String identifier) throws RemoteException;

}
