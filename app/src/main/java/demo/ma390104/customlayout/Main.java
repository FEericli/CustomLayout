package demo.ma390104.customlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

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
    }

    private void findViews(){
        cListView = (ListView)findViewById(R.id.lsvCList);
        ItemAdapter adapter = new ItemAdapter(this.getApplicationContext(), data);
        cListView.setAdapter(adapter);
    }

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

}
