package demo.ma390104.customlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 2015/7/18.
 */
public class ItemAdapter extends BaseAdapter {

    private ArrayList<Item> items;
    private LayoutInflater inflater;

    public ItemAdapter(Context c, ArrayList<Item> items){
        this.items = items;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //載入原先設計的 Layout
        if(convertView==null){
            convertView = inflater.inflate(R.layout.item, null);
        }
        ImageView imvItemPic = (ImageView)convertView.findViewById(R.id.imvItemPic);
        TextView txvItemTitle = (TextView)convertView.findViewById(R.id.txvItemTitle);

        //將資料填入Layout
        Item target = items.get(position); //取出目前要處理的 Item
        imvItemPic.setImageResource(target.picRes);
        txvItemTitle.setText(target.title);

        return convertView;
    }
}
