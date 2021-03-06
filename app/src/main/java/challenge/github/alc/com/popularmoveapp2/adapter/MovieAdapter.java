package challenge.github.alc.com.popularmoveapp2.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import challenge.github.alc.com.popularmoveapp2.DetailsActivity;
import challenge.github.alc.com.popularmoveapp2.R;
import challenge.github.alc.com.popularmoveapp2.model.Movie;

/**
 * Created by Gino Osahon on 07/06/2017.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder>{

    public static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";
    public List<Movie> movieList;
    private int rowLayout;
    private Context context;
    private int previousPosition = 0;


    public int getPosition() {
        return previousPosition;
    }

    public void setPosition(int position) {
        this.previousPosition = position;
    }

    public MovieAdapter(List<Movie> movies, int rowLayout, Context context){
        this.movieList = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public MovieAdapter(){

    }



    //A view holder inner class where we get reference to the views in the layout using their ID
    public static class MovieAdapterViewHolder extends RecyclerView.ViewHolder{

        private final LinearLayout full_layout;
        protected LinearLayout movieHolder;
        protected LinearLayout movieTitleHolder;
        protected ImageView imageView;
        protected TextView titleView;
        //ImageView backdropImage;

        public MovieAdapterViewHolder(View view){
            super(view);

            imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.full_layout = (LinearLayout) view.findViewById(R.id.movie_layout);
            this.movieHolder = (LinearLayout) view.findViewById(R.id.movieHolder);
            this.movieTitleHolder = (LinearLayout) view.findViewById(R.id.movieTitleHolder);
            this.titleView = (TextView) view.findViewById(R.id.title);

            view.setTag(getAdapterPosition());


        }
    }

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieAdapterViewHolder(itemView);

    }

    public void swapList(List<Movie> movies) {
        movieList = movies;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final MovieAdapterViewHolder holder, int position) {
       // String image_url = IMAGE_URL_BASE_PATH + movieList.get(position).getPosterPath();
        final Movie movies = movieList.get(position);
        String image_url = IMAGE_URL_BASE_PATH + movies.getPosterPath();

        Picasso.with(context)
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.imageView);

        holder.titleView.setText(movies.getTitle());
        holder.titleView.setContentDescription(movies.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Context context = holder.itemView.getContext();
                Bundle bundle = new Bundle();
                bundle.putInt(Movie.MOVIE_ID, movies.getId());
                bundle.putString(Movie.MOVIE_TITLE, movies.getOriginalTitle());
                bundle.putString(Movie.MOVIE_OVERVIEW, movies.getOverview());
                bundle.putString(Movie.POSTER_URL, movies.getPosterPath());
                bundle.putString(Movie.MOVIE_RELEASE_DATE, movies.getReleaseDate());
                bundle.putDouble(Movie.MOVIE_VOTE_AVERAGE, movies.getVoteAverage());
                //bundle.putBoolean(Movie.MOVIE_FAVOURITE, movies.isFavourite());

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(Movie.BUNDLE, bundle);
                //intent.putExtra("movie", movies);
                context.startActivity(intent);
            }
        });

        previousPosition = holder.getAdapterPosition();
        setPosition(previousPosition);
    }

    public List<Movie> getMoviesData() {
        return movieList;
    }



    @Override
    public int getItemCount() {
        return movieList.size();
    }

    /**
     * Reset the Movie List, new search, for example
     */
    public void clearMovieList() {
        if (null != movieList) {
           movieList.clear();
            notifyDataSetChanged();
        }

    }
}
