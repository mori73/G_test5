package jp.ac.kanto_pc.ohmori.g_test5;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

    private LineChart mChart;

    private EditText editText;
    private Button button;
    private TextView textView;

    int mode = 0;

    int mdata =7;


    int data1[] = new int[mdata];

    int data2[] = new int[mdata];

    int data3[] = new int[mdata];


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        /* アクションバーへの登録 （Android3.0以降） */
        MenuItem item1 = menu.add(1, 11, 0, "表示");
        item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);	// ALWAYS/IF_ROOM/NEVER
        MenuItem item2 = menu.add(1, 12, 0, "追加");
        item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        MenuItem item3 = menu.add(1, 13, 0, "グラフ");
        item3.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {

            case 11:
                setContentView(R.layout.activity_main);


                /****************************グラフ描画********************************/
                /**グラフ１**/
                if(mode == 1) {
                    mChart = findViewById(R.id.line_chart);

                    // Grid背景色
                    mChart.setDrawGridBackground(true);

                    // no description text
                    mChart.getDescription().setEnabled(false);


                    YAxis leftAxis = mChart.getAxisLeft();
                    // Y軸最大最小設定
                    leftAxis.setAxisMaximum(200f);
                    leftAxis.setAxisMinimum(0f);
                    // Grid横軸を破線
                    leftAxis.enableGridDashedLine(10f, 10f, 0f);
                    leftAxis.setDrawZeroLine(true);

                    // 右側の目盛り
                    mChart.getAxisRight().setEnabled(false);

                    // add data
                    setData1();

                    mChart.animateX(2500);


                    /**グラフ２**/
                    mChart = findViewById(R.id.line_chart2);

                    // Grid背景色
                    mChart.setDrawGridBackground(true);

                    // no description text
                    mChart.getDescription().setEnabled(false);

                    YAxis leftAxis2 = mChart.getAxisLeft();
                    // Y軸最大最小設定
                    leftAxis2.setAxisMaximum(200f);
                    leftAxis2.setAxisMinimum(0f);
                    // Grid横軸を破線
                    leftAxis2.enableGridDashedLine(10f, 10f, 0f);
                    leftAxis2.setDrawZeroLine(true);

                    // 右側の目盛り
                    mChart.getAxisRight().setEnabled(false);

                    // add data
                    setData2();

                    mChart.animateX(2500);


                    /**グラフ3**/
                    mChart = findViewById(R.id.line_chart3);

                    // Grid背景色
                    mChart.setDrawGridBackground(true);

                    // no description text
                    mChart.getDescription().setEnabled(false);

                    YAxis leftAxis3 = mChart.getAxisLeft();
                    // Y軸最大最小設定
                    leftAxis3.setAxisMaximum(200f);
                    leftAxis3.setAxisMinimum(0f);
                    // Grid横軸を破線
                    leftAxis3.enableGridDashedLine(10f, 10f, 0f);
                    leftAxis3.setDrawZeroLine(true);

                    // 右側の目盛り
                    mChart.getAxisRight().setEnabled(false);

                    // add data
                    setData3();

                    mChart.animateX(2500);
                }

                break;

            /****************************データ挿入********************************/
            case 12:
                setContentView(R.layout.activity_sub1);


                button = (Button) findViewById(R.id.button);
                textView = (TextView) findViewById(R.id.textView);


                textView.setText("変換");


                String str1 = "34,23,65,34,32,33,22";//読み込みファイル想定
                String str2 = "22,24,56,32,33,0,12";//読み込みファイル想定
                String str3 = "20,40,45,50,55,50,50";//読み込みファイル想定
                int j = 0;


                String[] tmp = str1.split(",");

                mdata = tmp.length;
                for (int i = 0; i < tmp.length; i++) {
                    j = Integer.parseInt(tmp[i]);
                    data1[i] = j;
                }



                tmp = str2.split(",");
                mdata = tmp.length;
                for (int i = 0; i < tmp.length; i++) {
                    j = Integer.parseInt(tmp[i]);
                    data2[i] = j;
                }



                tmp = str3.split(",");
                mdata = tmp.length;
                for (int i = 0; i < tmp.length; i++) {
                    j = Integer.parseInt(tmp[i]);
                    data3[i] = j;
                }



                textView.setText("更新");

                mode = 1;



                break;

            /****************************データリスト********************************/
            case 13:
                setContentView(R.layout.activity_sub2);
                break;
        }



        return true;
    }



    private void setData1() {
        // Entry()を使ってLineDataSetに設定できる形に変更してarrayを新しく作成


        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < data1.length; i++) {
            values.add(new Entry(i, data1[i], null, null));
        }

        LineDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {

            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "グラフ1");

            set1.setDrawIcons(false);
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.RED);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(0f);
            set1.setDrawFilled(false);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(0f);

            set1.setFillColor(Color.BLUE);

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData lineData = new LineData(dataSets);

            // set data
            mChart.setData(lineData);

        }

    }


    private void setData2() {
        // Entry()を使ってLineDataSetに設定できる形に変更してarrayを新しく作成


        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < data2.length; i++) {
            values.add(new Entry(i, data2[i], null, null));
        }

        LineDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {

            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "グラフ2");

            set1.setDrawIcons(false);
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.RED);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(0f);
            set1.setDrawFilled(false);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);

            set1.setFillColor(Color.BLUE);

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData lineData = new LineData(dataSets);

            // set data
            mChart.setData(lineData);

        }

    }



    private void setData3() {
        // Entry()を使ってLineDataSetに設定できる形に変更してarrayを新しく作成


        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < data3.length; i++) {
            values.add(new Entry(i, data3[i], null, null));
        }

        LineDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {

            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "グラフ3");

            set1.setDrawIcons(false);
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.RED);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(0f);
            set1.setDrawFilled(false);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);

            set1.setFillColor(Color.BLUE);

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData lineData = new LineData(dataSets);

            // set data
            mChart.setData(lineData);

        }

    }

}