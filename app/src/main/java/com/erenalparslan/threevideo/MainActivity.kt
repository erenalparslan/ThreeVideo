package com.erenalparslan.threevideo

import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.LinearLayout
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var playerPosition: Long = 0
    private var KEY_PLAYER_PLAY_WHEN_READY = null
    private var player: ExoPlayer? = null
    private var player1: ExoPlayer? = null
    private var player2: ExoPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val mediaItem = MediaItem.fromUri(Uri.parse(URL))

        /*if(savedInstanceState!=null){

            playerPosition = savedInstanceState.getLong("position")

            player?.seekTo(playerPosition)
            player?.playWhenReady = true
            player1?.seekTo(playerPosition)
            player1?.playWhenReady = true
            player2?.seekTo(playerPosition)
            player2?.playWhenReady = true
        }*/

        initPlayer()

        playerSetter(player!!, mediaItem)
        playerSetter(player1!!, mediaItem)
        playerSetter(player2!!, mediaItem)


    }




   /* override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("position", player?.currentPosition!!)
    }*/



 /*   override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        playerPosition = player?.currentPosition!!
        TODO=return activity without refreshing

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_land)

        }
        // Ekran dikey konuma döndüğünde
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main)
        }
            //initPlayer()
    }*/


    fun playerSetter(player: ExoPlayer, mediaItem: MediaItem) {
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    fun initPlayer() {
        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        player1 = ExoPlayer.Builder(this).build()
        playerView1.player = player1

        player2 = ExoPlayer.Builder(this).build()
        playerView3.player = player2



    }


    companion object {
        const val URL =
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    }
}