package com.os1.util.jpegThumb;

public class JpegThumb {
    static {
        System.loadLibrary("jpegThumb");
    }
    /* A native method that is implemented by the
     * 'hello-jni' native library, which is packaged
     * with this application.
     */
    public static native String  getLibraryInfo();
    
	public static native int jpegThumbFile(String src,String dest, int width, int height, int quality);
	 
}
