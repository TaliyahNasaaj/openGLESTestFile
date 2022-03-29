package com.example.opengltest
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

import android.opengl.GLES32
import android.opengl.GLSurfaceView
import android.os.SystemClock.currentThreadTimeMillis
import android.util.Log
import kotlin.math.PI
import kotlin.math.sin

var uptime = currentThreadTimeMillis()

class MyGLRenderer : GLSurfaceView.Renderer {
    override fun onSurfaceCreated(unused: GL10, config: EGLConfig) {
        // Set the background frame color
        GLES32.glClearColor(1.0f, 0.0f, 1.0f, 0.0f)
    }


    override fun onDrawFrame(unused: GL10) {
        uptime = currentThreadTimeMillis()
        Log.i("MainActivity","Current Uptime is: $uptime")
        GLES32.glClearColor(sin(uptime*PI/30).toFloat(), sin(uptime*PI/20).toFloat(), 1.0f, 1.0f)
        GLES32.glClear(GLES32.GL_COLOR_BUFFER_BIT)
        // Redraw background color
    }

    override fun onSurfaceChanged(unused: GL10, width: Int, height: Int) {
        GLES32.glViewport(0, 0, width, height)
    }
}