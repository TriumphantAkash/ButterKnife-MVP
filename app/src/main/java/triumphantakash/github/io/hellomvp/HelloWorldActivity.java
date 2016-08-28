package triumphantakash.github.io.hellomvp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class HelloWorldActivity extends MvpActivity<HelloWorldView, HelloWorldPresenter>
        implements HelloWorldView {

    @InjectView(R.id.greetingTextView)
    TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.activity_hello_world);
        ButterKnife.inject(this);
    }

    @Override // Called internally by Mosby
    public HelloWorldPresenter createPresenter(){
        return new HelloWorldPresenter();
    }

    @OnClick(R.id.helloButton)
    public void onHelloButtonClicked(){
        presenter.greetHello();
    }

    @OnClick(R.id.goodbyeButton)
    public void onGoodbyeButtonClicked(){
        presenter.greetGoodbye();
    }

    @Override
    public void showHello(String greetingText){
        greetingTextView.setTextColor(Color.RED);
        greetingTextView.setText(greetingText);
    }

    @Override
    public void showGoodbye(String greetingText){
        greetingTextView.setTextColor(Color.BLUE);
        greetingTextView.setText(greetingText);
    }
}
