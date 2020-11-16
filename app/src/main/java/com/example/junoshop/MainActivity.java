package com.example.junoshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.net.TelephonyNetworkSpecifier;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.junoshop.Adapter.AdapterSanPham;
import com.example.junoshop.Adapter.Adapterdrawer;
import com.example.junoshop.Model.Drawermenu;
import com.example.junoshop.Model.ItemSanPham;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar tb_main;
    NavigationView navi_main;
    DrawerLayout drawer;
    SearchView searchView;
    RecyclerView rv_sanpham;
    AdapterSanPham adapterSanPham;
    Adapterdrawer adapterdrawer;
    RecyclerView rv_drawermenu;
    String url_sp= "http://192.168.2.104:8080/junoshop/public/get_sanpham1";

    ArrayList<ItemSanPham> sanPhams= new ArrayList<ItemSanPham>();
    ArrayList<Drawermenu> drawermenuArrayList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        menu();
        displayitem();
        Actionbar();
        CatchOnEvent();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void Actionbar(){
        setSupportActionBar(tb_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tb_main.setNavigationIcon(R.drawable.ic_menu);
        tb_main.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }
    public void anhxa(){
        tb_main= findViewById(R.id.tb_main);
        navi_main= findViewById(R.id.navi_main);
        drawer=findViewById(R.id.drawer);
    }
    public void CatchOnEvent(){
        sanPhams = new ArrayList<>();
        adapterSanPham= new AdapterSanPham(this, sanPhams);
        adapterSanPham.notifyDataSetChanged();
    }
    public void menu(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rv_drawermenu.setLayoutManager(linearLayoutManager);
            drawermenuArrayList.add(new Drawermenu("Trang Chủ",R.drawable.ic_home));
            drawermenuArrayList.add(new Drawermenu("Túi Xách",R.drawable.ic_bag));
            drawermenuArrayList.add(new Drawermenu("Giày Dép",R.drawable.ic_shoes));
            drawermenuArrayList.add(new Drawermenu("Giỏ Hàng",R.drawable.ic_shopingcart));
            drawermenuArrayList.add(new Drawermenu("Cá Nhân",R.drawable.ic_person2));
            adapterdrawer = new Adapterdrawer(getApplicationContext(), drawermenuArrayList);
            rv_drawermenu.setAdapter(adapterdrawer);
    }

    public void displayitem(){
        sanPhams = new ArrayList<>();
        adapterSanPham = new AdapterSanPham(this,sanPhams);
        adapterSanPham.notifyDataSetChanged();
        rv_sanpham.setLayoutManager(new GridLayoutManager(this,2));
        rv_sanpham.setAdapter(adapterSanPham);
        getdata1();
    }
    public void getdata1(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url_sp, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int ID = 0;
                    String Ten = "";
                    String Link = "";
                    String Gia = "";
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            Ten = jsonObject.getString("tensanpham");
                            Link = jsonObject.getString("hinhsanpham");
                            Gia = jsonObject.getString("giasanpham");
                            sanPhams.add(new ItemSanPham(ID, Ten, Link, Gia));
                        } catch (JSONException e) {
                            Log.d("Exception", e.getMessage());
                            e.printStackTrace();
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("listarray", sanPhams.size() + "");
                            adapterSanPham.notifyDataSetChanged();
                        }
                    });
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Volley Error",Toast.LENGTH_SHORT).show();
                Log.d("loi",error.toString());
            }
        });
    requestQueue.add(request);
    }
}