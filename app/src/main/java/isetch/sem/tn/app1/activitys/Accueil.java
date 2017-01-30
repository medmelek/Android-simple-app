package isetch.sem.tn.app1.activitys;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Binder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import isetch.sem.tn.app1.DataBase.Base;
import isetch.sem.tn.app1.R;

public class Accueil extends AppCompatActivity {
     Dialog dialog;

    Base base = new Base(this) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);


       final  EditText name=(EditText)findViewById(R.id.name);
       final EditText age = (EditText) findViewById(R.id.age) ;
        final EditText lastname = (EditText) findViewById(R.id.lastname) ;
        Button send = (Button)findViewById(R.id.ok)  ;

       final  AlertDialog.Builder com = new AlertDialog.Builder(this) ;





assert send!=null ;
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if( (String.valueOf(name.getText()).length()==0)||(String.valueOf(age.getText()).length()==0)||
                            (String.valueOf(lastname.getText()).length()==0) )
                        {
                        Toast.makeText(getApplicationContext(),"check your data ",Toast.LENGTH_LONG).show();
                    }else{

                        base.InsertRow(String.valueOf(name.getText()),
                                String.valueOf(name.getText()),
                                Integer.parseInt(String.valueOf(age.getText())));

                        com.setIcon(R.drawable.person);
                        com.setTitle("formulaire enregistrer");
                        com.setCancelable(true);
                        com.setMessage(String.valueOf(name.getText())+"\n"+String.valueOf(age.getText()));
                        //com.show();
                        com.setPositiveButton("go to base ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent versbase =  new Intent(getApplicationContext(),Liste.class) ;
                                startActivity(versbase);
                                dialog.dismiss();
                            }
                        });

                        dialog = com.show();
                    }



            }
        });
    }


}
