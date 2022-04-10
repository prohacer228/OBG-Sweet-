package com.project.grazproject.ui.myMessages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.grazproject.databinding.FragmentMyMessagesBinding;

public class MyMessagesFragment extends Fragment {

    private FragmentMyMessagesBinding binding;
    TextView myMessagesText;
    TextView myMessMain, myMessTheme, myMessAddress, myData;
 //   CardView myCard;

    public static Boolean isDoneMyMess;

   public static String theme = " ", message = " ", address = " ", data = " ";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MyMessagesViewModel myMessagesViewModel =
                new ViewModelProvider(this).get(MyMessagesViewModel.class);

        binding = FragmentMyMessagesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        myMessMain = binding.MyMesMainMess;
        myMessTheme = binding.MyMessTheme;
        myMessAddress = binding.MyMessAdress;
        myData = binding.myData;

        setMyMess();

        myMessagesText = binding.textMyMessages;
    myMessagesViewModel.getText().observe(getViewLifecycleOwner(), myMessagesText::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public static void setMeaning(String mess, String finalTheme, String finalAddress)
    {
        message = mess;
        theme = finalTheme;
        address = finalAddress;
    }

    public void setVisible()

    {
        if(isDoneMyMess) {
          //  newMessDone();

            myMessMain.setVisibility(View.VISIBLE);
            myMessTheme.setVisibility(View.VISIBLE);
            myMessAddress.setVisibility(View.VISIBLE);
            myData.setVisibility(View.VISIBLE);

          //  setMyMess();
        }
        else
        {
           // myCard.setVisibility(View.INVISIBLE);
            myMessMain.setVisibility(View.INVISIBLE);
            myMessTheme.setVisibility(View.INVISIBLE);
            myMessAddress.setVisibility(View.INVISIBLE);
            myData.setVisibility(View.INVISIBLE);
        }

    }

    public static void newMessDone()
    {
        theme = "Ужасная продукция";
        message = "Продукция оставляет желать лучшего";
        address = "ул. Мирная 64";
        data = "2022-04-11";

       // isDoneMyMess = true;
    }

    public void setMyMess()
    {
        myMessMain.setText(message);
        myMessTheme.setText(theme);
        myMessAddress.setText(address);
        myData.setText(data);
    }

}