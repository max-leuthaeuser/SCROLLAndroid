import android.Keys._

platformTarget in Android := "android-22"

scalaVersion := "2.11.6"

name := "SCROLLAndroid"

android.Plugin.androidBuild

javacOptions in Compile ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

libraryDependencies ++= Seq("com.github.max-leuthaeuser" % "scroll_2.11" % "0.6")

dexMulti in Android := true

sourceGenerators in Compile := Seq((sourceGenerators in Compile).value.last)

proguardOptions in Android ++= Seq(
  "-dontobfuscate",
  "-dontoptimize",
  "-dontskipnonpubliclibraryclasses",
  "-dontskipnonpubliclibraryclassmembers",
  "-keepattributes Signature,InnerClasses,EnclosingMethod",
  "-keepattributes *Annotation*",
  "-dontwarn com.google.common.**",
  "-dontwarn jline.console.**",
  "-dontwarn org.fusesource.jansi.internal.**",
  "-dontwarn scalax.collection.GraphBase**",
  "-dontwarn scalax.collection.GraphTraversal**",
  "-dontnote com.google.common.util.concurrent.**",
  "-keep class scalax.collection.**",
  "-keep class scala.collection.**",
  "-keep class internal.**",
  // for reflections
  "-keep class scala.AnyVal",
  "-keep class scala.Array",
  "-keep class scala.Boolean",
  "-keep class scala.Byte",
  "-keep class scala.Char",
  "-keep class scala.Double",
  "-keep class scala.Float",
  "-keep class scala.Int",
  "-keep class scala.Long",
  "-keep class scala.Short",
  "-keep class scala.Unit",
  "-keep class scala.reflect.**",
  "-keepclassmembers class * { ** item; ** bytes(); }"
)