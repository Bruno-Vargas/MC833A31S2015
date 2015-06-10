/**
 * Created by BrunoVargas on 07/06/15.
 */
import java.util.Vector;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.List;

public class MovieRentalServer extends UnicastRemoteObject implements RentalInterface
{
    private Vector <Movie> movies;
    /*
        private String title;
        private String genre;
        private String director;
        private String synopsis;
        private int year;
        private float duration;
        private int identifier;
        private int quantity;
    **/

    public MovieRentalServer()  throws RemoteException{
        this.movies = new Vector<Movie>();

        Movie movie1 = new Movie("Termianor", "ScienceFiction", "James Cameron", "", 1984, 108.f, 1, 2);
        movie1.setSynopsis("Sinopse = Disguised as a human, a cyborg assassin known as a Terminator (Arnold Schwarzenegger) travels from 2029 to 1984 to kill Sarah Connor (Linda Hamilton). Sent to protect Sarah is Kyle Reese (Michael Biehn), who divulges the coming of Skynet, an artificial intelligence system that will spark a nuclear holocaust. Sarah is targeted because Skynet knows that her unborn son will lead the fight against them. With the virtually unstoppable Terminator in hot pursuit, she and Kyle attempt to escape.");

        Movie movie2 = new Movie("Matrix", "ScienceFiction", "Andy Wachowski", "", 1999, 136.f, 2, 2);
        movie2.setSynopsis("Sinopse = Thomas A.Anderson is a man leading a double life. By day, he is an average computer programmer who pays his taxes and helps his landlady take out the garbage. At night, he is a computer hacker by the name of Neo. He finds himself targeted by police when he is contacted by the legendary hacker, Morpheus. Neo wakes up in the real world, a ravaged wasteland. He finds out that most human beings are not born, but are creates by machines so that they can harvest their bioelectric and heat energy and fulfil their electricity needs. The minds of such people are imprisoned in an artificial reality known as the Matrix. Now a rebel, Neo learns about his role in the reality and must confront the agents, programs which all rebels fear, who plan on destroying the rebels and destroying the entire human existence.");

        Movie movie3 = new Movie("The Lord of the Rings: The Return of the King", "GenreAdventure", "Peter Jackson", "", 2003, 201.f, 3, 5);
        movie3.setSynopsis("Sinopse = The War of the Ring reaches its climax as the dark lord Sauron sets his sights on Minas Tirith, the capital of Gondor. The members of the fellowship in Rohan are warned of the impending attack when Pippin cannot resist looking into Saruman's palantir and is briefly contacted by the dark lord. King Theoden is too proud to send his men to help without being asked, so Gandalf and Pippin ride to Minas Tirith to see that this request is sent. They meet opposition there from Denethor, steward of the city and father of Faramir and the late Boromir. Denethor's family has acted as temporary guardians of Gondor for centuries until a member of the true line of kings returns. This member is none other than Aragorn, who must overcome his own self-doubt before he can take on the role he was destined to fulfill. Meanwhile, Frodo and Sam continue to carry the One Ring towards Mordor, guided by Gollum. What they don't know is that Gollum is leading them into a trap so that he can reclaim the Ring for himself. Though Sam suspects his deceit, Frodo is starting to be corrupted by the Ring's power and the mistrust of Sam this causes is fully exploited by Gollum. The only way good can prevail in this contest is if the Ring is destroyed, an event that is becoming harder every minute for Frodo to achieve. The fate of every living creature in Middle Earth will be decided once and for all as the Quest of the Ringbearer reaches its climax.");

        Movie movie4 = new Movie("Interview with the Vampire: The Vampire Chronicles", "GenreRomance","Neil Jordan", "", 1994, 123.f, 4, 15);
        movie4.setSynopsis("Sinopse = Interview with the Vampire is a 1994 American drama horror film directed by Neil Jordan, based on the 1976 novel Interview with the Vampire by Anne Rice, and starring Tom Cruise and Brad Pitt. The film focuses on Lestat (Cruise) and Louis (Pitt), beginning with Louis' transformation into a vampire by Lestat in 1791. The film chronicles their time together, and their turning of a twelve-year-old girl, Claudia, into a vampire. The narrative is framed by a present day interview, in which Louis tells his story to a San Francisco reporter. The supporting cast features Christian Slater, Kirsten Dunst, and Antonio Banderas.");

        Movie movie5 = new Movie("RedCliff", "GenreAdventure","John Woo", "", 2008, 148.f, 5, 1);
        movie5.setSynopsis("Sinopse = In Autumn of 208 AD, 100,000 peasants fled with their beloved leader Liu Bei from Cao Cao's million man army. With the aid of heroes like Zhao Yun (the subject of the new \"Three Kingdoms: Resurrection of the Dragon\" film) and Zhang Fei, they escape across the Great River (Chinese 'Yangtze') to take refuge with Sun Quan, the leader of the south. As Cao Cao prepares his huge navy to invade southern China and destroy them both, geniuses like Zhuge Liang and Zhou Yu devise a grand strategy. They hope to destroy Cao Cao's 10,000 ships with fire upon the river, but must first trick Cao Cao into chaining his ships together, and then change the direction of China's famous and freezing North Wind. While these two struggle to put aside the rivalry between Liu Bei and Sun Quan's forces, they must hatch their legendary schemes before Cao Cao is ready. This synopsis is based on the events of the 600 year old story - \"Romance of Three Kingdoms\" - the favorite novel of over 1 billion Chinese people and the most famous novel in Asia. Director John Woo said in an interview with CCTV-6 that the film will use primarily the historical record Chronicle of the Three Kingdoms as a blueprint for the Battle of Red Cliffs, rather than the historical novel Romance of the Three Kingdoms. As such, traditionally vilified characters such as Cao Cao and Zhou Yu will be given a more historically accurate treatment in the film. On Its Theatrical Release when it the two parts were released as one film");

        Movie movie6 = new Movie("Three Kingdoms", "GenreAdventure","Daniel Lee", "", 2008, 102.f, 6, 1);
        movie6.setSynopsis("of duty and from the humblest of roots rises through the ranks on wings of courage and cunning to command an army charged with liberating the land from an evil warlord. Inspiring by action, honor and a dream of unifying his divided nation, Zhao Zilong's heroism becomes legend, but as the years pass and the throne changes hands the war still rages on. When a newly enthroned king decides peace can only be achieved by defeating the warlords once and for all, the aging Zhao Zilong embarks on his final and greatest campaign, a road to adventure that will crown his name in glory for all time.");

        this.movies.add(movie1);
        this.movies.add(movie2);
        this.movies.add(movie3);
        this.movies.add(movie4);
        this.movies.add(movie5);
        this.movies.add(movie6);
    }

