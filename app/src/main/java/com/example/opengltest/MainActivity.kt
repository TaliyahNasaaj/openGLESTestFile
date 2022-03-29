package com.example.opengltest

import android.app.Activity
import android.content.Context
import android.opengl.GLSurfaceView
import android.os.Bundle
import android.os.SystemClock.currentThreadTimeMillis
import android.os.SystemClock.uptimeMillis
import android.view.MotionEvent


class MyGLSurfaceView(context: Context) : GLSurfaceView(context){
    private val renderer: MyGLRenderer

    init {
        setEGLContextClientVersion(2)
        renderer = MyGLRenderer()
        setRenderer(renderer)
    }

}

class MainActivity : Activity() {
    //Inits a gLView object which extends the GLSurfaceView class
    lateinit var gLView: GLSurfaceView

    public override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        //Creates a GL Surface View and sets it as the
        //ContentView for this activity
        gLView = MyGLSurfaceView(this)
        setContentView(gLView)
    }
}

