LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := jpegThumb
LOCAL_SRC_FILES := hello-jni.c jpeg_thumb.c
LOCAL_STATIC_LIBRARIES := epeg_static
LOCAL_C_INCLUDES :=$(LOCAL_PATH)/../epeg

include $(BUILD_SHARED_LIBRARY)
