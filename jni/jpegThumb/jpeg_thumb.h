#define JPEG_THUMB_STATUS_SRC_FILE_NOT_EXIST -1
#define JPEG_THUMB_STATUS_DEST_FILE_NOT_EXIST -2
#define JPEG_THUMB_STATUS_OK 0

typedef int JPEG_THUMB_STATUS;
struct _JPEG_THUMB_CONFIG{
	int quality;
	int height;
	int width;
};
typedef struct _JPEG_THUMB_CONFIG JPEG_THUMB_CONFIG;


JPEG_THUMB_STATUS jpeg_thumb_file(const char* src,const char* dst,int width,int height, int quality );
