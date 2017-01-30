package isetch.sem.tn.app1.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import isetch.sem.tn.app1.R;
import isetch.sem.tn.app1.model.Etudiant ;
/**
 * Created by Med Melek on 29/09/2016.
 */

public class Etudiant_adapter extends RecyclerView.Adapter<Etudiant_adapter.EtudiantViewHolder>  {

    private Context context;
    private ArrayList<Etudiant> etudiants ;

    public Etudiant_adapter(Context context, ArrayList<Etudiant> etudiants ) {
        this.context  = context;
        this.etudiants = etudiants;
    }

    public class EtudiantViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView lastname;
        TextView age;


        public EtudiantViewHolder(View item) {
            super(item);
            cv = (CardView)itemView.findViewById(R.id.cv);
            name = (TextView)itemView.findViewById(R.id.name);
            age = (TextView)itemView.findViewById(R.id.age);
            lastname=(TextView)itemView.findViewById(R.id.lastname);


        }
    }
    @Override
    public EtudiantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        EtudiantViewHolder pvh = new EtudiantViewHolder(v);
        return pvh;



    }

    @Override
    public void onBindViewHolder(EtudiantViewHolder holder, int position) {

        holder.name.setText(etudiants.get(position).getName());
        holder.age.setText(etudiants.get(position).getAge());
        holder.lastname.setText(etudiants.get(position).getLastname());

    }

    @Override
    public int getItemCount() {
        return etudiants.size();
    }

     /*@Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }*/



}
