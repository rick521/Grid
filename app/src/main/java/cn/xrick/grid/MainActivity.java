package cn.xrick.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.mtjsoft.www.gridviewpager_recycleview.GridViewPager;

public class MainActivity extends AppCompatActivity {
    private String[] titles = {"美食", "电影", "酒店住宿","美食", "电影", "酒店住宿"};
    private int[] iconS = {R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridViewPager gridViewPager = findViewById(R.id.gridviewpager);
        gridViewPager
                // 设置数据总数量
                .setDataAllCount(titles.length)
                // 设置背景图片(此时设置的背景色无效，以背景图片为主)
                // 数据绑定
                .setImageTextLoaderInterface(new GridViewPager.ImageTextLoaderInterface() {
                    @Override
                    public void displayImageText(ImageView imageView, TextView textView, int position) {
                        // 自己进行数据的绑定，灵活度更高，不受任何限制
                        imageView.setImageResource(iconS[position]);
                        textView.setText(titles[position]);
                    }
                })
                // Item点击
                .setGridItemClickListener(new GridViewPager.GridItemClickListener() {
                    @Override
                    public void click(int position) {
                        Toast.makeText(getBaseContext(), "点击了" + titles[position] + position, Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

}