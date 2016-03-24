package com.epita.rayanhugo.party2nite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class Carte
    {
        int num;
        int coul;

        public Carte(int num, int coul)
        {
            this.num = num;
            this.coul = coul;
        }
    }

    public class Jeu
    {
        int nbjoueurs;
        int curr_carte;
        Carte[] paquet = new Carte[52];

        public Jeu(int nbjoueurs)
        {
            this.nbjoueurs = nbjoueurs;
            curr_carte = -1;
            for (int i = 0; i <= 3; i++)
            {
                for (int j = 0; j <=12; j++)
                {
                    paquet[i*13 + j] = new Carte(i, j);
                }
            }

            Random r = new Random();
            int tmp;

            for (int i = 0; i <= 51; i++)
            {
                tmp = r.nextInt(52 - i);
                SwapCarte(tmp, 51 - i);
            }
        }

        private void SwapCarte(int i1, int i2)
        {
            Carte tmp = paquet[i1];
            paquet[i1] = paquet[i2];
            paquet[i2] = tmp;
        }

        public Carte TirerCarte()
        {
            curr_carte++;
            return paquet[curr_carte];
        }
    }
}
