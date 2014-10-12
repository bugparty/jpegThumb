#include <Epeg.h>
#include "jpeg_thumb.h"


JPEG_THUMB_STATUS jpeg_thumb_file_(char* src,char* dst,JPEG_THUMB_CONFIG* config ){
	Epeg_Image * image;
	int ch;
	image = epeg_file_open(src);
	if (!image) {
		return JPEG_THUMB_STATUS_SRC_FILE_NOT_EXIST;
	}

	epeg_decode_size_set(image, config->width, config->height);
	epeg_quality_set    (image, config->quality);
	epeg_file_output_set(image, dst);
	epeg_encode(image);
	epeg_close(image);
	return JPEG_THUMB_STATUS_OK;

}
JPEG_THUMB_STATUS jpeg_thumb_file(const char* src,const char* dst,int width,int height, int quality ){
	Epeg_Image * image;
	int ch;
	image = epeg_file_open(src);
	if (!image) {
		return JPEG_THUMB_STATUS_SRC_FILE_NOT_EXIST;
	}

	epeg_decode_size_set(image, width, height);
	epeg_quality_set    (image, quality);
	epeg_file_output_set(image, dst);
	epeg_encode(image);
	epeg_close(image);
	return JPEG_THUMB_STATUS_OK;

}
