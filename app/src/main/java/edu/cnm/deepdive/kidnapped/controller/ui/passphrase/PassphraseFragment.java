package edu.cnm.deepdive.kidnapped.controller.ui.passphrase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.kidnapped.R;

public class PassphraseFragment extends Fragment {

  private PassphraseViewModel passphraseViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    passphraseViewModel =
        ViewModelProviders.of(this).get(PassphraseViewModel.class);
    View root = inflater.inflate(R.layout.fragment_passphrase, container, false);
    final TextView textView = root.findViewById(R.id.text_passphrase);
    passphraseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}