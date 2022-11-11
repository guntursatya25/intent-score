package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    private String hometeam, awayteam, winner;
    private int homescore, awayscore;
    private TextView scoreHome, scoreAway;
    private TextView homeText, awayText;
    private ImageView homeLogo, awayLogo;
    private Button addHome1, addHome2, addHome3, addAway1,addAway2, addAway3, btnreset, cekResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        scoreHome = findViewById(R.id.score_home);
        scoreAway = findViewById(R.id.score_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
        addHome1 = findViewById(R.id.btn_add_home_1);
        addHome2 = findViewById(R.id.btn_add_home_2);
        addHome3 = findViewById(R.id.btn_add_home_3);
        addAway1 = findViewById(R.id.btn_add_away_1);
        addAway2 = findViewById(R.id.btn_add_away_2);
        addAway3 = findViewById(R.id.btn_add_away_3);
        cekResult = findViewById(R.id.btn_result);
        btnreset = findViewById(R.id.btn_reset);

        homescore = 0;
        awayscore = 0;
        scoreHome.setText(String.valueOf(homescore));
        scoreAway.setText(String.valueOf(awayscore));

        Bundle bundle = getIntent().getExtras();
        hometeam = bundle.getString("namahome");
        homeText.setText(hometeam);
        awayteam = bundle.getString("namaaway");
        awayText.setText(awayteam);
        homeLogo.setImageURI(Uri.parse(bundle.getString("homeImg")));
        awayLogo.setImageURI(Uri.parse(bundle.getString("awayImg")));

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore = 0;
                awayscore = 0;
                scoreHome.setText(String.valueOf(homescore));
                scoreAway.setText(String.valueOf(awayscore));
            }
        });

        addHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 1;
                scoreHome.setText(String.valueOf(homescore));
            }
        });

        addHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore +=2;
                scoreHome.setText(String.valueOf(homescore));
            }
        });
        addHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore +=3;
                scoreHome.setText(String.valueOf(homescore));
            }
        });

        addAway1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 1;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });
        addAway2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 2;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });
        addAway3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 3;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });

        cekResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                winner = "empty";
                if(homescore > awayscore){
                    winner = "Pemenang pertandingan "+hometeam;
                }
                else if (homescore == awayscore){
                    winner = "Hasil pertandingan draw";
                }
                else {
                    winner = "Pemenang pertandingan "+awayteam;
                }

                Intent intent = new Intent(MatchActivity.this, ResultActivity.class);
                intent.putExtra("winner", winner);
                startActivity(intent);
            }
        });


        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
