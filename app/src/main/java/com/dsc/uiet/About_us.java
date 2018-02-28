package com.dsc.uiet;

import android.icu.util.Calendar;
import android.icu.util.RangeValueIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_about);
        Element adsElement = new Element();
        adsElement.setTitle("Advertise here");

        View aboutPage =new AboutPage(this)
                .isRTL(false)

                .setDescription("Developed By Team: AngryNerds\n(2nd Year)\nRahul Lather(251602107)\nMohit Sharma(251602134)\nYogesh Yadav(251602111)\nUnder the Guidance of:\nAnubhav Gupta(2514221)(4th Year)")
                //.setDescription("Rahul Lather(251602107)")
                //.setDescription("Mohit Sharma(251602134)")
                //.setDescription("Yogesh Yadav(251602111)")
                //.setDescription("Under the Guidance of:<br> Anubhav Gupta(2514221)")
                .addItem(adsElement)
                .addGroup("Connect With Us")
                .addEmail("sachinlather49@gmail.com")
                // .addPlayStore("My PlayStore")
                .addInstagram("lather_rahul").addTwitter("ee2da842f1624bb")
                .addInstagram("mk_sharma1").addTwitter("mksharma34")
                .addInstagram("yadav.yogesh293")
                .addInstagram("gupta.anubhav25").addTwitter("gupta_anubhav25")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }
    private Element createCopyright(){
        final Element copyright =new Element();
        final String copyrightString =String.format("Copyright %d by AngryNerds", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(About_us.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}


