package demo.ma390104.customlayout;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    private ListView cListView;
    private ArrayList<Item> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
        findViews();
        setListeners();
    }

    private void findViews(){
        cListView = (ListView)findViewById(R.id.lsvCList);
        //adapter作為ListView與資料之間的串接
        ItemAdapter adapter = new ItemAdapter(this.getApplicationContext(), data);
        cListView.setAdapter(adapter);
    }

    private void setListeners(){
        cListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item target = data.get(i);
                showCustomDialog(getString(R.string.strCurrentSelected) + target.title);
            }
        });
    }

    /* 載入Demo資料 */
    private void loadData(){
        data = new ArrayList<Item>();
        data.add(new Item("第1個Item", R.mipmap.ic_launcher));
        data.add(new Item("第2個Item", R.mipmap.ic_launcher));
        data.add(new Item("第3個Item", R.mipmap.ic_launcher));
        data.add(new Item("第4個Item", R.mipmap.ic_launcher));
        data.add(new Item("第5個Item", R.mipmap.ic_launcher));
        data.add(new Item("第6個Item", R.mipmap.ic_launcher));
        data.add(new Item("第7個Item", R.mipmap.ic_launcher));
        data.add(new Item("第8個Item", R.mipmap.ic_launcher));
        data.add(new Item("第9個Item", R.mipmap.ic_launcher));
        data.add(new Item("第10個Item", R.mipmap.ic_launcher));
    }

    /* 顯示自定義Layout的Dialog */
    private void showCustomDialog(String msg){
        //準備自定義的 View
        LayoutInflater inflater = getLayoutInflater();
        View customView = inflater.inflate(R.layout.dialog, null);
        ImageView imvDialogPic = (ImageView)customView.findViewById(R.id.imvDialogPic);
        TextView txvDialogMsg = (TextView)customView.findViewById(R.id.txvDialogMsg);

        imvDialogPic.setImageResource(R.mipmap.ic_launcher);
        txvDialogMsg.setText(msg);

        //將自定義View填入Dialog, 並完成其他參數設定
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.strTips));
        builder.setView(customView);

        builder.create().show();
    }

}
