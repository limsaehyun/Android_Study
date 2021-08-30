package com.example.chatapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.data.Chat;
import com.example.chatapp.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Chat> mDataset;

    private String stMyEmail;

    // 각 데이터 항목의 뷰에 대한 참조 제공
    // 복잡한 데이터 항목에는 항목당 두 개 이상의 보기가 필요할 수 있습니다.
    // 뷰 홀더의 데이터 항목에 대한 모든 뷰에 대한 액세스를 제공합니다.
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // 여기서 각 데이터 항목은 문자열 입니다
        public TextView textView;
        public MyViewHolder(View v) {
            super(v);
            textView =v.findViewById(R.id.tv_chat);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if(mDataset.get(position).getEmail().equals(stMyEmail)) {
            return 1;
        } else {
            return 2;
        }
//        return super.getItemViewType(position);
    }

    // 적절한 생성자(데이터 세트의 종류)를 제공한다.
    public MyAdapter(ArrayList<Chat> myDataset, String stEmail) {
       mDataset = myDataset;
       this.stMyEmail = stEmail;
    }

    // 새로운 뷰 생성
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // 새로운 뷰 생성
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        if(viewType == 1) {
            v =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.right_text_view, parent, false);
        }
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // 뷰의 내용 바꾸기(레이아웃 관리자에서 호출)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - 이 위치의 데이터 집합에서 요소 가져오기
        // - 뷰의 내용을 해당 요소로 바꿉니다.
        holder.textView.setText(mDataset.get(position).getText());

    }

    // data을 리턴합니다.
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
