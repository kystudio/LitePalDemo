package com.kotlin.litepaldemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.kotlin.litepaldemo.R;
import com.kotlin.litepaldemo.bean.Book;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_create).setOnClickListener(this);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_update).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        findViewById(R.id.btn_query).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create:
                Connector.getDatabase();
                break;
            case R.id.btn_add:
                book = new Book();
                book.setName("HelloWorld");
                book.setAuthor("kylin");
                book.setPrice(19.55);
                book.setPages(580);
                book.save();

                book = new Book();
                book.setName("HelloAndroid");
                book.setAuthor("kylin");
                book.setPrice(29.55);
                book.setPages(500);
                book.setPress("rmb");
                book.save();
                break;
            case R.id.btn_update:
                book = new Book();
                book.setName("HelloAndroid");
                book.setPrice(29.55);
                book.setPages(500);
                book.setPress("rmb");
                book.updateAll("id = ?", "2");
                break;
            case R.id.btn_delete:
                DataSupport.deleteAll(Book.class, "id = ?", "3");
                break;
            case R.id.btn_query:
                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book : books) {
                    Log.e("Book", "id:" + book.getId());
                    Log.e("Book", "name:" + book.getName());
                    Log.e("Book", "author:" + book.getAuthor());
                    Log.e("Book", "press:" + book.getPress());
                    Log.e("Book", "price:" + book.getPrice());
                    Log.e("Book", "pages:" + book.getPages());
                }
                break;
        }
    }
}
