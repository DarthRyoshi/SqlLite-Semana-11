package com.example.sqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context context;
    private List<DataModel> dataList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(DataModel data);
        void onDeleteClick(int id);
    }

    public DataAdapter(Context context, List<DataModel> dataList, OnItemClickListener listener) {
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewAge, textViewRut;
        ImageView buttonDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewRut = itemView.findViewById(R.id.textViewRut);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);

            buttonDelete.setOnClickListener(v -> listener.onDeleteClick(dataList.get(getAdapterPosition()).getId()));
        }

        public void bind(final DataModel data) {
            textViewName.setText(data.getName());
            textViewAge.setText(String.valueOf(data.getAge()));
            textViewRut.setText(data.getRut());
            itemView.setOnClickListener(v -> listener.onItemClick(data));
        }
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
