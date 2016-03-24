package sesom.com.viewpagernofragent;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Se-som3 on 3/24/2016.
 */
public class SimpleDialogFragment extends DialogFragment {
    private static SimpleDialogFragment instance;
    private ViewPager bViewPager;

    public static SimpleDialogFragment instance() {
        if (instance == null)
            instance = new SimpleDialogFragment();
        return instance;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.simple_dialog_fragment, null);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bViewPager =(ViewPager) view.findViewById(R.id.pager);


        bViewPager.setAdapter(new SimplePagerAdapter(getContext()));

//        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
//        indicator.setViewPager(bViewPager);




//        dialog = this;
//        sharedpreferences = dialog.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);;
//        mStartNow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                editor.putBoolean("isShowTutorialBusiness", true);
//                editor.commit();
//                dialog.dismiss();
//            }
//        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    public class SimplePagerAdapter extends PagerAdapter {
        private Context context;
        int layoutID[] =  {R.layout.dialog_fragment1, R.layout.dialog_fragment2};
        public SimplePagerAdapter(Context context) {
            this.context = context;
        }
        @Override
        public int getCount() {
            return layoutID.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            LayoutInflater inflater = LayoutInflater.from(context);
            ViewGroup layout = (ViewGroup) inflater.inflate(layoutID[position], collection, false);
            collection.addView(layout);
            return layout;
        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new Dialog(getActivity(), getTheme()) {
            @Override
            public void onBackPressed() {
                onBackPress();
            }
        };
    }
    private void onBackPress() {

    }

}
