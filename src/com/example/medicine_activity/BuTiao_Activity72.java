package com.example.medicine_activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.TabActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

import com.example.assistant.R;

public class BuTiao_Activity72 extends TabActivity{
	private String[] names = new String []
			{"四物汤袋泡茶 百岁门四物汤 月经不调闭经痛经","四物汤袋泡茶 同仁堂中药材原料 补气补血月经不调推迟闭经止痛经 ","四物汤袋泡茶 四物饮月经不调闭经","宫寒不孕 月经不调痛经 流产孕前滋补膏 "};
	private String[] descs = new String[]
			{"参考价格：¥19.9","参考价格：¥28.9","参考价格：¥19.0","参考价格：¥399.0"};
	private  int[] imageIds = new int[]
			{ R.drawable.butiao1,  R.drawable.butiao2,  R.drawable.butiao3,  R.drawable.butiao4};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_butiao);
		//获取Activity中的TabHost组件
		TabHost tabHost = getTabHost();
		//创建第一个Tab页
		TabSpec tab1 = tabHost.newTabSpec("tab1")
				.setIndicator("症状及措施")    //设置标题
				.setContent(R.id.tab01);  //设置内容
		//添加第二个标签页
		tabHost.addTab(tab1);
		
		TabSpec tab2 = tabHost.newTabSpec("tab2")
				.setIndicator("推荐药品")    //设置标题
				.setContent(R.id.tab02);  //设置内容
		//添加第二个标签页
		tabHost.addTab(tab2);
		//修改选项卡标签格式
				for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++)  
				{  
				    TextView textView = (TextView)tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);  
				    textView.setTextSize(25);  
				    textView.setGravity(Gravity.CENTER);  
				    textView.getLayoutParams().height = LayoutParams.MATCH_PARENT;  
				    textView.getLayoutParams().width = LayoutParams.MATCH_PARENT; 
				}
		
		List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for(int i=0; i<names.length;i++){
        	Map<String,Object> listItem = new HashMap<String,Object>();
        	listItem.put("header",imageIds[i]);
        	listItem.put("personName",names[i]);
        	listItem.put("desc",descs[i]);
        	listItems.add(listItem);
        }
//        创建一个simpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.medicine_item,
        		new String[] {"personName","header","desc"},
        		//new String[] {"personName","header"},
        		new int[] {R.id.name,R.id.header,R.id.desc});
        		//new int[] {R.id.name,R.id.header});
        ListView list = (ListView) findViewById(R.id.lv_butiao_items);
//        为ListView设置Adapter
        list.setAdapter(simpleAdapter);   
	
	}

}
