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

public class ContactFragment extends Fragment {

  private ContactViewModel contactViewModel;

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

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
  }
}