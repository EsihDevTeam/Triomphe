package devteam.esih.triomphe.Utils;

import android.os.AsyncTask;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.List;

import devteam.esih.triomphe.Models.Evenements;
import devteam.esih.triomphe.Models.Suivre;

public class DataQuery {

    public static ArrayList<Evenements> events;
    public static ArrayList<Suivre> matchings;
    public static boolean result;

    private DataQuery(){


    }

    public static boolean getEvents(){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Backendless.Persistence.of(Evenements.class).find(new AsyncCallback<List<Evenements>>() {
                    @Override
                    public void handleResponse(List<Evenements> response) {
                        Log.d("RESULT", response.toString());
                        events.addAll(response);
                        result = true;
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.d("FAILED", fault.getMessage());
                        result = false;
                    }
                });
            }
        });

        return result;
    }

    public static boolean getSuivre(BackendlessUser user){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
               Backendless.Persistence.of(Suivre.class).find(new AsyncCallback<List<Suivre>>() {
                   @Override
                   public void handleResponse(List<Suivre> response) {
                       matchings.addAll(response);
                       result = true;
                   }

                   @Override
                   public void handleFault(BackendlessFault fault) {
                       Log.d("FAILED", fault.getMessage());
                       result = false;
                   }
               });
            }
        });

        return result;
    }


}
