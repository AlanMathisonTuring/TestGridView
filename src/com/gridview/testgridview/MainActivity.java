package com.gridview.testgridview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private int[] images ={
			R.drawable.a,R.drawable.b,
			R.drawable.c,R.drawable.d,
			R.drawable.e,R.drawable.f,
			R.drawable.g,R.drawable.h,
			R.drawable.i
	};
	private String[] tittles ={
			"PIC_1","PIC_2",
			"PIC_3","PIC_4",
			"PIC_5","PIC_6",
			"PIC_7","PIC_8",
			"PIC_9",
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GridView gv = (GridView)this.findViewById(R.id.GridView1);
		//gv.setAdapter(new MyAdapter());
		
		
		gv.setAdapter(new PictureAdapter(
				tittles, images, this
				));
		
		 //注册监听事件 
        gv.setOnItemClickListener(new OnItemClickListener() 
        { 
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            { 
                Toast.makeText(MainActivity.this, "pic" + position, Toast.LENGTH_SHORT).show(); 
            } 
        });
	}

	public class MyAdapter extends BaseAdapter{

		private Integer[] imgs ={
				R.drawable.a,R.drawable.b,
				R.drawable.c,R.drawable.d,
				R.drawable.e,R.drawable.f,
				R.drawable.g,R.drawable.h,
				R.drawable.i
		};
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imgs.length;
		}

		@Override
		public Object getItem(int item) {
			// TODO Auto-generated method stub
			return item;
		}

		@Override
		public long getItemId(int id) {
			// TODO Auto-generated method stub
			return id;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageView;
			if(convertView == null){
				imageView = new ImageView(MainActivity.this);
				 imageView.setLayoutParams(new GridView.LayoutParams(170, 170));//设置ImageView对象布局
				 imageView.setAdjustViewBounds(false);//设置边界对齐 
                 imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//设置刻度的类型 
                 imageView.setPadding(8, 8, 8, 8);//设置间距 
			}else{
				 imageView = (ImageView) convertView; 
			}
			imageView.setImageResource(imgs[position]);//为ImageView设置图片资源 
            return imageView; 
		}
		
	}
	
	//自定义适配器 
	public class PictureAdapter extends BaseAdapter{ 
	    private LayoutInflater inflater; 
	    private List<Picture> pictures; 
	 
	    public PictureAdapter(String[] titles, int[] images, Context context) 
	    { 
	        super(); 
	        pictures = new ArrayList<Picture>(); 
	        inflater = LayoutInflater.from(context); 
	        for (int i = 0; i < images.length; i++) 
	        { 
	            Picture picture = new Picture(titles[i], images[i]); 
	            pictures.add(picture); 
	        } 
	    } 
	 
	    @Override
	    public int getCount() 
	    { 
	        if (null != pictures) 
	        { 
	            return pictures.size(); 
	        } else
	        { 
	            return 0; 
	        } 
	    } 
	 
	    @Override
	    public Object getItem(int position) 
	    { 
	        return pictures.get(position); 
	    } 
	 
	    @Override
	    public long getItemId(int position) 
	    { 
	        return position; 
	    } 
	 
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) 
	    { 
	        ViewHolder viewHolder; 
	        if (convertView == null) 
	        { 
	            convertView = inflater.inflate(R.layout.grid_item, null); 
	            viewHolder = new ViewHolder(); 
	            viewHolder.title = (TextView) convertView.findViewById(R.id.title); 
	            viewHolder.image = (ImageView) convertView.findViewById(R.id.image); 
	            convertView.setTag(viewHolder); 
	        } else
	        { 
	            viewHolder = (ViewHolder) convertView.getTag(); 
	        } 
	        viewHolder.title.setText(pictures.get(position).getTitle()); 
	        viewHolder.image.setImageResource(pictures.get(position).getImageId()); 
	        return convertView; 
	    } 
	 
	} 
	
	public class ViewHolder 
	{ 
	    public TextView title; 
	    public ImageView image; 
	} 
	 
	public class Picture 
	{ 
	    private String title; 
	    private int imageId; 
	 
	    public Picture() 
	    { 
	        super(); 
	    } 
	 
	    public Picture(String title, int imageId) 
	    { 
	        super(); 
	        this.title = title; 
	        this.imageId = imageId; 
	    } 
	 
	    public String getTitle() 
	    { 
	        return title; 
	    } 
	 
	    public void setTitle(String title) 
	    { 
	        this.title = title; 
	    } 
	 
	    public int getImageId() 
	    { 
	        return imageId; 
	    } 
	 
	    public void setImageId(int imageId) 
	    { 
	        this.imageId = imageId; 
	    } 
	} 

}
