package com.example.siwei.s4;



        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;
        import java.io.BufferedInputStream;
        import java.io.BufferedOutputStream;
        import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.nio.charset.Charset;
        import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String FNAME = "shijian4";



        Button b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                OutputStream out = null;
                try {
                    FileOutputStream f = openFileOutput(FNAME,MODE_PRIVATE);
                    out = new BufferedOutputStream(f);
                    String xinxi = "学号:2015011310 姓名:司伟";
                    try{
                        out.write(xinxi.getBytes(StandardCharsets.UTF_8));
                    }
                    finally {
                        if(out!=null)
                            out.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    FileInputStream f2 = openFileInput(FNAME);
                    InputStreamReader in = new InputStreamReader(f2,"UTF-8");
                    BufferedReader s = new BufferedReader(in);
                    String l;
                    try{
                        while ((l=s.readLine())!=null){
                            Toast.makeText(MainActivity.this,l.toString(),Toast.LENGTH_LONG).show();
                        }
                        s.close();
                        in.close();
                    }
                    finally {
                        if(f2!=null){
                            try{
                                f2.close();
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
