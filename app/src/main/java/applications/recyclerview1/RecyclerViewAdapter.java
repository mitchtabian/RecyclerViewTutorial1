package applications.recyclerview1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mitch on 2016-05-29.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

    public TextView meal;
    public TextView desert;


    public ViewHolder(final View itemView) {
        super(itemView);
        meal = (TextView) itemView.findViewById(R.id.textMeal);
        desert = (TextView) itemView.findViewById(R.id.textDesert);
    }

}
    private List<Food> mFood;

    public RecyclerViewAdapter(List<Food> foods) {
        mFood = foods;
    }


        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View contactView = inflater.inflate(R.layout.recycler_blueprint, parent, false);
            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewAdapter.ViewHolder viewHolder, int position) {
            Food food = mFood.get(position);

            TextView mMeal = viewHolder.meal;
            mMeal.setText(food.getMeal());

            TextView mDesert = viewHolder.desert;
            mDesert.setText(food.getDesert());
        }

        @Override
        public int getItemCount() {
            return mFood.size();
        }
}
