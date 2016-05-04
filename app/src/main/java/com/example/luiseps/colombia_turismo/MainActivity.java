package com.example.luiseps.colombia_turismo;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {

    private String[] opciones;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;


    private CharSequence tituloSec;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        opciones = new String[]{"Inicio", "Sitios Turisticos", "Hoteles", "Bares", "Demografia"};

        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        listView = (ListView) findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().
                getThemedContext(), android.R.layout.simple_list_item_1, opciones));


        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;

                switch (position) {
                    case 0:
                                fragment = new inicio();
                        break;
                    case 1:     fragment = new SitiosTuristicos();
                        break;
                    case 2:
                                 fragment = new Hoteles();
                        break;
                    case 3:      fragment = new Bares();
                        break;
                    case 4:
                                 fragment = new Demografia();
                        break;
                }

                if (fragment != null) {


                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                    listView.setItemChecked(position, true);
                    tituloSec = opciones[position];
                    ab.setTitle(tituloSec);
                    drawerLayout.closeDrawer(listView);
                }
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_menu_white, R.string.abierto, R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.luiseps.colombia_turismo/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.luiseps.colombia_turismo/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public  void mapas(View view){

        Intent i;
        switch (view.getId()){

            case R.id.kankurua:
                i = new Intent(this,MapsActivity.class);
                i.putExtra("Lat",10.477625);
                i.putExtra("Lng",-73.245383);
                i.putExtra("sitio","Bar Kankurua");

                startActivityForResult(i,1234);

                break;
            case R.id.ksa:
                i=new Intent(this,MapsActivity.class);
                i.putExtra("Lat",10.487041);
                i.putExtra("Lng",-73.259200);
                i.putExtra("sitio","Bar Ksa Club");

                startActivityForResult(i,1234);
                break;
            case R.id.cant:
                i=new Intent(this,MapsActivity.class);
                i.putExtra("Lat",10.487041);
                i.putExtra("Lng",-73.259200);
                i.putExtra("sitio","Bar Cantores");

                startActivityForResult(i,1234);

                break;
            case R.id.acordeon:
                i = new Intent(this,MapsActivity.class);
                i.putExtra("Lat",10.490217);
                i.putExtra("Lng",-73.2265032);
                i.putExtra("sitio","Glorieta Pedazo de Acordeon");

                startActivityForResult(i,1234);

                break;
            case R.id.plaza:
                i=new Intent(this,MapsActivity.class);
                i.putExtra("Lat",10.477625);
                i.putExtra("Lng",-73.244731);
                i.putExtra("sitio","Plaza Alfonzo Lopez");

                startActivityForResult(i,1234);
                break;
            case R.id.rio:
                i=new Intent(this,MapsActivity.class);
                i.putExtra("Lat",10.50156);
                i.putExtra("Lng",-73.26953);
                i.putExtra("sitio","Rio Guatapuri");

                startActivityForResult(i,1234);
                break;
            case R.id.hilton:
                i = new Intent(this,MapsActivity.class);
                i.putExtra("Lat",40.7127837);
                i.putExtra("Lng",-74.005941);
                i.putExtra("sitio","Hampton By Hilton");

                startActivityForResult(i,1234);

                break;
            case R.id.sonesta:
                i=new Intent(this,MapsActivity.class);
                i.putExtra("Lat",10.4483);
                i.putExtra("Lng",-73.2493796);
                i.putExtra("sitio","Hotel Sonesta");

                startActivityForResult(i,1234);
                break;
            case R.id.sicarare:
                i=new Intent(this,MapsActivity.class);
                i.putExtra("Lat",10.47517);
                i.putExtra("Lng",-73.247121);
                i.putExtra("sitio","Hotel Sicarare");

                startActivityForResult(i,1234);

                break;
            case R.id.demo:
                i=new Intent(this,MapsActivity.class);
                i.putExtra("Lat",10.477625);
                i.putExtra("Lng",-73.244731);
                i.putExtra("sitio","Valledupar");

                startActivityForResult(i,1234);

                break;
        }
    }
}

