package Library;

import android.databinding.BindingAdapter;
import android.util.Pair;
import android.widget.EditText;

import com.alejandro.tiendakotlin.R;

import org.jetbrains.annotations.Nullable;

import Models.BindableString;

public class BindEditText {

    @BindingAdapter({"app:binding"})
    public static void BindEditText(EditText view, final BindableString bindableString){

        Pair<BindableString, TextWatcherAdapter> pair = (Pair) view.getTag(R.id.bound_obserble);
        if(pair == null || pair.first != bindableString ){
            if (pair!= null){
                view.removeTextChangedListener(pair.second);
            }

            TextWatcherAdapter watcher = new TextWatcherAdapter(){
                @Override
                public void onTextChanged(@Nullable CharSequence s, int p1, int p2, int p3) {
                    bindableString.setValue(s.toString());
                }
            };

            view.setTag(R.id.bound_obserble, new Pair<>(bindableString, watcher));
            view.addTextChangedListener(watcher);
        }

        String newValue = bindableString.getValue();
        if(!view.getText().toString().equals(newValue)){
            view.setText(newValue);
        }
    }

}
