package challenge.github.alc.com.popularmoveapp2.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.StringBuilderPrinter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Gino Osahon on 07/06/2017.
 */
public class Movie implements Parcelable{

    public static final String POSTER_URL = "POSTER_URL";
    public static final String MOVIE_TITLE = "MOVIE_TITLE";
    public static final String MOVIE_RELEASE_DATE = "MOVIE_RELEASE_DATE";
    public static final String MOVIE_VOTE_AVERAGE = "MOVIE_VOTE_AVERAGE";
    public static final String MOVIE_OVERVIEW = "MOVIE_OVERVIEW";
    public static final String MOVIE_FAVOURITE = "MOVIE_FAVOURITE";
    public static final String BUNDLE = "movie";
    public static final String MOVIE_ID = "id";

    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("id")
    private int id;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("vote_count")
    private Integer voteCount;
    @SerializedName("vote_average")
    private Double voteAverage;
    @SerializedName("genre")
    private String genre;
    private Double rating;
    private long movie_id;
    private boolean favourite;
    private int check;

    public Movie(String posterPath,  String overview, String releaseDate, int id,
                 String originalTitle, String originalLanguage, String title, String backdropPath, Double popularity,
                 Integer voteCount, Double voteAverage, String genre, Double rating, long movieId) {
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.id = id;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.genre = genre;
        this.rating = rating;
        this.movie_id = movieId;
    }

    public  Movie(){

    }

    public Movie (Parcel parcel){
        this.posterPath = parcel.readString();
        this.overview = parcel.readString();
        this.releaseDate = parcel.readString();
        this.id = parcel.readInt();
        this.originalTitle = parcel.readString();
        this.originalLanguage = parcel.readString();
        this.title = parcel.readString();
        this.backdropPath = parcel.readString();
        this.popularity = parcel.readDouble();
        this.voteCount = parcel.readInt();
        this.voteAverage = parcel.readDouble();
        this.genre = parcel.readString();
        //this.rating = parcel.readDouble();
        this.movie_id = parcel.readLong();


    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(posterPath);
        parcel.writeString(overview);
        parcel.writeString(releaseDate);
        parcel.writeInt(id);
        parcel.writeString(originalTitle);
        parcel.writeString(originalLanguage);
        parcel.writeString(title);
        parcel.writeString(backdropPath);
        parcel.writeDouble(popularity);
        parcel.writeInt(voteCount);
        parcel.writeDouble(voteAverage);
        parcel.writeString(genre);
        //parcel.writeDouble(String.valueOf(rating));
        parcel.writeLong(movie_id);
        //parcel.writeString(String.valueOf(movie_id));
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
        if (favourite){
            check = 1;
        }
        else {
            check = 0;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }


    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>(){
        @Override
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };



}
