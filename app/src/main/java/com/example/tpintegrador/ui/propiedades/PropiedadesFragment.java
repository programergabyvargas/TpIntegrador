package com.example.tpintegrador.ui.propiedades;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.tpintegrador.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesFragment extends Fragment implements Propiedad.OnFragmentInteractionListener{

    private PropiedadesViewModel propiedadesViewModel;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private Button btEditar;
    private CheckBox chDisponible;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        propiedadesViewModel =
                ViewModelProviders.of(this).get(PropiedadesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);
        viewPager = root.findViewById(R.id.viewPage);
        appBarLayout =root.findViewById(R.id.appBar);
        tabLayout = new TabLayout(getContext());

        appBarLayout.addView(tabLayout);

        ViewPageAdapter vpa = new ViewPageAdapter(getChildFragmentManager());
        vpa.addFragment(new Propiedad(),"Propiedad 1");
        vpa.addFragment(new Propiedad(),"Propiedad 2");
        vpa.addFragment(new Propiedad(),"Propiedad 3");
        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);

   /*   btEditar = (Button) root.findViewById(R.id.btEditarPropiedad); //btEditarPropiedad
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarpropiedad(view);
            }
        });*/


//--------------
        return root;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public class ViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titulosFragments = new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm){
            super (fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragments.get(position);
        }

        public void addFragment(Fragment fragment, String titulo){
            fragmentList.add(fragment);
            titulosFragments.add(titulo);
        }

    }

   public void editarpropiedad(View view) {
        Log.d("editarpropiedad PF","ok");
        //Toast.makeText(getContext(),"Estoy class PropiedadesFragment, en editarpropiedad()", Toast.LENGTH_LONG).show();
    }
}