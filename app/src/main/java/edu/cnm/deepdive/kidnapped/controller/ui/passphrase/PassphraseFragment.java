package edu.cnm.deepdive.kidnapped.controller.ui.passphrase;

import android.Manifest;
import android.Manifest.permission;
import android.content.Context;
import android.content.pm.PackageManager;
import android.icu.util.TimeZone;
import android.icu.util.ULocale;
import android.media.MediaRecorder;
import android.media.MediaRecorder.AudioEncoder;
import android.media.MediaRecorder.AudioSource;
import android.media.MediaRecorder.OutputFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.kidnapped.R;
import edu.cnm.deepdive.kidnapped.databinding.FragmentHomeBinding;
import edu.cnm.deepdive.kidnapped.databinding.FragmentPassphraseBinding;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PassphraseFragment extends Fragment {

  private ImageButton recordButton;
  private boolean isRecording;
  private String recordPermission = permission.RECORD_AUDIO;
  private int PERMISSION_CODE = 9;
  private MediaRecorder mediaRecorder;
  private String recordFile;
  private boolean settingUpRecording;
  private boolean tearingDownRecording;


  /**
   *
   * @param inflater This inflater inflates the passphrase layout
   * @param container contains the PassphraseFragment layout
   * @param savedInstanceState This parameter store data needed to reload the state of the PassphraseFragment
   * @return returns the PassphraseFragment layout
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_passphrase, container, false);
  }

  /**
   *
   * @param view is a base class used to create the recordButton
   * @param savedInstanceState stores data needed to reload the state of the recordButton
   */

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    recordButton = view.findViewById(R.id.recordButton);
    recordButton.setOnClickListener(this::toggleRecording);
  }

  /**
   *
   * @param v is a variable assisgned to the base class View.
   */
  public void toggleRecording(View v) {
    if (!settingUpRecording && !tearingDownRecording) {
      if (isRecording) {
        stopRecording();
      } else if (checkPermissions()) {
        startRecording();
      }
    }
  }

  /**
   * The stopRecording method is used to tell the media recorder how to react to the recordButton being
   * pressed or released and to start/stop accordingly as well as log errors
   */
  private void stopRecording() {
    try {
      tearingDownRecording = true;
      if (mediaRecorder != null) {
        mediaRecorder.stop();
        mediaRecorder.release();
      }
    } catch (Throwable e) {
      //No need to handle this exception
      Log.e(getClass().getSimpleName(), e.getMessage(), e);
    } finally {
      recordButton.setImageResource(R.drawable.record_stop);
      mediaRecorder = null;
      isRecording = false;
      tearingDownRecording = false;
    }

  }

  /**
   *
   *This method assigns a path for recorded sound media, the microphone used to record, as well as a format
   * to record date and time, even the timezone.
   *  We also assign our record button and its resource location for the picture used for the button.
   */

  private void startRecording() {
    try {
      settingUpRecording = true;
      String recordPath = getActivity().getExternalFilesDir("/").getAbsolutePath();
      SimpleDateFormat formatter = new SimpleDateFormat("yyy_MM_dd_hh_mm_ss", Locale.US);
      Date now = new Date();
      recordFile = "Recording_" + formatter.format(now) + ".3gp";
      mediaRecorder = new MediaRecorder();
      mediaRecorder.setAudioSource(AudioSource.MIC);
      mediaRecorder.setOutputFormat(OutputFormat.THREE_GPP);
      mediaRecorder.setOutputFile(recordPath + "/" + recordFile);
      mediaRecorder.setAudioEncoder(AudioEncoder.AMR_NB);
      mediaRecorder.prepare();
      mediaRecorder.start();
      recordButton
          .setImageResource(R.drawable.microphone_logo);
      isRecording = true;
    } catch (Throwable e) {
      Log.e(getClass().getSimpleName(), e.getMessage(), e);
      stopRecording();
    } finally {
      settingUpRecording = false;
    }
  }

  /**
   * This methodd asks the user to grant or deny permission to use the device microphone to record audio
   * @return If the user accepts permission granted is returned. If user selects "deny",
   * permission is not granted and audio cannot be recorded.
   */

  private boolean checkPermissions() {
    if (ActivityCompat.checkSelfPermission(getContext(), recordPermission)
        == PackageManager.PERMISSION_GRANTED) {
      return true;
    } else {
      ActivityCompat
          .requestPermissions(getActivity(), new String[]{recordPermission}, PERMISSION_CODE);
      return false;
    }
  }
}

