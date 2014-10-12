/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hellojni;

import java.io.File;

import com.os1.util.jpegThumb.JpegThumb;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Environment;


public class HelloJni extends Activity
{
	public static final String TAG = "HelloJni";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /* Create a TextView and set its content.
         * the text is retrieved by calling a native
         * function.
         */
        
        setContentView(R.layout.activity_main);
        TextView  tv = (TextView) findViewById(R.id.textView1);
        tv.setText( JpegThumb.getLibraryInfo() );
        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				doThumb();
				
			}
        	
        });
        
    }
    private void doThumb(){
    	File sdcardDir = Environment.getExternalStorageDirectory();  
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){  
           //得到一个路径，内容是sdcard的文件夹路径和名字   
            String path = sdcardDir.getPath();   //得到/sdcard/profitData的路径   




            Log.d(TAG, "path:"+path);
            int status = JpegThumb.jpegThumbFile(path+"/1.jpg",path+"/1.thumb.jpg",800,600,90);
            Log.d(TAG, "status"+status);
                
            }  
    }

}
