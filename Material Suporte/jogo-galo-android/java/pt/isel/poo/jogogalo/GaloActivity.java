package pt.isel.poo.jogogalo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import pt.isel.leic.poo.jogogalo.R;
import pt.isel.poo.ResultActivity;
import pt.isel.poo.jogogalo.model.Piece;
import pt.isel.poo.jogogalo.model.TicTacToeModel;
import pt.isel.poo.view.CircleView;
import pt.isel.poo.view.CrossView;
import pt.isel.poo.view.tile.OnBeatListener;
import pt.isel.poo.view.tile.OnTileTouchListener;
import pt.isel.poo.view.tile.TilePanel;

public class GaloActivity
        extends Activity
        implements OnTileTouchListener
{

    public static final String WINNER = "WINNER";
    TicTacToeModel model;
    TilePanel panel;
    TextView nextPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galo);

        model = new TicTacToeModel(true);

        nextPlayer = findViewById(R.id.nextplayer);
        nextPlayer.setText(model.getNextMoveString());

        panel = findViewById(R.id.panel);
        panel.setListener(this);
    }

    private void clearPanel() {
        for (int lin=0; lin < panel.getHeightInTiles(); ++lin) {
            for (int col=0; col < panel.getWidthInTiles(); ++col) {
                panel.setTile(col, lin, null);
            }
        }
    }

    @Override
    public void onRestart() {
        super.onRestart();
        model.reset(true);
        clearPanel();
        nextPlayer.setText(model.getNextMoveString());
    }

    @Override
    public boolean onClick(int xTile, int yTile) {
        if (!model.touch(yTile, xTile))
            return false;
        Piece played = model.getPiece(yTile,xTile);

        // update piece view
        if (played == Piece.CROSS)
            panel.setTile(xTile, yTile, new CrossView(this));
        else
            panel.setTile(xTile, yTile, new CircleView(this));

        // update next move
        nextPlayer.setText(model.getNextMoveString());

        // check game overall state
        TicTacToeModel.State state = model.getState();
        if (state != TicTacToeModel.State.Run) {
            // start new activity with winner information
            Intent intent = new Intent(
                    this,
                    ResultActivity.class);
            intent.putExtra(WINNER, played.toString());
            startActivity(intent);
            /*
            String msg;
            msg = state == TicTacToeModel.State.Win ?
                    played.toString()+" wins!" :
                    "Its a Tie!";
            Toast victory = Toast.makeText(
                    this,
                    msg,
                    Toast.LENGTH_LONG);
            victory.show();
            panel.setHeartbeatListener(500,
                    new OnBeatListener() {
                        @Override
                        public void onBeat(long beat, long time) {
                            panel.removeHeartbeatListener();
                            clearPanel();
                            model.reset();
                        }
                    });
             */
        }
        return false;
    }

    @Override
    public boolean onDrag(int xFrom, int yFrom, int xTo, int yTo) {
        return false;
    }

    @Override
    public void onDragEnd(int x, int y) {

    }

    @Override
    public void onDragCancel() {

    }
}
