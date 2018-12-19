package com.example.ismailamassi.bookinghall.Fragments.CommonFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    Switch notification_switch;
    Spinner spinner_lang;

    String languageToLoad;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onClickItems();
    }

    private void bindView(View view) {
        notification_switch = view.findViewById(R.id.notification_switch);
        spinner_lang = view.findViewById(R.id.spinner_lang);
    }

    private void onClickItems() {
        notification_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getActivity(), isChecked + "", Toast.LENGTH_SHORT).show();
            }
        });

        languageToLoad = "ar_AR";
        final String[] lang = getContext().getResources().getStringArray(R.array.lang);
        spinner_lang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    String selectedLang = lang[position];
                    if (selectedLang.equals("Arabic")) {
                        languageToLoad = "ar_AR";
                        Toast.makeText(getActivity(), "Done Change Language To Arabic", Toast.LENGTH_SHORT).show();
                    } else if (selectedLang.equals("English")) {
                        languageToLoad = "en_EN";
                        Toast.makeText(getActivity(), "Done Change Language To English", Toast.LENGTH_SHORT).show();
                    } else if (selectedLang.equals("France")) {
                        languageToLoad = "fr_FR";
                        Toast.makeText(getActivity(), "Done Change Language To France", Toast.LENGTH_SHORT).show();
                    }
//                    Locale locale = new Locale(languageToLoad);
//                    Locale.setDefault(locale);
//                    Configuration config = new Configuration();
//                    config.locale = locale;
//                    getContext().getResources().updateConfiguration(config, getContext().getResources().getDisplayMetrics());
//                    Intent intent = new Intent(getActivity(), MainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
