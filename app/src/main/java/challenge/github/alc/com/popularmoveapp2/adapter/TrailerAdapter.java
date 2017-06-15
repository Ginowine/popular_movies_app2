package challenge.github.alc.com.popularmoveapp2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import challenge.github.alc.com.popularmoveapp2.R;
import challenge.github.alc.com.popularmoveapp2.model.Trailer;

/**
 * Created by Gino Osahon on 11/06/2017.
 */
public class TrailerAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private Trailer mTrailer = new Trailer();

    public TrailerAdapter(Context context, Trailer object){
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mTrailer = object;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class TrailerAdapterViewHolder{
        public ImageView imageView;
        public TextView nameView;
        public TextView siteView;
        public TextView typeView;

        public TrailerAdapterViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.trailer_image);
            nameView = (TextView) view.findViewById(R.id.trailer_name);
        }
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view = convertView;
        TrailerAdapterViewHolder viewHolder;

        if (view == null){
            view = mInflater.inflate(R.layout.movie_trailer, viewGroup, false);
            viewHolder = new TrailerAdapterViewHolder(view);
            view.setTag(viewHolder);
        }
        viewHolder = (TrailerAdapterViewHolder) view.getTag();
        viewHolder.nameView.setText(mTrailer.getName());

        String yt_thumbnail_url = "http://img.youtube.com/vi/" + mTrailer.getKey() + "/0.jpg";

        Picasso.with(mContext)
                .load(yt_thumbnail_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(viewHolder.imageView);

        return view;
    }
}