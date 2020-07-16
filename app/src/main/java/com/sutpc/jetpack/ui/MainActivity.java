package com.sutpc.jetpack.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.sutpc.jetpack.R;
import com.sutpc.jetpack.repo.viewModel.VerySimpleViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button)
    Button button;
    private VerySimpleViewModel verySimpleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        testVerySimpleVM();
    }

    /** *
     * 测试最简单的VM，屏幕旋转时数据可保存
     */
    private void testVerySimpleVM(){
        //获取VerySimpleViewModel 需要引入  'androidx.lifecycle:lifecycle-extensions:2.2.0'
        verySimpleViewModel = new ViewModelProvider(this).get(VerySimpleViewModel.class);
        button.setOnClickListener(view -> {
            verySimpleViewModel.num ++ ;
            textView.setText( "测试最简单的VM：" + verySimpleViewModel.num);
        });
    }
}
