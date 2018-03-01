package com.dsc.uiet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new myWebViewClient());
        myWebView.loadUrl("http://www.uietkuk.org");
    }

    class myWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(url.endsWith(".pdf")){

                Intent i = new Intent(MainActivity.this,AcademicCalendar.class);
                i.putExtra("url",url);
                startActivity(i);

                return true;
            }
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent m = new Intent(this,home.class);

            startActivity(m);


        }
        else if(id==R.id.panel)
        {
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.setWebViewClient(new myWebViewClient());
            myWebView.loadUrl("http://49.50.77.75/");
        }
        else if(id==R.id.news)
        {
            Intent i = new Intent(this,AcademicCalendar.class);
            i.putExtra("url","http://www.uietkuk.org/uploads/google.pdf");
            startActivity(i);

        }
        else if(id==R.id.gallery)
        {
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.setWebViewClient(new myWebViewClient());
            myWebView.loadUrl("http://www.uietkuk.org/Gallery.php");

        }
        else if(id==R.id.fee)
        {
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.setWebViewClient(new myWebViewClient());
            myWebView.loadUrl("http://uietkuk.org/online-feepayment/");
        }
        else if(id==R.id.calendar)
        {
            Intent i = new Intent(this,AcademicCalendar.class);
            i.putExtra("url","http://www.uietkuk.org/uploads/Academic%20Calender%202017-18.pdf");
            startActivity(i);
        }
        else if(id==R.id.admission_)
        {
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.setWebViewClient(new myWebViewClient());
            myWebView.loadUrl("http://www.uietkuk.org/admissions.php");
        }
        else if(id==R.id.downloads)
        {
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.setWebViewClient(new myWebViewClient());
            myWebView.loadUrl("http://www.uietkuk.org/downloads.php");
        }
        else if(id==R.id.atglance)
        {           Intent j = new Intent(this,atglance.class);
            startActivity(j);
        }

        else if(id==R.id.contact)
        {           Intent k = new Intent(this,contact_us.class);
            startActivity(k);
        }

        else if(id==R.id.about)
        {           Intent l = new Intent(this,About_us.class);
            startActivity(l);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}


