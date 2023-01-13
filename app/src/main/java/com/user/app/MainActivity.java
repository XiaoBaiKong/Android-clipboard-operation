package com.user.app;

import android.app.*;
import android.widget.EditText;
import android.widget.Button;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.text.TextUtils;

public class MainActivity extends Activity 
{
    //声明组件
    private EditText Text_content;
    private Button copy;
    private Button paste;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //获取组件
        Text_content = (EditText) findViewById(R.id.Text_content);
        copy = (Button) findViewById(R.id.copy);
        paste = (Button) findViewById(R.id.paste);
        
    }
    //复制按钮被单击
    public void copy_onClick(View v) {
        String ss = Text_content.getText().toString();
        copy_text(this,ss);
    }
    //粘贴按钮被单击
    public void paste_onClick(View v) {
        paste_text();
    }
    //复制（将编辑框里面的内容复制到剪切板）
    public void copy_text(Context Cont,String text) {
        ClipboardManager clipboard = (ClipboardManager) this.getSystemService("clipboard");
		clipboard.setText(text);
    }
    //粘贴（获取剪贴板上的内容并填入编辑框）
    public void paste_text() {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        CharSequence text = clipboardManager.getText();
        if (TextUtils.isEmpty(text)) {
            Toast.makeText(this,"The clipboard is empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        Text_content.setText(text);
    }
}