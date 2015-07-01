import android.Keys._

platformTarget in Android := "android-22"

scalaVersion := "2.11.7"

name := "SCROLLAndroid"

android.Plugin.androidBuild

javacOptions in Compile ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

proguardCache in Android ++= Seq("com.github.max-leuthaeuser")

libraryDependencies ++= Seq("com.github.max-leuthaeuser" % "scroll_2.11" % "0.9.1")

proguardOptions in Android ++= Seq(
  "-dontobfuscate",
  "-dontoptimize",
  "-keepattributes Signature,InnerClasses,EnclosingMethod",
  "-dontwarn **",
  "-dontnote **",
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
