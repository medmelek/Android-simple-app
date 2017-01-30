package isetch.sem.tn.app1.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import isetch.sem.tn.app1.DataBase.Base;
import isetch.sem.tn.app1.R;
import isetch.sem.tn.app1.adapter.Etudiant_adapter;
import isetch.sem.tn.app1.model.Etudiant;

public class Liste extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Etudiant> etudiants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        // recyclerview declaration
        recyclerView =(RecyclerView) findViewById(R.id.View);
        //recyclerView.setHasFixedSize(true);
        // layout manager declaration
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        /*etudiants = new ArrayList<>();
        etudiants.add(new Etudiant(" Mohamed Melek","22","Oueslati"));
        etudiants.add(new Etudiant("oumaima","25","tarhouni"));
        etudiants.add(new Etudiant (" Amal ","21","merchoui"));
        etudiants.add(new Etudiant (" nhla ","21","amri"));
        etudiants.add(new Etudiant (" sirnie ","21","mabrouk"));
        etudiants.add(new Etudiant (" yosraa","21","jemaa"));
        etudiants.add(new Etudiant (" nesrine","21","fadhel"));
        etudiants.add(new Etudiant (" oumaya ","21","khmir"));
        etudiants.add(new Etudiant (" sirine ","21","khmir"));*/

        Base base = new Base(this);

        etudiants=base.getAllrecord()  ;


        Etudiant_adapter adapter = new Etudiant_adapter(this,etudiants);
        recyclerView.setAdapter(adapter);






    }
}
