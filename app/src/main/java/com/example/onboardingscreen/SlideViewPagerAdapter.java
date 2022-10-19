package com.example.onboardingscreen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_screen,container,false);


        ImageView logo=view.findViewById(R.id.logo);

        ImageView ind1=view.findViewById(R.id.ind1);
        ImageView ind2=view.findViewById(R.id.ind2);
        ImageView ind3=view.findViewById(R.id.ind3);
        ImageView ind4=view.findViewById(R.id.ind4);


        TextView title=view.findViewById(R.id.title);
        TextView desc=view.findViewById(R.id.desc);

        ImageView next=view.findViewById(R.id.next);
        ImageView back=view.findViewById(R.id.back);

        Button btnGetStarted=view.findViewById(R.id.btnGetStarted);
        Button btnGetStarted1 = view.findViewById(R.id.btnGetStarted1);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ctx,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position+1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position-1);
            }
        });

        switch (position)
        {
            case 0:
                logo.setImageResource(R.drawable.logo1);
                ind1.setImageResource(R.drawable.seleted);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);

                title.setText("Download Apps from Trusted Sources");
                desc.setText("Using unofficial apps put your personal information at risk and you could lose your personal data or money. Always download apps from AppStores/ Trusted sources");
                back.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                btnGetStarted.setVisibility(View.GONE);
                btnGetStarted1.setVisibility(View.GONE);
                break;
            case 1:
                logo.setImageResource(R.drawable.logo2);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.seleted);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);

                title.setText("Have Your Screen Locked");
                desc.setText("Avery basic tip that can keep your Device and Data from the reach bad guys");
                back.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                btnGetStarted.setVisibility(View.GONE);
                btnGetStarted1.setVisibility(View.GONE);
                break;
            case 2:
                logo.setImageResource(R.drawable.logo3);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.seleted);
                ind4.setImageResource(R.drawable.unselected);

                title.setText("Connect to Secure Wifi");
                desc.setText("Connect to a secure, private and Encrypted wifi network that lets you surf internet without the fear of hackers");
                back.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                btnGetStarted.setVisibility(View.GONE);
                btnGetStarted1.setVisibility(View.GONE);
                break;
            case 3:
                logo.setImageResource(R.drawable.logo4);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.seleted);

                title.setText("Implement 2FA");
                desc.setText("Use two factor authentication (2FA) to protect your login information and accounts so you don't need to worry about being hacked");
                back.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                btnGetStarted.setVisibility(View.VISIBLE);
                btnGetStarted1.setVisibility(View.VISIBLE);
                break;






        }


        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}
