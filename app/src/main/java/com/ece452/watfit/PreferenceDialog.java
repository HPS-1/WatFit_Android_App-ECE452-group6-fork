package com.ece452.watfit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class PreferenceDialog extends AppCompatDialogFragment {
    private EditText edit_calorie;
    private EditText edit_protein;
    private EditText edit_fat;
    private EditText edit_carbohydrates;
    private PreferenceDialogListener preferenceDialogListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layour_dialog, null);

        builder.setView(view)
                .setTitle("Preference Dialog")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String calorie = edit_calorie.getText().toString();
                        String protein = edit_protein.getText().toString();
                        String fat = edit_fat.getText().toString();
                        String carbohydrates = edit_carbohydrates.getText().toString();
                        preferenceDialogListener.applyTexts(calorie, protein, fat, carbohydrates);

                    }
                });

        edit_calorie = view.findViewById(R.id.edit_calorie);
        edit_carbohydrates = view.findViewById(R.id.edit_carbohydrates);
        edit_fat = view.findViewById(R.id.edit_fat);
        edit_protein = view.findViewById((R.id.edit_protein));
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            preferenceDialogListener = (PreferenceDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+" must implement PreferenceDialogListener");
        }
    }

    public interface PreferenceDialogListener{
        void applyTexts(String calorie, String carbohydrates, String fat, String protein);
    }
}
