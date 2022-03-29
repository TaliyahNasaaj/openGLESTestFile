package com.example.opengltest
import android.content.Context
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

import android.opengl.GLES32
import android.opengl.GLSurfaceView
import android.os.SystemClock.currentThreadTimeMillis
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.PI
import kotlin.math.sin

var uptime = currentThreadTimeMillis()


class MyGLRenderer : GLSurfaceView.Renderer {

    //The functions below are from https://riptutorial.com/android/example/27036/compiling-and-linking-glsl-es-shaders-from-asset-file
    //It was originally in Java, but has been reworked into kotlin
    //Essentially it loads a shader text file into a string so that it can be compiled
    private fun loadStringFromAssetFile(myContext: Context, filePath: String): String? {
        val shaderSource = StringBuilder()
        //Uses a try so it can throw an error if a file cant be read properly
        return try {
            val reader = BufferedReader(InputStreamReader(myContext.assets.open(filePath)))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                shaderSource.append(line).append("\n")
            }
            reader.close()
            shaderSource.toString()
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("loadStringError", "Could not load shader file")
            null
        }
    }
    //This function takes the shader string and compiles it into a program object for use by OpenGL ES
    private fun compileShader(shader_type: Int, shaderString: String): Int {

        // This compiles the shader from the string
        val shader = GLES32.glCreateShader(shader_type)
        GLES32.glShaderSource(shader, shaderString)
        GLES32.glCompileShader(shader)

        // This checks for for compilation errors
        val compiled = IntArray(1)
        GLES32.glGetShaderiv(shader, GLES32.GL_COMPILE_STATUS, compiled, 0)
        if (compiled[0] == 0) {
            val log = GLES32.glGetShaderInfoLog(shader)
            Log.e("compileStringError", "Shader compilation error: ")
            Log.e("", log)
        }
        return shader
    }

    override fun onSurfaceCreated(unused: GL10, config: EGLConfig) {
        // Set the background frame color
        GLES32.glClearColor(1.0f, 0.0f, 1.0f, 0.0f)
        var shader: String? = loadStringFromAssetFile(, "my_fragment_shader.glsl")
        public var program =
    }

    override fun onDrawFrame(unused: GL10) {
        uptime = currentThreadTimeMillis()
        Log.i("INFOonDrawFrame","Current Uptime is: $uptime")
        GLES32.glClearColor(sin(uptime*PI/30).toFloat(), sin(uptime*PI/20).toFloat(), 1.0f, 1.0f)
        GLES32.glUseProgram()
        GLES32.glClear(GLES32.GL_COLOR_BUFFER_BIT)
        // Redraw background color
    }

    override fun onSurfaceChanged(unused: GL10, width: Int, height: Int) {
        GLES32.glViewport(0, 0, width, height)
    }
}