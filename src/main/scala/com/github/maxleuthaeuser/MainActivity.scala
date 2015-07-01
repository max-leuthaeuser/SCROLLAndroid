package com.github.maxleuthaeuser;

import scroll.internal.Compartment
import android.app.Activity
import android.os.Bundle
import android.widget.FrameLayout
import TypedResource._
import android.util.Log

class MainActivity extends Activity with TypedFindView {

  class BaseGreeter() {
    def getGreeting(): String = "Hello World!"
  }

  class GreetingRole() {
    def getGreeting(): String = "Hello World from SCROLL!"
  }

  override def onCreate(b: Bundle) {
    super.onCreate(b)
    setContentView(R.layout.main)
    val layout: FrameLayout = getLayoutInflater.inflate(TR.layout.main, null)

    Log.e("MainActivity", "Init Compartment")
    new Compartment {
      Log.e("MainActivity", "Init play")
      val greeter = new BaseGreeter() play new GreetingRole()
      Log.e("MainActivity", "Init greeting")
      val greeting: String = greeter.getGreeting()
      findView(TR.test_textview).setText(greeting)
    }
  }
}