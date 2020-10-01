package com.thcloc.gamebaicao_17041281;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Custom_Adapter_BangDiem extends BaseAdapter {
    private Context context;
    private List<KetQuaChoi> KetQuaChois;
    private int layout;

    public Custom_Adapter_BangDiem(Context context, List<KetQuaChoi> ketQuaChois, int layout) {
        this.context = context;
        KetQuaChois = ketQuaChois;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return KetQuaChois.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txtGame_Index = (TextView) convertView.findViewById(R.id.txtGame_Index);
        TextView txtName_Player01 = (TextView) convertView.findViewById(R.id.txtName_Player01);
        TextView txtName_Player02 = (TextView) convertView.findViewById(R.id.txtName_Player02);
        TextView txtValue_Player01 = (TextView) convertView.findViewById(R.id.txtValue_Player01);
        TextView txtValue_Player02 = (TextView) convertView.findViewById(R.id.txtValue_Player02);

        txtGame_Index.setText("Game " + Integer.toString(KetQuaChois.get(position).getGame_Index()));

        txtName_Player01.setText(KetQuaChois.get(position).getName_Player01());
        txtName_Player02.setText(KetQuaChois.get(position).getName_Player02());

        txtValue_Player01.setText(Integer.toString(KetQuaChois.get(position).getScore_Player01()));
        txtValue_Player02.setText(Integer.toString(KetQuaChois.get(position).getScore_Player02()));

        //Hoà
        if(KetQuaChois.get(position).getWinner() == 0){
            txtValue_Player01.setBackgroundResource(R.drawable.border_text_view_draw);
            txtValue_Player02.setBackgroundResource(R.drawable.border_text_view_draw);
        }

        //Player 01 Win
        if(KetQuaChois.get(position).getWinner() == 1){
            txtValue_Player01.setBackgroundResource(R.drawable.border_text_view_winner);
        }

        //Player 02 Win
        if(KetQuaChois.get(position).getWinner() == 2){
            txtValue_Player02.setBackgroundResource(R.drawable.border_text_view_winner);
        }

        return convertView;
    }
}