    /*
    * Return All information of all movies of MovieRental
    * */
    public String getAllMovies() throws RemoteException {
        long start, end;
        start = System.nanoTime();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(movies.get(i).getAllInfo());
        }

        String str = stringBuilder.toString();
        end = System.nanoTime();
        System.err.println((end-start));
        return str;
    }
    /*
    * Return all titles and years of MovieRental
    * */
    public String getAllNamesAndYears() throws RemoteException {
        long start, end;
        start = System.nanoTime();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(movies.get(i).getTitleAndYear());
        }

        String str = stringBuilder.toString();
        end = System.nanoTime();
        System.err.println((end-start));
        return str;    }
    /*
    * Return all movies of SciFi genre
    * */
    public String getAllSciFiMovies() throws RemoteException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(movies.get(0).getTitleAndYear());
        stringBuilder.append(movies.get(1).getTitleAndYear());

        String str = stringBuilder.toString();
        return str;
    }
    /*
    * Return all movies of Adventure genre
    * */
    public  String getAllAdventureMovies()  throws RemoteException{
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(movies.get(2).getTitleAndYear());
        stringBuilder.append(movies.get(4).getTitleAndYear());
        stringBuilder.append(movies.get(5).getTitleAndYear());

        String str = stringBuilder.toString();

        return str;
    }
    /*
    * Return all movies of Adventure genre
    * */
    public  String getAllRomanceMovies()  throws RemoteException{

        String str = movies.get(3).getTitleAndYear();

        return str;
    }
    /*
    * Returns a list of all the movies from the past type
    * */
    public String getAllTitlesAndYearByGenre(String genre)  throws RemoteException{
        long start, end;
        start = System.nanoTime();
        int aux = Integer.parseInt(genre);
        String str;
        switch (aux)
        {
            case  0:
                 str  = getAllAdventureMovies();
            case  1:
                 str = getAllRomanceMovies();
            case  2:
                str = getAllSciFiMovies();
            default:
                str = getAllMovies();
        }

        end = System.nanoTime();
        System.err.println((end-start));
        return str;
    }

    /*
    * Return the synopsis of the movie past
    * */
    public String getSynopsisById (String identifier)  throws RemoteException
    {
        long start, end;
        start = System.nanoTime();
        int id = Integer.parseInt(identifier);
        String str = movies.get(id).getSynopsis();
        end = System.nanoTime();
        System.err.println((end-start));
        return str;
    }
    /*
    * Return the all info of the movie past
    * */
    public String getInfoById (String identifier)  throws RemoteException
    {
        long start, end;
        start = System.nanoTime();
        int id = Integer.parseInt(identifier);
        String str = movies.get(id).getAllInfo();
        end = System.nanoTime();
        System.err.println((end-start));
        return str;
    }
    /*
    * Change the quantity available of the movie past
    * */
    public void setQuantityOfMovie (String identifier, int quantity)  throws RemoteException
    {
        long start, end;
        start = System.nanoTime();
        int id = Integer.parseInt(identifier);
        movies.get(id).setQuantity(quantity);

        end = System.nanoTime();
        System.err.println((end-start));
    }
    /*
    * Return the Quantity Disponible of the movie past
    * */
    public String getQuantityOfMovie (String identifier)  throws RemoteException
    {
        long start, end;
        start = System.nanoTime();
        int id = Integer.parseInt(identifier);
       
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(movies.get(id).getQuantity());

        String str = stringBuilder.toString() + "\n";
        end = System.nanoTime();
        System.err.println((end-start));
        return str;
    }

    public static void main(String args[]) {
        
        System.out.println("Iniciando servidor");
        
        try {
            MovieRentalServer obj = new MovieRentalServer(args[0]);
            Naming.rebind("MovieRental", obj);
            System.out.println("Servidor Inicializado");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e);
            e.printStackTrace();
        }
    }
}
