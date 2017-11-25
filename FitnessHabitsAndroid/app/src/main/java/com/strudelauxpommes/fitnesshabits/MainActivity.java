package com.strudelauxpommes.fitnesshabits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.strudelauxpommes.fitnesshabits.physicalactivity.PhysicalActivityFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rl, new PhysicalActivityFragment());
        fragmentTransaction.commit();

        setContentView(R.layout.fragment_physical_activity);
    }
}
