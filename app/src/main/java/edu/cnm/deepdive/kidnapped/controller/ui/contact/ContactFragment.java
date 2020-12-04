package edu.cnm.deepdive.kidnapped.controller.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.kidnapped.R;
import edu.cnm.deepdive.kidnapped.model.entity.Contact;

/**
 * This fragment allows the user to input and save a contacts name,and phone number, as well as type an alert
 * text message to be sent to the user upon activation of the app.
 */

public class ContactFragment extends Fragment {

  private ContactViewModel contactViewModel;

  /**
   *
   * @param inflater inflates the fragment_contact layout
   * @param container is a base class which serves as the base class for Contact Fragment's layout parameters.
   * @param savedInstanceState  This parameter stores data needed to reload the state of the ContentFragment
   * @return returns fragment_contact layout
   */

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_contact, container, false);
    root.findViewById(R.id.saveContactButton).setOnClickListener((v) -> {
      Contact contact = new Contact();
      //TODO Populate the fields of contact with contents of view objects on the screen.
      contactViewModel.save(contact);
    });
    return root;
  }

  /**
   * @param view is a base class that creates the interactive components of the contactViewModel
   * @param savedInstanceState This parameter stores data needed to reload the state of the contactViewModel
   */

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
  }
}