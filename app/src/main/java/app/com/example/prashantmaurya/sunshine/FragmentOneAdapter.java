package app.com.example.prashantmaurya.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by prashant.maurya on 12/18/2016.
 */
public class FragmentOneAdapter extends RecyclerView.Adapter<FragmentOneAdapter.ViewHolder> {
    private List<MatchDetails> matchList;
    private OneFragment context;




    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView matchBetween,totalScore,runScoreTeamOne;
        public ImageView winnerImage;

        public ViewHolder(View v) {
            super(v);
            matchBetween=(TextView)v.findViewById(R.id.match_between);
            winnerImage=(ImageView)v.findViewById(R.id.winner_image);
        }
    }

    public FragmentOneAdapter(OneFragment context, List<MatchDetails> matchList) {
        this.context = context;
        this.matchList = matchList;

    }

    @Override
    public FragmentOneAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_one_textview, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(FragmentOneAdapter.ViewHolder holder, int position) {
        MatchDetails matchDetails=matchList.get(position);
        holder.matchBetween.setText(matchDetails.getPlayedBetween());
        Glide.with(context).load(matchDetails.getMatchImage()).into(holder.winnerImage);


    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }


}
