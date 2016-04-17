package com.assistant.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

import com.assistant.db.model.OneApp;
import com.assistant.models.enums.ErrorMessageEnum;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.service.FileService;
import com.assistant.utils.ResultHelper;

/**
 * @author hefan.hf
 * @version $Id: FileServiceImpl, v 0.1 16/4/17 14:04 hefan.hf Exp $
 */
@Service("fileService")
public class FileServiceImpl extends BaseService implements FileService {

    /** ONE图片保存目录 */
    private static final String DOWNLOAD_PATH = "/root/files/ones/";

    @Override
    public BaseServiceResult downloadOnePic(OneApp one) {

        BaseServiceResult result = new BaseServiceResult();

        String filePath = DOWNLOAD_PATH + one.getTitle() + ".jpg";
        one.setImgAddr(filePath);
        logger.debug(filePath);

        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        try {

            if (isExitsPath(filePath)) {
                //文件已存在,幂等.
                logger.warn("下载ONE图片时,本地已存在.幂等." + one);
                return result;
            }

            URL url = new URL(one.getImgUrl());
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(filePath);

            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            logger.info("下载ONE图片成功." + one);
        } catch (InterruptedException e) {
            logger.error("下载ONE图片时出错." + one, e);
            ResultHelper.fillFailure(result, ErrorMessageEnum.UNKNOWN_EXCEPTION);
        } catch (FileNotFoundException e) {
            logger.error("下载ONE图片时出错." + one, e);
            ResultHelper.fillFailure(result, ErrorMessageEnum.UNKNOWN_EXCEPTION);
        } catch (IOException e) {
            logger.error("下载ONE图片时出错." + one, e);
            ResultHelper.fillFailure(result, ErrorMessageEnum.UNKNOWN_EXCEPTION);
        }
        return result;
    }

    /**
     * 判断路径是否已经存在,不存在则沿路创建
     * @param path
     * @return
     * @throws InterruptedException
     */
    public boolean isExitsPath(String path) throws InterruptedException {
        String[] paths = path.split("/");
        StringBuffer fullPath = new StringBuffer();
        for (int i = 0; i < paths.length; i++) {
            fullPath.append(paths[i]).append("/");
            File file = new File(fullPath.toString());

            if (paths.length - 1 != i) {//判断path到文件名时，无须继续创建文件夹！
                if (!file.exists()) {
                    file.mkdir();
                    logger.debug("创建目录为：" + fullPath.toString());
                }
            }
        }
        File file = new File(fullPath.toString());//目录全路径
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
}