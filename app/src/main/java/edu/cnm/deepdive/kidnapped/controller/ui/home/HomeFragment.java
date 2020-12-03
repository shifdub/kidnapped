package edu.cnm.deepdive.kidnapped.controller.ui.home;

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
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.kidnapped.R;
import edu.cnm.deepdive.kidnapped.controller.ui.contact.ContactFragment;
import edu.cnm.deepdive.kidnapped.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

  private HomeViewModel homeViewModel;
  private FragmentHomeBinding binding;


  /**
   *
   * @param inflater inflates HomeFragment
   * @param container contains fragment_home layout
   * @param savedInstanceState
   * @return
   */
  @Nullable
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = edu.cnm.deepdive.kidnapped.databinding.FragmentHomeBinding.inflate(inflater);
    binding.addContactButton.setOnClickListener((v) ->
        Navigation.findNavController(getView()).navigate(R.id.fragment_contact));
    binding.passphraseButton.setOnClickListener((b) ->
        Navigation.findNavController(getView()).navigate(R.id.fragment_passphrase));
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return binding.getRoot();
  }
}