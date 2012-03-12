package asgard.weapon.mapDisplay;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ZoomControls;
import asgard.weapon.R;
import asgard.weapon.map.*;
/**
 * 
 * @author Adam
 * 
 * 
 */
public class MapDisplay extends Activity implements OnClickListener {
	private static ImageView mapDisplay;
	private Button searchButton;
	private Button nextMapButton;
	private MapImageView mapScreen;
	private MapControl control;
	private ZoomControls zoomButton;
	public MapDisplay() {
		super();
		control = new MapControl(this);
		
	}
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mapScreen = new MapImageView(this);
        setContentView(R.layout.maplayout);
        //setContentView(R.layout.mainmap);
        //mapDisplay = (ImageView)this.findViewById(R.id.mapDisplay);
        mapScreen = (MapImageView)this.findViewById(R.id.mapImageView1);
        mapScreen.setImage(R.drawable.seb0);
        mapScreen.scale(0.5);
        
        searchButton =(Button) this.findViewById(R.id.button1);
        searchButton.setOnClickListener(this);
        
        nextMapButton = (Button) this.findViewById(R.id.btnNextMap);
        nextMapButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				control.nextMap();				
			}
        	
        });
        
        zoomButton = (ZoomControls)this.findViewById(R.id.zoomControls1);
        zoomButton.setOnZoomInClickListener(new OnClickListener() {
        	public void onClick(View v)
        	{
        		mapScreen.scale(1.5);
        	}
        });
        zoomButton.setOnZoomOutClickListener(new OnClickListener() {
        	public void onClick(View v)
        	{
        		mapScreen.scale(0.5);
        	}
        });
        
   }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		control.mapGetNodes();
		
	}
	public void drawNodes(Node[] n)
	{
		mapScreen.drawNodes(n);
	}
	public void updateMap(int resource)
	{
		mapScreen.setImage(resource);
	}

}
