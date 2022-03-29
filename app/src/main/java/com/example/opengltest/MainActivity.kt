package com.example.opengltest

import android.app.Activity
import android.content.Context
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.os.Bundle
import android.os.SystemClock.currentThreadTimeMillis
import android.os.SystemClock.uptimeMillis
import android.util.Log
import android.view.MotionEvent
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder
import android.opengl.GLES32.glGetShaderInfoLog

import android.opengl.GLES32.GL_COMPILE_STATUS

import android.opengl.GLES32.glCompileShader

import android.opengl.GLES32.glShaderSource

import android.opengl.GLES32.glCreateShader
import android.opengl.GLES32


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