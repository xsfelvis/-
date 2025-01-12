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

public class NiuPiXuan_Activity33 extends TabActivity{
	private String[] names = new String []
			{"进口蓝顶喷雾剂 牛皮癣外用 ","杜师傅银消灵 专业去牛皮癣纯中成药","中药外用银屑牛皮癣体股癣","勇博士癣除根辽宁博适皮博士牛皮癣"};
	private String[] descs = new String[]
			{"参考价格：¥298.0","参考价格：¥47.0","参考价格：¥28.0","参考价格：¥7.0"};
	private  int[] imageIds = new int[]
			{ R.drawable.niupixuan1,  R.drawable.niupixuan2,  R.drawable.niupixuan3,  R.drawable.niupixuan4};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_niupixuan);
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
        ListView list = (ListView) findViewById(R.id.lv_niupixuan_items);
//        为ListView设置Adapter
        list.setAdapter(simpleAdapter);   
	
	}

	
}
