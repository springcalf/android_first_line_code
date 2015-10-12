package com.example.administrator.listviewtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
    private String[] data = { "Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };
            */
    private  List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);

        ListView listView = (ListView)findViewById(R.id.list_view2);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private  void  initFruits()
    {
        Fruit apple = new Fruit("apple",R.mipmap.ic_launcher);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana",R.mipmap.ic_launcher);
        fruitList.add(banana);
        Fruit orange = new Fruit("orange",R.mipmap.ic_launcher);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon",R.mipmap.ic_launcher);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear",R.mipmap.ic_launcher);
        fruitList.add(pear);
        Fruit grape = new Fruit("Grape",R.mipmap.ic_launcher);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("Pineapple",R.mipmap.ic_launcher);
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit("Strawberry",R.mipmap.ic_launcher);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("Cherry",R.mipmap.ic_launcher);
        fruitList.add(cherry);
    }

    /**
     * Created by Administrator on 2015/10/11.
     */
    public static class Fruit {
        private  String name;
        private  int imgId;

        public Fruit(String name,int imgId  )
        {
            this.imgId = imgId;
            this.name = name;
        }
        public  String getName()
        {
            return  name;
        }
        public  int getImgId()
        {
            return  imgId;
        }
    }

    /**
     * Created by Administrator on 2015/10/11.
     */
    public static class FruitAdapter extends ArrayAdapter<Fruit> {
        private  int resourceID;
        public FruitAdapter(Context context,int textViewResourceID,List<Fruit> Objects)
        {
            super(context,textViewResourceID,Objects);
            resourceID = textViewResourceID;
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent)
        {
            Fruit fruit = getItem(position);
            View view ;
            ViewHolder viewHolder;
            if (convertView == null)
            {
                view= LayoutInflater.from(getContext()).inflate(resourceID, null);
                viewHolder = new ViewHolder();
                viewHolder.fruit_image = (ImageView)view.findViewById(R.id.fruit_image);
                viewHolder.fruit_name = (TextView)view.findViewById(R.id.fruit_name);
                view.setTag(viewHolder);
            }
            else
            {
                view = convertView;
                viewHolder = (ViewHolder)view.getTag();
            }


            viewHolder.fruit_image.setImageResource(fruit.getImgId());
            viewHolder.fruit_name.setText(fruit.getName());
            return  view;
        }

        class  ViewHolder
        {
            ImageView fruit_image;
            TextView fruit_name;
        }
    }
}
