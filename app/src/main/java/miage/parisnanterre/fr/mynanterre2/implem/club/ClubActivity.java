package miage.parisnanterre.fr.mynanterre2.implem.club;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

import miage.parisnanterre.fr.mynanterre2.fragment.AccueilFragment;
import miage.parisnanterre.fr.mynanterre2.fragment.CrousFragment;
import miage.parisnanterre.fr.mynanterre2.fragment.MajFragment;
import miage.parisnanterre.fr.mynanterre2.fragment.PlanFragment;
import miage.parisnanterre.fr.mynanterre2.fragment.TrainFragment;
import miage.parisnanterre.fr.mynanterre2.implem.club.fragment.ClubFragment;
import miage.parisnanterre.fr.mynanterre2.R;
import miage.parisnanterre.fr.mynanterre2.implem.library.fragment.BiblioFragment;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private int mSelectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_menu);

        FrameLayout flm = findViewById(R.id.flContent);
        flm.bringToFront();

        /* Set a Toolbar to replace the ActionBar. */
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.my_icon));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toolbar.setNavigationIcon(R.drawable.menu);


        // Find our drawer view
        mDrawer = findViewById(R.id.drawer_layout);
        nvDrawer = findViewById(R.id.nvView);
        // Setup drawer view

        setupDrawerContent(nvDrawer);

        mSelectedId = R.id.nav_clubs;
        selectDrawerItem(mSelectedId);
        setTitle("Clubs");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem.getItemId());
                        menuItem.setChecked(true);
                        // Set action bar title
                        setTitle(menuItem.getTitle());
                        return true;
                    }
                });
    }

    public void selectDrawerItem(int mSelectedId) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass = null;
        switch(mSelectedId) {
            case R.id.nav_accueil:
                fragmentClass = AccueilFragment.class;
                break;
            case R.id.nav_bu:
                fragmentClass = BiblioFragment.class;
                break;
            case R.id.nav_crous:
                fragmentClass = CrousFragment.class;
                break;
            case R.id.nav_plan:
                fragmentClass = PlanFragment.class;
                break;
            case R.id.nav_clubs:
                fragmentClass = ClubFragment.class;
                break;
            case R.id.nav_train:
                fragmentClass = TrainFragment.class;
                break;
            case R.id.nav_maj:
                fragmentClass = MajFragment.class;
                break;
            default:
                fragmentClass = AccueilFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.flContent, fragment)
                .commitNow();

        // Highlight the selected item has been done by NavigationView

        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}