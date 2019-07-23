<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
   android:orientation="vertical"
    tools:context=".BluetoothConnect">
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Start"
        android:id="@+id/action_scan" />
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Stop"
        android:id="@+id/action_stop"/>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="test"
        android:id="@+id/test"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text=""
        android:id="@+id/text_view" />
</LinearLayout>
