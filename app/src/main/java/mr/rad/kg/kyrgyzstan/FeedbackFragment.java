package mr.rad.kg.kyrgyzstan;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mr.rad.kg.kyrgyzstan.object.Message;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {

    View view;
    ProgressDialog progressDialog;

    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feedback, container, false);

        Button send = (Button) view.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = ProgressDialog.show(getContext(), "Отправка", "Сообщение отправляется", true);

                final EditText emailEt = (EditText) view.findViewById(R.id.editText);
                final EditText messageEt = (EditText) view.findViewById(R.id.editText2);


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(HTTPService.ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                HTTPService service = retrofit.create(HTTPService.class);

                String email = emailEt.getText().toString().trim();
                String message = messageEt.getText().toString().trim();

                service.send(email, message).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Toast.makeText(getContext(), "Сообщение отправлено!", Toast.LENGTH_SHORT).show();
                        emailEt.setText("");
                        messageEt.setText("");
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(getContext(), "Невозможно отправить", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }
}
