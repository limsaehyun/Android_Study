package com.example.chatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private ArrayList<User> mDataset;

    String stMyEmail;

    // 각 데이터 항목의 뷰에 대한 참조 제공
    // 복잡한 데이터 항목에는 항목당 두 개 이상의 보기가 필요할 수 있습니다.
    // 뷰 홀더의 데이터 항목에 대한 모든 뷰에 대한 액세스를 제공합니다.
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // 여기서 각 데이터 항목은 문자열 입니다
        public TextView tvUser;
        public ImageView ivUser;

        public MyViewHolder(View v) {
            super(v);
            tvUser =v.findViewById(R.id.tvUser);
            ivUser =v.findViewById(R.id.ivUser);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    // 적절한 생성자(데이터 세트의 종류)를 제공한다.
    public UserAdapter(ArrayList<User> myDataset, String stEmail) {
       mDataset = myDataset;
       this.stMyEmail = stEmail;
    }

    // 새로운 뷰 생성
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // 새로운 뷰 생성
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_text_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // 뷰의 내용 바꾸기(레이아웃 관리자에서 호출)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - 이 위치의 데이터 집합에서 요소 가져오기
        // - 뷰의 내용을 해당 요소로 바꿉니다.
        holder.tvUser.setText(mDataset.get(position).getEmail());
        holder.tvUser.setText(mDataset.get(position).getEmail());

    }

    // data을 리턴합니다.
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
