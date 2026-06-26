package bookmyshow;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TicketService {
    private static volatile TicketService instance;
    private final Map<String, Movies> movies;
    private final Map<String, Show> shows;
    private final Map<String, Theater> theaters;
    private final Map<String, User> users;
    private final BookingManager bookingManager;
    private final SeatLockManager seatLockManager;

    public TicketService() {
        this.movies = new ConcurrentHashMap<>();
        this.shows = new ConcurrentHashMap<>();
        this.theaters = new ConcurrentHashMap<>();
        this.users = new ConcurrentHashMap<>();

        this.seatLockManager = new SeatLockManager();
        this.bookingManager = new BookingManager(seatLockManager);
    }

    public static TicketService getInstance() {
        if (instance == null) {
            synchronized (TicketService.class) {
                if (instance == null) {
                    instance = new TicketService();
                }
            }
        }
        return instance;
    }

    public BookingManager getBookingManager() {
        return bookingManager;
    }

    public City addCity(String id, String name) {
        return new City(id, name);
    }

    public Theater addTheater(String id, String name, City city, List<Screen> screens) {
        Theater theater = new Theater(id, name, city, screens);
        theaters.put(id, theater);
        return theater;
    }

    public Movie addMovie(String id, String name, long duration) {
        Movie movie = new Movie(id, name, duration);
        movies.put(id, movie);
        return movie;
    }

    public Show addShows(String id, Movie movie, Screen screen, Date startDate, PricingStrategy pricingStrategy) {
        Show show = new Show(id, movie, screen, startDate, pricingStrategy);
        shows.put(id, show);
        return show;
    }

    public User addUser(String name, String email) {
        return new User(name, email);
    }

    public Optional<Booking> bookTickets(String userId, String showId, List<String> seats, PaymentStrategy paymentStrategy) {
        return bookingManager.createBooking(userId, showId, seats, paymentStrategy);
    }

    // --- Search Functionality ---
    public List<Show> findShows(String movieTitle, String cityName) {
        List<Show> result = new ArrayList<>();
        shows.values().stream()
            .filter(show -> show.getMovie().getTitle().equalsIgnoreCase(movieTitle))
            .filter(show -> {
                Cinema cinema = findCinemaForShow(show);
                return cinema != null && cinema.getCity().getName().equalsIgnoreCase(cityName);
            })
            .forEach(result::add);
        return result;
    }

    private Cinema findCinemaForShow(Show show) {
        // This is inefficient. In a real system, shows would have a direct link to the cinema.
        // For this example, we traverse the cinema list.
        return cinemas.values().stream()
                .filter(cinema -> cinema.getScreens().contains(show.getScreen()))
                .findFirst()
                .orElse(null);
    }

    public void shutdown() {
        this.seatLockManager.shutdown();
        System.out.println("MovieTicketBookingSystem has been shut down.");
    }
}